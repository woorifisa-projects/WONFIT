package com.woori.wonfit.member.member.service;

import com.woori.wonfit.config.CookieConfig;
import com.woori.wonfit.config.JwtFilter;
import com.woori.wonfit.config.JwtUtil;
import com.woori.wonfit.log.loginlog.domain.LoginLog;
import com.woori.wonfit.log.loginlog.repository.LoginLogRepository;
import com.woori.wonfit.member.investtype.service.InvestTypeService;
import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.member.member.dto.MemberDetails;
import com.woori.wonfit.member.member.dto.MemberDto;
import com.woori.wonfit.member.member.dto.MemberRegisterRequest;
import com.woori.wonfit.member.member.repository.MemberRepository;
import com.woori.wonfit.member.memberinfo.domain.MemberInfo;
import com.woori.wonfit.member.memberinfo.repository.MemberInfoRepository;
import com.woori.wonfit.member.memberinfo.service.MemberInfoService;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final MemberInfoRepository memberInfoRepository;
    private final LoginLogRepository loginLogRepository;

    private final InvestTypeService investTypeService;
    private final MemberInfoService memberInfoService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final JwtFilter jwtFilter;
    private final CookieConfig cookieConfig;


    @Value("${jwt.token.access}")
    private String accessKey;
    @Value("${jwt.token.refresh}")
    private String refreshKey;

    private LocalDateTime dateTime = LocalDateTime.now();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Long accessTokenExpireTime = 1000 * 60 * 60l;
    private Long refreshTokenExpireTime = 1000 * 60 * 60 * 24l;


    @Override
    @Transactional
    public MemberDto register(MemberRegisterRequest request) {
        memberRepository.findByLoginId(request.getLoginId())
                .ifPresent(member -> {
                    throw new RuntimeException();
                });

        Member saveMember = memberRepository.save(request.toEntity(bCryptPasswordEncoder.encode(request.getPassword())));

        Member member = memberRepository.findById(saveMember.getId()).get();
        investTypeService.registInvestment(member);

        MemberInfo memberInfo = MemberInfo.builder().member(member).build();
        memberInfoRepository.save(memberInfo);

        return MemberDto.fromEntity(saveMember);
    }

    @Override
    public Cookie login(String loginId, String memberPw, HttpServletRequest request) {
        Member member = memberRepository.findByLoginId(loginId)
                .orElseThrow(() -> new RuntimeException("회원정보를 찾을 수 없습니다."));

        if (!bCryptPasswordEncoder.matches(memberPw, member.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        if (!member.isStatus()) {
            throw new IllegalArgumentException("이미 탈퇴한 회원입니다.");
        } else {
            String loginTime = dateTime.format(formatter).substring(0, 19);
            String loginIp = request.getRemoteAddr();
            String userAgent = request.getHeader("User-Agent");
            String loginBrowser = extractBrowser(userAgent);
            String loginDevice = extractDevice(userAgent);

            LoginLog loginLog = LoginLog.toEntity(member, loginTime, loginIp, loginBrowser, loginDevice);
            loginLogRepository.save(loginLog);

            String accessToken = JwtUtil.createAccessToken(member.getId().toString(), accessTokenExpireTime, "USER", accessKey);
            String refreshToken = JwtUtil.createRefreshToken(member.getId().toString(), refreshTokenExpireTime, "USER", refreshKey);

            Cookie cookie = cookieConfig.createCookie(accessToken);

            member.setRefreshToken(refreshToken);
            memberRepository.save(member);

            jwtFilter.setFlag(true);

            return cookie;
        }
    }

    @Override
    public Cookie logout(HttpServletRequest request) {
        String token = cookieConfig.parseCookie(request);
        Long id = cookieConfig.getIdFromToken(token);

        Member member = memberRepository.findById(id).get();

        member.setRefreshToken("");
        memberRepository.save(member);

        Cookie cookie = cookieConfig.createCookie("");

        jwtFilter.setFlag(false);

        return cookie;
    }

    @Override
    public String extractBrowser(String userAgent) {
        UserAgent ua = UserAgent.parseUserAgentString(userAgent);
        return ua.getBrowser().getName();
    }

    @Override
    public String extractDevice(String userAgent) {
        UserAgent ua = UserAgent.parseUserAgentString(userAgent);
        return ua.getOperatingSystem().getDeviceType().getName();
    }

    @Override
    public List<Member> getAllMembers() {
        List<Member> member = memberRepository.findAll();
        return member;
    }

    @Override
    public MemberDetails findById(Long id) {
        Optional<Member> member = memberRepository.findById(id);

        MemberInfo memberInfo = memberInfoService.findByMemberId(id);

        MemberDetails memberDetails = MemberDetails.fromEntity(member.get(), memberInfo);

        return memberDetails;
    }

    @Override
    public String leaveMember(String loginId, String password) {
        Member member = memberRepository.findByLoginId(loginId).orElseThrow(() -> new RuntimeException("회원 정보를 찾을 수 없습니다."));

        if (!bCryptPasswordEncoder.matches(password, member.getPassword())) {
            return "비밀번호가 일치하지 않습니다.";
        } else {
            member.setStatus(false);
            memberRepository.save(member);
            return "회원 탈퇴가 완료되었습니다.";
        }
    }

    @Override
    public void updateMemberDetails(Long id, MemberDetails memberDetails) {

        Member member = Member.toEntity(id, memberDetails);
        memberRepository.save(member);

        MemberInfo memberInfo = MemberInfo.toEntity(member, memberDetails);
        memberInfoRepository.save(memberInfo);
    }

}
