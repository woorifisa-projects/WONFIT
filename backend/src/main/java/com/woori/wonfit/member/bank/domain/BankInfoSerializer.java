package com.woori.wonfit.member.bank.domain;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class BankInfoSerializer extends JsonSerializer<BankInfo> {
    @Override
    public void serialize(BankInfo bankinfo, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("bankName", bankinfo.getBankName());
        jsonGenerator.writeNumberField("money", bankinfo.getMoney());
        jsonGenerator.writeEndObject();
    }
}