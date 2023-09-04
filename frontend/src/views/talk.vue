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
import axios from 'axios';

const senderPhoneNumber = ref('');
const receiverPhoneNumber = ref('');
const messageContent = ref('');

function sendMessage() {
    const body = {
        //from: senderPhoneNumber.value,
        to: receiverPhoneNumber.value,
        content: messageContent.value,
    };

    axios.post("http://localhost:8080/manager/send/sms/message", body, { withCredentials: true })
    .then(data => {
        console.log(data);
        //resultCode = 200;
    })
    .catch(err => {
        console.error(err);
    });
}

</script>
  
<style lang="scss" scoped></style>
  