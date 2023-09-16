package com.woori.wonfit.member.member.service;

import com.woori.wonfit.config.CookieConfig;
import com.woori.wonfit.config.JwtUtil;
import com.woori.wonfit.log.loginlog.domain.LoginLog;
import com.woori.wonfit.log.loginlog.repository.LoginLogRepository;
import com.woori.wonfit.member.investtype.service.InvestTypeService;
import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.member.member.dto.*;
import com.woori.wonfit.member.member.repository.MemberRepository;
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

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final LoginLogRepository loginLogRepository;

    private final InvestTypeService investTypeService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
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

        Member saveMember = memberRepository.save(request.toEntity(bCryptPasswordEncoder.encode(request.getPassword()), bCryptPasswordEncoder.encode(request.getBankAccountPassword())));
        log.info("saveMember loginId = {}", saveMember.getLoginId());
        investTypeService.registInvestment(saveMember);

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

            Cookie cookie = cookieConfig.createHttpOnlyCookie(accessToken);

            member.setRefreshToken(refreshToken);
            memberRepository.save(member);

            return cookie;
        }
    }

    @Override
    public Cookie logout(String id) {
        Member member = memberRepository.findById(Long.parseLong(id)).get();

        member.setRefreshToken("");
        memberRepository.save(member);

        Cookie cookie = cookieConfig.createHttpOnlyCookie("");

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
    public List<MembersResponse> getAllMembers() {
        List<MembersResponse> member = memberRepository.selectMembersData();
        return member;
    }

    @Override
    public MemberUpdateRequest findById(String id) {
        Member member = memberRepository.findById(Long.parseLong(id)).get();
        return MemberUpdateRequest.toNewDetail(member);
    }

    @Override
    public Cookie leaveMember(String loginId, String password, String id) {
        Member member = memberRepository.findById(Long.parseLong(id)).orElseThrow(() -> new RuntimeException("회원 정보를 찾을 수 없습니다."));

        if (!bCryptPasswordEncoder.matches(password, member.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        } else {
            Cookie cookie = logout(id);
            member.setStatus(false);
            memberRepository.save(member);
            return cookie;
        }
    }

    @Override
    public void updateMemberDetails(String id, MemberDetatilUpdateRequest memberDetatilUpdateRequest) {
        Member basicMember = memberRepository.findById(Long.parseLong(id)).orElseThrow(() -> new RuntimeException("회원 정보를 찾을 수 없습니다."));

        String password = bCryptPasswordEncoder.encode(memberDetatilUpdateRequest.getPassword());

        Member updateMember = basicMember.toEntity(Long.parseLong(id), basicMember, memberDetatilUpdateRequest, password, basicMember.getRefreshToken(), basicMember.getBankAccountPassword());
        memberRepository.save(updateMember);
    }
    @Override
    @Transactional
    public void updateMemberMydata(Long id, Member member) {
        memberRepository.updateMemberMydata(id, member.getAnnualIncome(), member.getAgeGroup());
    }

    @Override
    @Transactional
    public void updateMemberMarketing(Long id, Member member) {
        memberRepository.updateMemberMarketing(member.isMarketingInfoAgree(),id);
    }
}
