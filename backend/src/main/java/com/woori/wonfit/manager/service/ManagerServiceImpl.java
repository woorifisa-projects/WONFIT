package com.woori.wonfit.manager.service;

import com.woori.wonfit.config.CookieConfig;
import com.woori.wonfit.config.JwtUtil;
import com.woori.wonfit.manager.domain.Manager;
import com.woori.wonfit.manager.dto.ManagerLoginRequest;
import com.woori.wonfit.manager.dto.DeleteMemberRequest;
import com.woori.wonfit.manager.dto.ManagerRegisterRequest;
import com.woori.wonfit.manager.repository.ManagerRepository;
import com.woori.wonfit.member.member.repository.MemberRepository;
import com.woori.wonfit.product.deposit.domain.Deposit;
import com.woori.wonfit.product.deposit.dto.DepositRequest;
import com.woori.wonfit.product.deposit.repository.DepositRepository;
import com.woori.wonfit.product.fund.domain.Fund;
import com.woori.wonfit.product.fund.dto.FundRequest;
import com.woori.wonfit.product.fund.repository.FundRepository;
import com.woori.wonfit.product.savings.domain.Savings;
import com.woori.wonfit.product.savings.dto.SavingsRequest;
import com.woori.wonfit.product.savings.repository.SavingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private final FundRepository fundRepository;
    private final SavingsRepository savingsRepository;
    private final DepositRepository depositRepository;
    private final MemberRepository memberRepository;
    private final ManagerRepository managerRepository;

    private final CookieConfig cookieConfig;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Value("${jwt.token.access}")
    private String accessKey;
    @Value("${jwt.token.refresh}")
    private String refreshKey;
    private Long accessTokenExpireTime = 1000 * 60 * 60l;
    private Long refreshTokenExpireTime = 1000 * 60 * 60 * 24l;

    @Override
    public String managerRegister(ManagerRegisterRequest request){
        Manager manager = Manager.builder().loginId(request.getLoginId()).password(request.getPassword()).build();
        managerRepository.save(manager);
        return "매니저 회원가입이 왼료되었습니다.";
    }

    @Override
    public Cookie managerLogin(ManagerLoginRequest request){
        Manager manager = managerRepository.findByLoginId(request.getLoginId()).orElseThrow(() -> new RuntimeException("매니저 정보를 찾을 수 없습니다."));;

        if (!bCryptPasswordEncoder.matches(request.getPassword(), manager.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }else {
            String accessToken = JwtUtil.createAccessToken(manager.getId().toString(), accessTokenExpireTime, "ADMIN", accessKey);
            String refreshToken = JwtUtil.createRefreshToken(manager.getId().toString(), refreshTokenExpireTime, "ADMIN", refreshKey);

            Cookie cookie = cookieConfig.createCookie(accessToken);

            manager.setRefreshToken(refreshToken);
            managerRepository.save(manager);

            return cookie;
        }
    }
    @Override
    public Fund createFund(FundRequest fundRequest) {
        Fund fund = Fund.builder()
                .fundName(fundRequest.getFundName())
                .fundInfo(fundRequest.getFundInfo())
                .fundDesc(fundRequest.getFundDesc())
                .returnRate1(fundRequest.getReturnRate1())
                .returnRate2(fundRequest.getReturnRate2())
                .fundPrice(fundRequest.getFundPrice())
                .fundType(fundRequest.getFundType())
                .build();

        return fundRepository.save(fund);
    }

    @Override
    public Savings createSavings(SavingsRequest savingsRequest) {
        Savings savings = Savings.builder()
                .savingsName(savingsRequest.getSavingsName())
                .savingsInfo(savingsRequest.getSavingsInfo())
                .savingsDesc(savingsRequest.getSavingsDesc())
                .interestRate(savingsRequest.getInterestRate())
                .period(savingsRequest.getPeriod())
                .target(savingsRequest.getTarget())
                .maxDeposit(savingsRequest.getMaxDeposit())
                .savingsType(savingsRequest.getSavingsType())
                .build();

        return savingsRepository.save(savings);
    }

    @Override
    public Deposit createDeposit(DepositRequest depositRequest) {
        Deposit deposit = Deposit.builder()
                .depositName(depositRequest.getDepositName())
                .depositInfo(depositRequest.getDepositInfo())
                .depositDesc(depositRequest.getDepositDesc())
                .depositType(depositRequest.getDepositType())
                .interestRate(depositRequest.getInterestRate())
                .period(depositRequest.getPeriod())
                .target(depositRequest.getTarget())
                .minDeposit(depositRequest.getMinDeposit())
                .build();

        return depositRepository.save(deposit);
    }

    @Override
    public void deleteFund(Long id) {
        fundRepository.deleteById(id);
    }

    @Override
    public void deleteDeposit(Long id) {
        depositRepository.deleteById(id);
    }

    @Override
    public void deleteSavings(Long id) {
        savingsRepository.deleteById(id);
    }

    @Override
    public String deleteMember(DeleteMemberRequest request){
        memberRepository.deleteById(request.getId());
        return "회원 정보 삭제가 왼료되었습니다.";
    }
}

