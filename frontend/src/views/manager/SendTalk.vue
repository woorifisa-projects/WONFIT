<template>
  <v-app id="inspire" style="margin-top: 20px">
    <v-main class="bg-grey-lighten-3">
      <v-container>
        <v-row>
          <v-col cols="3">
            <v-sheet rounded="lg">
              <v-list rounded="lg">
                <v-list-item class="logo-text" @click="navigateToManagerPage">사용자 관리</v-list-item>
                <v-list-item class="logo-text" @click="navigateToManageProduct">상품 관리</v-list-item>
                <v-list-item class="logo-text" @click="navigateToManageLog"> 로그 관리</v-list-item>
                <v-list-item class="logo-text" @click="navigateToSendTalk">SMS</v-list-item>
              </v-list>
            </v-sheet>
          </v-col>
          <v-col>
            <v-sheet class="logo-text" style="padding: 10px" min-height="70vh" rounded="lg">
              <div>
                <v-table fixed-header height="700px">
                  <thead>
                    <tr>
                      <th></th>
                      <th class="text-left">번호</th>
                      <th class="text-left">일시</th>
                      <th class="text-left">발신자 번호</th>
                      <th class="text-left">수신자 번호</th>
                      <th class="text-left">메시지 내용</th>
                      <th class="text-left">상태</th>
                    </tr>
                  </thead>
                  <template v-slot:column.name="{ column }">
                    {{ column.title.toUpperCase() }}
                  </template>
                  <tbody>
                    <tr v-for="item in reversedSmsData" :key="item.idx">
                      <v-checkbox style="margin-top: 1.3rem"></v-checkbox>
                      <td>{{ item.id }}</td>
                      <td>{{ item.sendDate }}</td>
                      <td>{{ item.from }}</td>
                      <td>{{ item.to }}</td>
                      <td>{{ item.content }}</td>
                      <td>
                        <span v-if="item.status">O</span>
                        <span v-else>X</span>
                      </td>
                    </tr>
                  </tbody>
                </v-table>
              </div>
            </v-sheet>
            <v-col class="d-flex align-center">
              <div class="d-flex justify-end align-center" style="width: 100%; height: 100%;">
                <div class="d-flex justify-end"> <!-- 이 부분 추가 -->
                  <v-btn color="blue" style="margin-left: 100px" @click="showModal = true">메시지 전송</v-btn>
                </div>
              </div>
            </v-col>
            <v-dialog v-model="showModal" max-width="500px">
              <v-card>
                <v-card-title>메시지 전송</v-card-title>
                <v-card-text>
                  <form @submit.prevent="sendMessage">
                    <v-select :items="['010-3203-7238']" label="발신자 전화번호" required></v-select>
                    <v-text-field v-model="receiverPhoneNumberModal" label="수신자 전화번호"></v-text-field>
                    <v-textarea v-model="messageContentModal" label="메시지 내용" maxlength="90"></v-textarea>
                    <div class="text-right">
                      <v-btn color="blue" text @click.native="showModal = false">취소</v-btn>
                      <v-btn color="blue" text type="submit">전송</v-btn>
                    </div>
                  </form>
                </v-card-text>
              </v-card>
            </v-dialog>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script setup>
import { ref } from "vue";
import { onMounted } from "vue";
import { computed } from 'vue';

import axios from 'axios';

const showModal = ref(false);

const smsData = ref([]);
const reversedSmsData = computed(() => [...smsData.value].reverse());

onMounted(fetchSmsData);

async function fetchSmsData() {
  try {
    const response = await axios.get("http://localhost:8080/manager/sms", { withCredentials: true });
    smsData.value = response.data;
  } catch (error) {
    console.error(error);
  }
}


const receiverPhoneNumberModal = ref("");
const messageContentModal = ref("");

async function sendMessage() {
  const body = {
    to: receiverPhoneNumberModal.value,
    content: messageContentModal.value,
  };

  try {
    const response = await axios.post("http://localhost:8080/manager/sms", body, { withCredentials: true });
    console.log(response.data);

    showModal.value = false;

    fetchSmsData();

  } catch (error) {
    console.error(error);
  }
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
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2205@1.0/WooridaumB.woff2") format("woff2");
  font-weight: 300;
  font-style: normal;
}

.logo-text {
  font-size: 15px;
  font-family: "WooridaumB", sans-serif;
}

.d-flex.align-center {
  display: flex;
  align-items: center;
  justify-content: right;
  min-height: 5vh;
}

.text-right {
  text-align: right;
}
</style>
