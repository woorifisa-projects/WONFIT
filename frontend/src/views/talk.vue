<template>
    <div>
        <form @submit.prevent="sendMessage">
            <input type="text" v-model="senderPhoneNumber" placeholder="발신자 전화번호">
            <input type="text" v-model="receiverPhoneNumber" placeholder="수신자 전화번호">
            <input type="text" v-model="messageContent" placeholder="메시지 내용">
            <button type="submit">메시지 전송</button>
        </form>
    </div>
</template>
  
<script setup>
import { ref } from 'vue';
import CryptoJS from "crypto-js";

const senderPhoneNumber = ref('');
const receiverPhoneNumber = ref('');
const messageContent = ref('');

function sendMessage() {
    var user_phone_number = receiverPhoneNumber.value;
    var resultCode = 404;

    const date = Date.now().toString();
    const uri = "ncp:sms:kr:314756095679:wonfit-sms-service";
    const secretKey = "PvqIcNh9p4lJpr6IGM2wXDUAxOpHVb7plnCAoids";
    const accessKey = "nzsn8K2TrvZIx6Nl9C5I";
    const method = "POST";
    const space = " ";
    const newLine = "\n";
    const url2 = `/sms/v2/services/${uri}/messages`;

    const hmac = CryptoJS.algo.HMAC.create(CryptoJS.algo.SHA256, secretKey);

    hmac.update(method);
    hmac.update(space);
    hmac.update(url2);
    hmac.update(newLine);
    hmac.update(date);
    hmac.update(newLine);
    hmac.update(accessKey);

    const hashBytesArray = hmac.finalize();
    const signature = hashBytesArray.toString(CryptoJS.enc.Base64);

    const url = `https://sens.apigw.ntruss.com/sms/v2/services/${uri}/messages`;
    const body = {
        type: 'SMS',
        countryCode: '82',
        from: senderPhoneNumber.value,
        content: messageContent.value,
        messages: [
            {
                to: user_phone_number
            }
        ]
    };

    fetch(url, {
        //mode: 'no-cors',
        method: 'POST',
        headers: {
            'Content-Type': 'application/json; charset=utf-8',
            'x-ncp-apigw-timestamp': date,
            'x-ncp-iam-access-key': accessKey,
            'x-ncp-apigw-signature-v2': signature,
        },
        body: JSON.stringify(body)
    })
        .then(res => res.json())
        .then(data => {
            console.log(data);
            resultCode = 200;
        })
        .catch(err => {
            console.error(err);
        });
}

</script>
  
<style lang="scss" scoped></style>
  