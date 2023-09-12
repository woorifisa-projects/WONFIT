package com.woori.wonfit.log.smslog.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woori.wonfit.log.smslog.domain.MakeSignature;
import com.woori.wonfit.log.smslog.domain.Sms;
import com.woori.wonfit.log.smslog.dto.SmsRequest;
import com.woori.wonfit.log.smslog.dto.SmsSendRequest;
import com.woori.wonfit.log.smslog.dto.SmsSendResponse;
import com.woori.wonfit.log.smslog.repository.SmsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SmsServiceImpl implements SmsService {

    private final MakeSignature makeSignature;
    private final SmsRepository smsRepository;

    @Value("${access.key.id}")
    private String accessKey;
    @Value("${secret.key.id}")
    private String secretKey;
    @Value("${service.id}")
    private String serviceId;
    @Value("${sender.phone.number}")
    private String phoneNumber;

    private LocalDateTime dateTime = LocalDateTime.now();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String date = dateTime.format(formatter).substring(0, 19);

    @Override
    public SmsSendResponse sendSms(SmsRequest smsRequest) throws Exception {

        Long time = System.currentTimeMillis();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-ncp-apigw-timestamp", time.toString());
        headers.set("x-ncp-iam-access-key", accessKey);
        headers.set("x-ncp-apigw-signature-v2", makeSignature.makeSignature(time));

        List<SmsRequest> messages = new ArrayList<>();
        messages.add(smsRequest);

        SmsSendRequest request = SmsSendRequest.builder()
                .type("SMS")
                .contentType("COMM")
                .countryCode("82")
                .from(phoneNumber)
                .content(smsRequest.getContent())
                .messages(messages)
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String body = objectMapper.writeValueAsString(request);
        HttpEntity<String> httpBody = new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        SmsSendResponse response = restTemplate.postForObject(new URI("https://sens.apigw.ntruss.com/sms/v2/services/" + serviceId + "/messages"), httpBody, SmsSendResponse.class);

        Sms sms = Sms.toEntity(smsRequest, phoneNumber, date, true);
        smsRepository.save(sms);

        return response;
    }

    @Override
    public List<Sms> getAllSms() {
        List<Sms> smsList = smsRepository.findAll();
        return smsList;
    }
}