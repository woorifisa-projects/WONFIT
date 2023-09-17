package com.woori.wonfit.member.bank.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
@Slf4j
public class CookieUtils {
    public static List<String> parseSelectBankCookie(String selectBankCookie) {
        log.info("parseSelectBankCookie called");
        try {
            String decoded = URLDecoder.decode(selectBankCookie, StandardCharsets.UTF_8.name());
            ObjectMapper mapper = new ObjectMapper();
            List<String> bankNames = Arrays.asList(mapper.readValue(decoded, String[].class));
            return bankNames;
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse selectBank cookie", e);
        }
    }
}
