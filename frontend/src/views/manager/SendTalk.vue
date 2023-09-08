<template>
  <v-app id="inspire" style="margin-top: 20px">
    <v-main class="bg-grey-lighten-3">
      <v-container>
        <v-row>
          <v-col cols="3">
            <v-sheet rounded="lg">
              <v-list rounded="lg">
                <v-list-item class="logo-text" @click="navigateToManagerPage"
                  >사용자 관리</v-list-item
                >
                <v-list-item class="logo-text" @click="navigateToManageProduct"
                  >상품 관리</v-list-item
                >
                <v-list-item class="logo-text" @click="navigateToManageLog"> 로그 관리</v-list-item>
                <v-list-item class="logo-text" @click="navigateToSendTalk"
                  >알림톡 보내기</v-list-item
                >
              </v-list>
            </v-sheet>
          </v-col>

          <v-col>
            <v-sheet class="logo-text" style="padding: 10px" min-height="70vh" rounded="lg">
              <div>
                <v-table fixed-header height="300px">
                  <thead>
                    <tr>
                      <th></th>
                      <th class="text-left">번호</th>
                      <th class="text-left">성함</th>
                      <th class="text-left">아이디</th>
                      <th class="text-left">회원상태</th>
                      <th class="text-left">가입일자</th>
                    </tr>
                  </thead>
                  <template v-slot:column.name="{ column }">
                    {{ column.title.toUpperCase() }}
                  </template>
                  <tbody>
                    <tr v-for="item in users" :key="item.idx">
                      <v-checkbox style="margin-top: 1.3rem"></v-checkbox>
                      <td>{{ item.idx }}</td>
                      <td>{{ item.name }}</td>
                      <td>{{ item.id }}</td>
                      <td>{{ item.status }}</td>
                      <td>{{ item.rgDate }}</td>
                    </tr>
                  </tbody>
                </v-table>
              </div>

              <div class="d-flex justify-center" style="padding-bottom: 30px">
                <form @submit.prevent="sendMessage">
                  <input type="text" v-model="senderPhoneNumber" placeholder="발신자 전화번호" />
                  <input type="text" v-model="receiverPhoneNumber" placeholder="수신자 전화번호" />
                  <br /><br />
                  <!-- <input type="text" v-model="messageContent" placeholder="메시지 내용을 입력해주세요."><br><br> -->
                  <!-- <button type="submit">메시지 전송</button> -->

                  <v-text-field
                    v-model="messageContent"
                    placeholder="메시지 내용을 입력해주세요."
                  ></v-text-field>
                  <v-btn color="blue" style="margin-left: 100px"> 메시지 전송 </v-btn>
                </form>
              </div>
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script setup>
import { ref } from "vue";
import CryptoJS from "crypto-js";

const senderPhoneNumber = ref("");
const receiverPhoneNumber = ref("");
const messageContent = ref("");

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
    type: "SMS",
    countryCode: "82",
    from: senderPhoneNumber.value,
    content: messageContent.value,
    messages: [
      {
        to: user_phone_number,
      },
    ],
  };

  fetch(url, {
    //mode: 'no-cors',
    method: "POST",
    headers: {
      "Content-Type": "application/json; charset=utf-8",
      "x-ncp-apigw-timestamp": date,
      "x-ncp-iam-access-key": accessKey,
      "x-ncp-apigw-signature-v2": signature,
    },
    body: JSON.stringify(body),
  })
    .then((res) => res.json())
    .then((data) => {
      console.log(data);
      resultCode = 200;
    })
    .catch((err) => {
      console.error(err);
    });
}

import { useRouter } from "vue-router";

const router = useRouter();

const navigateToManagerPage = () => {
  router.push({ name: "ManagerPage" });
};

const navigateToManageProduct = () => {
  router.push({ name: "ManageProduct" });
};

const navigateToSendTalk = () => {
  router.push({ name: "SendTalk" });
};

const navigateToManageLog = () => {
  router.push({ name: "ManageLog" });
};
</script>

<style scoped>
@font-face {
  font-family: "WooridaumB";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2205@1.0/WooridaumB.woff2")
    format("woff2");
  font-weight: 300;
  font-style: normal;
}

.logo-text {
  font-size: 15px;
  font-family: "WooridaumB", sans-serif;
}
</style>
