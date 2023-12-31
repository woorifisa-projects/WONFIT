package com.woori.wonfit.member.member.controller;

import com.woori.wonfit.member.bank.domain.BankInfo;
import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.member.member.dto.*;
import com.woori.wonfit.member.member.repository.MemberRepository;
import com.woori.wonfit.member.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;
    private final MemberRepository memberRepository;


    // 회원 가입
    @PostMapping("wonfit/register")
    public ResponseEntity<MemberRegisterResponse> register(@RequestBody MemberRegisterRequest memeberRegisterRequest) {
        MemberDto memberDto = memberService.register(memeberRegisterRequest);
        return new ResponseEntity<>(new MemberRegisterResponse(memberDto.getLoginId()), HttpStatus.OK);
    }

    // 로그인
    @PostMapping("wonfit/login")
    public ResponseEntity<MemberLoginResponse> login(@RequestBody MemberLoginRequest memberLoginRequest, HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = memberService.login(memberLoginRequest.getLoginId(), memberLoginRequest.getPassword(), request);
        response.addCookie(cookie);
        return new ResponseEntity<>(new MemberLoginResponse(memberLoginRequest.getLoginId()), HttpStatus.OK);
    }

    // 로그 아웃
    @PostMapping("member/logout")
    public ResponseEntity<Cookie> logout(@AuthenticationPrincipal String id, HttpServletResponse response) {
        Cookie cookie = memberService.logout(id);
        response.addCookie(cookie);
        return new ResponseEntity<>(cookie, HttpStatus.OK);
    }

    // 회원 탈퇴
    @PostMapping("member/leave")
    public ResponseEntity<String> leaveMember(@RequestBody MemberLoginRequest memberLoginRequest, @AuthenticationPrincipal String id, HttpServletResponse response) throws Exception {
        Cookie cookie = memberService.leaveMember(memberLoginRequest.getLoginId(), memberLoginRequest.getPassword(), id);
        response.addCookie(cookie);
        return new ResponseEntity<>("회원 탈퇴가 왼료되었습니다.", HttpStatus.OK);
    }

    // 사용자 전체 조회
    @GetMapping("manager/members")
    public ResponseEntity<List<MembersResponse>> getAllMembers() {
        log.info("members called");
        List<MembersResponse> member = memberService.getAllMembers();
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    // 사용자 마이페이지 내 상세정보 조회
    @GetMapping("member/detail")
    public ResponseEntity<MemberUpdateRequest> getMemberDetails(@AuthenticationPrincipal String id) {
        MemberUpdateRequest member = memberService.findById(id);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    // 사용자 마이페이지 상세정보 수정
    @PatchMapping("member/detail")
    public ResponseEntity<String> updateMemberDetails(@RequestBody MemberDetatilUpdateRequest memberDetatilUpdateRequest, @AuthenticationPrincipal String id) {
        memberService.updateMemberDetails(id, memberDetatilUpdateRequest);
        return ResponseEntity.ok("수정이 완료되었습니다.");
    }

    @Transactional
    @PatchMapping("member/mydata")
    public ResponseEntity<String> updateMemberMydata(@RequestBody Member member, @AuthenticationPrincipal String id) {
        log.info("updateMemberMydata called");
        memberService.updateMemberMydata(Long.parseLong(id), member);
        return ResponseEntity.ok("수정이 완료되었습니다.");
    }

    @Transactional
    @PatchMapping("member/marketing")
    public ResponseEntity<String> updateMemberMarketing(@RequestBody Member member, @AuthenticationPrincipal String id) {
        log.info("updateMemberMarketing called");
        memberService.updateMemberMarketing(Long.parseLong(id), member);
        return ResponseEntity.ok("수정이 완료되었습니다.");
    }

    @GetMapping("member/islogin")
    public ResponseEntity<Boolean> isLogin(@AuthenticationPrincipal String id) {
        log.info("isLogin controller called");
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/member/mydata")
    public ResponseEntity<List<BankInfo>> getBankDataForSelectedBanks(@CookieValue(name = "selectedBank", required = false) String selectedBankCookie,
                                                                      @AuthenticationPrincipal String memberId) {
        log.info("getBankDataForSelectedBanks called");
        List<String> selectedBankNames = memberService.parseSelectBankCookie(selectedBankCookie); // parseSelectBankCookie 메서드 호출

        List<Object[]> results = memberRepository.getBankDataForSelectedBanks(Long.parseLong(memberId));
        results.forEach(result -> log.info("Bank name: {}, Money: {}", result[1], result[0]));

        List<BankInfo> bankInfoList = results.stream()
                .map(result -> new BankInfo((String) result[1], (Integer) result[0]))
                .filter(bankInfo -> selectedBankNames.contains(bankInfo.getBankName()))  // Add this line
                .collect(Collectors.toList());


        return new ResponseEntity<>(bankInfoList, HttpStatus.OK);
    }


}