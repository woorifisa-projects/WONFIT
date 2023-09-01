<template>
  <v-app id="inspire" style="margin-top:20px">

    <v-main class="bg-grey-lighten-3">
      <v-container>
        <v-row>
          <v-col cols="3">
            <v-sheet rounded="lg">
              <v-list rounded="lg">



                <v-list-item class="logo-text" @click="navigateToMyInfo">내 정보 보기</v-list-item>
                <v-list-item class="logo-text" @click="navigateToMySubscribeProduct">내 가입상품 확인하기</v-list-item>
                <v-list-item class="logo-text" @click="navigateToMyLikedProduct">내 관심상품 확인하기</v-list-item>
                <v-list-item class="logo-text" @click="navigateToRecommend">나의 투자성향 보기</v-list-item>

                <v-divider class="my-2"></v-divider>

                <v-list-item class="logo-text" color="grey-lighten-4" link @click="navigateToWithdraw">
                  회원 탈퇴
                </v-list-item>
              </v-list>
            </v-sheet>
          </v-col>

          <v-col>
            <v-sheet min-height="70vh" rounded="lg"><v-table fixed-header height="500px">
                <thead>
                  <tr>
                    <th></th>
                    <th class="text-left">번호</th>
                    <th class="text-left">상품명</th>
                    <th class="text-left">분류</th>
                    <th class="text-left">등록일</th>
                    <th class="text-left">상태</th>

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
                    <td>{{ item.likedDate }}</td>
                    <td>{{ item.status }}</td>
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
const users = [
  {
    idx: 1,
    name: "우리WON예금",
    type: "예금",
    likedDate: "2023-08-29",
    status: "정상",
  },
  {
    idx: 2,
    name: "우리WON예금",
    type: "예금",
    likedDate: "2023-08-29",
    status: "정상",
  },
  {
    idx: 3,
    name: "우리WON예금",
    type: "예금",
    likedDate: "2023-08-29",
    status: "정상",
  },
];

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
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2205@1.0/WooridaumB.woff2") format("woff2");
  font-weight: 300;
  font-style: normal;
}

.logo-text {
  font-size: 15px;
  font-family: "WooridaumB", sans-serif;
}
</style>