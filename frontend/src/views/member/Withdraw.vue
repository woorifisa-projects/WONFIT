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

                <v-list-item class="logo-text" @click="navigateToWithdraw">회원 탈퇴</v-list-item>
              </v-list>
            </v-sheet>
          </v-col>

          <v-col>
            <v-sheet min-height="70vh" rounded="lg">
              <div class="d-flex align-center" max-width="30px">
                <v-responsive class="mx-auto" max-width="600px" style="margin-top: -75px">
                  <v-text-field
                    :append-inner-icon="visible ? 'mdi-eye-off' : 'mdi-eye'"
                    :type="visible ? 'text' : 'password'"
                    density="compact"
                    placeholder="Enter your password"
                    prepend-inner-icon="mdi-lock-outline"
                    variant="outlined"
                    style="margin-top: 130px"
                    @click:append-inner="visible = !visible"
                  ></v-text-field
                ></v-responsive>
              </div>
              <div class="d-flex flex-column align-center justify-center">
                <grey-button
                  content="탈퇴하기"
                  class="logo-text center-button"
                  style="margin: 30px; padding: 25px"
                  @click="navigateToBankSelect"
                />
              </div>
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script setup>
import GreyButton from "@/components/button/GreyButton.vue";

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
