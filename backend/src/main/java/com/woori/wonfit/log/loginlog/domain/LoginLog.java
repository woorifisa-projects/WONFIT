package com.woori.wonfit.log.loginlog.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.woori.wonfit.member.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "login_log")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "login_browser")
    private String loginBrowser; // login browser
    @Column(name = "login_device")
    private String loginDevice; // login device
    @Column(name = "login_time")
    private String loginTime; // login time
    @Column(name = "login_ip")
    private String loginIp; // login ip

    public static LoginLog toEntity(Member member, String loginTime, String loginIp, String loginBrowser, String loginDevice){
        return LoginLog.builder()
                .member(member)
                .loginBrowser(loginBrowser)
                .loginDevice(loginDevice)
                .loginTime(loginTime)
                .loginIp(loginIp)
                .build();
    }
}
