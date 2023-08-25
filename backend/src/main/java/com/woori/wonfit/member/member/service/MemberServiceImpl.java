package com.woori.wonfit.member.member.service;

import com.woori.wonfit.member.member.domain.JwtUtil;
import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.member.member.dto.MemberDetails;
import com.woori.wonfit.member.member.dto.MemberDto;
import com.woori.wonfit.member.member.dto.MemberRegisterRequest;
import com.woori.wonfit.member.member.repository.MemberRepository;
import com.woori.wonfit.member.memberinfo.domain.MemberInfo;
import com.woori.wonfit.member.memberinfo.service.MemberInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final MemberInfoService memberInfoService;
    @Value("${jwt.token.secret}")
    private String secretkey;
    private final long expireTimeMs = 1000 * 60 * 60 * 24; // 토큰 하루

    @Override
    public MemberDto register(MemberRegisterRequest request) {
        memberRepository.findByLoginId(request.getLoginId())
                .ifPresent(member -> {
                    throw new RuntimeException();
                });

        Member saveMember = memberRepository.save(request.toEntity(bCryptPasswordEncoder.encode(request.getPassword())));
        return MemberDto.fromEntity(saveMember);
    }
    @Override
    public String login(String loginId, String memberPw) {
        Member member = memberRepository.findByLoginId(loginId)
                .orElseThrow(() -> new RuntimeException("회원정보를 찾을 수 없습니다."));

        if (!bCryptPasswordEncoder.matches(memberPw, member.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        return JwtUtil.createToken(loginId, expireTimeMs);
    }
    @Override
    public List<Member> getAllMembers(){
        List<Member> member = memberRepository.findAll();
        return member;
    }
    @Override
    public MemberDetails findById(Long id){
        Optional<Member> member = memberRepository.findById(id);

        MemberInfo memberInfo = memberInfoService.findByMemberId(id);

        MemberDetails memberDetails = MemberDetails.fromEntity(member.get(), memberInfo);

        return memberDetails;
    }

    @Override
    public String leaveMember(String loginId, String password){
        Member member = memberRepository.findByLoginId(loginId).orElseThrow(() -> new RuntimeException("회원 정보를 찾을 수 없습니다."));

        if(!bCryptPasswordEncoder.matches(password, member.getPassword())){
            return "비밀번호가 일치하지 않습니다.";
        }
        else {
            member.setStatus(false);
            memberRepository.save(member);
            return "회원 탈퇴가 완료되었습니다.";
        }
    }
}
