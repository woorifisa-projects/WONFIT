<template>
  <v-app id="inspire" style="margin-top: 20px">
    <v-main class="bg-grey-lighten-3">
      <v-container>
        <v-row>
          <v-col cols="3">
            <v-sheet rounded="lg">
              <v-list rounded="lg">
                <v-list-item class="logo-text" @click="navigateToManagerPage">사용자 관리</v-list-item>
                <v-list-item class="logo-text" @click="loadData('예금')">상품 관리</v-list-item>

                <v-list-item class="logo-text" @click="navigateToSendTalk">SMS 관리</v-list-item>
              </v-list>
            </v-sheet>
          </v-col>

          <v-col>
            <v-sheet class="logo-text" style="padding: 10px" min-height="70vh" rounded="lg">
              <v-sheet>
                <v-card>
                  <v-tabs bg-color="blue" center-active class="d-flex justify-center" v-model="selectedTab">
                    <v-tab style="margin-left: 100px" @click="loadData('예금')">예금</v-tab>
                    <v-tab style="margin-left: 100px" @click="loadData('적금')">적금</v-tab>
                    <v-tab style="margin-left: 100px" @click="loadData('펀드')">펀드</v-tab>
                    <v-tab style="margin-left: 100px" @click="loadData('대출')">대출</v-tab>
                  </v-tabs>
                </v-card>

                <v-table fixed-header height="500px">
                  <!-- 테이블 헤더와 데이터 표시 부분 -->
                  <!-- 아래 v-for를 통해 각 탭에서 다른 데이터를 표시합니다. -->
                  <thead>
                    <tr>
                      <th></th>
                      <th class="text-left">번호</th>
                      <th class="text-left">상품명</th>
                      <th class="text-left">상품타입</th>
                      <th class="text-left">금리/수익률</th>
                    </tr>
                  </thead>
                  <template v-slot:column.name="{ column }">
                    {{ column.title.toUpperCase() }}
                  </template>
                  <tbody>
                    <tr v-for="(item, index) in currentTabData" :key="item.id">
                      <v-checkbox style="margin-top: 1.3rem"></v-checkbox>
                      <td>{{ index + 1 }}</td>
                      <!-- auto-increment로 설정된 idx 대신 루프 인덱스를 사용 -->
                      <td>{{ item.name }}</td>
                      <td>{{ item.ivtype }}</td>
                      <td>{{ item.irrate }}</td>
                    </tr>
                  </tbody>
                </v-table>
              </v-sheet>
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script setup>
import { useRouter } from "vue-router";
import { ref, watch } from "vue";
import axios from "axios";

const selectedTab = ref("예금"); // 초기 선택 탭 설정

const router = useRouter();

const currentTabData = ref([]); // 현재 선택된 탭의 데이터

const navigateToManagerPage = () => {
  router.push({ name: "ManagerPage" });
};

const navigateToSendTalk = () => {
  router.push({ name: "SendTalk" });
};

// 선택된 탭이 변경될 때마다 해당 탭의 데이터를 로드합니다.
watch(selectedTab, (newTab) => {
  loadData(newTab);
});

// 선택된 탭에 따라 데이터를 로드하는 함수
const loadData = async (tab) => {
  try {
    let endpoint = "";

    // 탭에 따라 다른 엔드포인트를 선택
    switch (tab) {
      case "예금":
        endpoint = "http://WONFIT.SITE:8080/product/deposit"; // 예금 데이터를 가져오는 엔드포인트
        break;
      case "적금":
        endpoint = "http://WONFIT.SITE:8080/product/savings"; // 적금 데이터를 가져오는 엔드포인트
        break;
      case "펀드":
        endpoint = "http://WONFIT.SITE:8080/product/fund"; // 펀드 데이터를 가져오는 엔드포인트
        break;
      case "대출":
        endpoint = "http://WONFIT.SITE:8080/product/loan"; // 대출 데이터를 가져오는 엔드포인트
        break;
      default:
        break;
    }

    // 서버로부터 데이터를 가져옴 (axios 또는 fetch 사용)
    const response = await axios.get(endpoint);

    if (response.status === 200) {
      // 각 탭에 따라 데이터 구조를 가공
      switch (tab) {
        case "예금":
          currentTabData.value = response.data.map((item) => ({
            name: item.depositName,
            ivtype: item.depositType,
            irrate: item.interestRate,
          }));
          break;
        case "적금":
          currentTabData.value = response.data.map((item) => ({
            name: item.savingsName,
            ivtype: item.savingsType,
            irrate: item.interestRate,
          }));
          break;
        case "펀드":
          currentTabData.value = response.data.map((item) => ({
            name: item.fundName,
            ivtype: item.fundType,
            irrate: item.returnRate1,
          }));
          break;
        case "대출":
          currentTabData.value = response.data.map((item) => ({
            name: item.loanName,
            ivtype: item.loanType,
            irrate: item.interestRate,
          }));
          break;
        default:
          break;
      }
    }
  } catch (error) {
    // 오류 처리
    console.error("데이터 로드 오류:", error);
  }
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
</style>
