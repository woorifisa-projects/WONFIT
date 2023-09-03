package com.woori.wonfit.log.smslog.domain;

import com.woori.wonfit.log.smslog.dto.SmsRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "sender")
    private String to;
    @Column(name = "receiver")
    private String from;
    @Column(name = "content")
    private String content;
    @Column(name = "send_date")
    private String sendDate;
    @Column(name = "status")
    private boolean status;

    public static Sms toEntity(SmsRequest request, String from, String date, boolean status){
        return Sms.builder()
                .to(request.getTo())
                .from(from)
                .content(request.getContent())
                .sendDate(date)
                .status(status)
                .build();
    }
}
