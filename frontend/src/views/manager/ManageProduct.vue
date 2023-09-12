<template>
  <v-app id="inspire" style="margin-top: 20px">
    <v-main class="bg-grey-lighten-3">
      <v-container>
        <v-row>
          <v-col cols="3">
            <v-sheet rounded="lg">
              <v-list rounded="lg">
                <v-list-item class="logo-text" @click="navigateTo('ManagerPage')"
                  >사용자 관리</v-list-item
                >
                <v-list-item class="logo-text" @click="navigateTo('ManageProduct')"
                  >상품 관리</v-list-item
                >
                <v-list-item class="logo-text" @click="navigateTo('ManageLog')"
                  >로그 관리</v-list-item
                >
                <v-list-item class="logo-text" @click="navigateTo('SendTalk')"
                  >알림톡 보내기</v-list-item
                >
              </v-list>
            </v-sheet>
          </v-col>

          <v-col>
            <v-sheet class="logo-text" style="padding: 10px" min-height="70vh" rounded="lg">
              <v-card>
                <v-tabs bg-color="blue" center-active class="d-flex justify-center">
                  <v-tab @click="selectTab('예금')">예금</v-tab>
                  <v-tab @click="selectTab('적금')">적금</v-tab>
                  <v-tab @click="selectTab('대출')">대출</v-tab>
                  <v-tab @click="selectTab('펀드')">펀드</v-tab>
                </v-tabs>
              </v-card>
              <v-table fixed-header height="500px" v-if="selectedTab === '예금'">
                <thead>
                  <tr>
                    <th></th>
                    <th class="text-left">번호</th>
                    <th class="text-left">이름</th>
                    <th class="text-left">회원 아이디</th>
                    <th class="text-left">전화번호</th>
                    <th class="text-left">상태</th>
                  </tr>
                </thead>
                <template v-slot:column.name="{ column }">
                  {{ column.title.toUpperCase() }}
                </template>
                <tbody>
                  <tr v-for="item in memberData" :key="item.idx">
                    <v-checkbox style="margin-top: 1.3rem"></v-checkbox>
                    <td>{{ item.idx }}</td>
                    <td>{{ item.name }}</td>
                    <td>{{ item.loginId }}</td>
                    <td>{{ item.phoneNumber }}</td>
                    <td>
                      <span v-if="item.status">정상</span>
                      <span v-else>탈퇴</span>
                    </td>
                  </tr>
                </tbody>
              </v-table>
              <v-table fixed-header height="500px" v-if="selectedTab === '적금'">
                <thead>
                  <tr>
                    <th></th>
                    <th class="text-left">번호</th>
                    <th class="text-left">이름</th>
                    <th class="text-left">회원 아이디</th>
                    <th class="text-left">전화번호</th>
                    <th class="text-left">상태</th>
                  </tr>
                </thead>
                <template v-slot:column.name="{ column }">
                  {{ column.title.toUpperCase() }}
                </template>
                <tbody>
                  <tr v-for="item in memberData" :key="item.idx">
                    <v-checkbox style="margin-top: 1.3rem"></v-checkbox>
                    <td>{{ item.idx }}</td>
                    <td>{{ item.name }}</td>
                    <td>{{ item.loginId }}</td>
                    <td>{{ item.phoneNumber }}</td>
                    <td>
                      <span v-if="item.status">정상</span>
                      <span v-else>탈퇴</span>
                    </td>
                  </tr>
                </tbody>
              </v-table>
              <v-table fixed-header height="500px" v-if="selectedTab === '대출'">
                <thead>
                  <tr>
                    <th></th>
                    <th class="text-left">번호</th>
                    <th class="text-left">이름</th>
                    <th class="text-left">회원 아이디</th>
                    <th class="text-left">전화번호</th>
                    <th class="text-left">상태</th>
                  </tr>
                </thead>
                <template v-slot:column.name="{ column }">
                  {{ column.title.toUpperCase() }}
                </template>
                <tbody>
                  <tr v-for="item in memberData" :key="item.idx">
                    <v-checkbox style="margin-top: 1.3rem"></v-checkbox>
                    <td>{{ item.idx }}</td>
                    <td>{{ item.name }}</td>
                    <td>{{ item.loginId }}</td>
                    <td>{{ item.phoneNumber }}</td>
                    <td>
                      <span v-if="item.status">정상</span>
                      <span v-else>탈퇴</span>
                    </td>
                  </tr>
                </tbody>
              </v-table>
              <v-table fixed-header height="500px" v-if="selectedTab === '펀드'">
                <thead>
                  <tr>
                    <th></th>
                    <th class="text-left">번호</th>
                    <th class="text-left">이름</th>
                    <th class="text-left">회원 아이디</th>
                    <th class="text-left">전화번호</th>
                    <th class="text-left">상태</th>
                  </tr>
                </thead>
                <template v-slot:column.name="{ column }">
                  {{ column.title.toUpperCase() }}
                </template>
                <tbody>
                  <tr v-for="item in memberData" :key="item.idx">
                    <v-checkbox style="margin-top: 1.3rem"></v-checkbox>
                    <td>{{ item.idx }}</td>
                    <td>{{ item.name }}</td>
                    <td>{{ item.loginId }}</td>
                    <td>{{ item.phoneNumber }}</td>
                    <td>
                      <span v-if="item.status">정상</span>
                      <span v-else>탈퇴</span>
                    </td>
                  </tr>
                </tbody>
              </v-table>
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script setup>
import { useRouter, ref } from "vue-router";

const router = useRouter();
const selectedTab = ref("예금");

const navigateTo = (pageName) => {
  router.push({ name: pageName });
};

const selectTab = (tab) => {
  selectedTab.value = tab;
};

// You can fetch data for each tab as needed here.
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
