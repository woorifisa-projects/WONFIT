<template>
  <v-app id="inspire" style="margin-top: 20px">
    <v-main class="bg-grey-lighten-3">
      <v-container>
        <v-row>
          <v-col cols="3">
            <v-sheet rounded="lg">
              <v-list rounded="lg">
                <v-list-item class="logo-text" @click="navigateToMyPage">내 정보 보기</v-list-item>
                <v-list-item class="logo-text" @click="navigateToMySubscribeProduct"
                  >내 가입상품 확인하기</v-list-item
                >
                <v-list-item class="logo-text" @click="navigateToMyLikedProduct"
                  >내 관심상품 확인하기</v-list-item
                >
                <v-list-item class="logo-text" @click="navigateToRecommend"
                  >나의 투자성향 보기</v-list-item
                >

                <v-divider class="my-2"></v-divider>

                <v-list-item
                  class="logo-text"
                  color="grey-lighten-4"
                  link
                  @click="navigateToWithdraw"
                >
                  회원 탈퇴
                </v-list-item>
              </v-list>
            </v-sheet>
          </v-col>

          <v-col>
            <v-sheet min-height="70vh" rounded="lg"
              ><v-table fixed-header height="500px">
                <thead>
                  <tr>
                    <th></th>
                    <th class="text-left">번호</th>
                    <!--id-->
                    <th class="text-left">상품명</th>
                    <!--deposit_name-->
                    <th class="text-left">분류</th>
                    <!--deposit_type-->
                    <th class="text-left">금리</th>
                    <!--interest_rate-->
                  </tr>
                </thead>
                <template v-slot:column.name="{ column }">
                  {{ column.title.toUpperCase() }}
                </template>
                <tbody>
                  <tr v-for="item in users" :key="item.id">
                    <v-checkbox style="margin-top: 1.3rem"></v-checkbox>
                    <td>{{ item.idx }}</td>
                    <td>{{ item.name }}</td>
                    <td>{{ item.type }}</td>
                    <td>{{ item.irrate }}</td>
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
import axios from "axios";
import { ref, onMounted } from "vue";

const users = ref([]); // 초기에 빈 배열로 초기화

onMounted(async () => {
  try {
    const memberId = 1; // 대상 멤버 ID를 설정
    const response = await axios.get(`http://localhost:8080/member/mypage/liked/${memberId}`);
    const data = response.data;

    data.forEach((item) => {
      products.value.push({
        id: item.id,
        name: item.name,
        type: item.type,
        interestrate: item.interestrate,
      });
    });
  } catch (error) {
    console.error("데이터 가져오기 중 오류 발생:", error.message);
  }
});

import { useRouter } from "vue-router";
const router = useRouter();

const navigateToMyPage = () => {
  router.push({ name: "MyPage" });
};

const navigateToMySubscribeProduct = () => {
  router.push({ name: "MySubscribeProduct" });
};

const navigateToMyLikedProduct = () => {
  router.push({ name: "MyLikedProduct" });
};

const navigateToRecommend = () => {
  router.push({ name: "Recommend" });
};

const navigateToWithdraw = () => {
  router.push({ name: "Withdraw" });
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
