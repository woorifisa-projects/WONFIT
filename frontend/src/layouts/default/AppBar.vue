<template>
  <v-app-bar flat>
    <v-app-bar-title class="d-flex align-center" @click="navigateToMainPage">
      <div class="logo">
        <div class="d-flex align-center">
          <img
            src="@/assets/wonfit.png"
            style="width: 70px; margin-top: 8px; margin-right: 5px"
          />
          <span class="logo-text" style="font-size: 25px">우리WONFIT</span>
        </div>
      </div>
      <v-spacer></v-spacer>
    </v-app-bar-title>
    <v-chip-group class="right-aligned" style="margin-right: 10px">
        <v-chip class="logo-text" @click="navigateToLoginPage">로그인</v-chip>
        <v-chip class="logo-text" @click="navigateToSignUpPage">회원가입</v-chip>
        <v-chip class="logo-text" @click="navigateToMyPage">마이페이지</v-chip>
      </v-chip-group>
  </v-app-bar>
</template>


<script setup>
import { useRouter } from 'vue-router';

const router = useRouter();

const navigateToMainPage = () => {
  router.push({ name: 'MainPage' });
};

const navigateToLoginPage = () => {
  router.push({ name: 'LoginPage' });
};

const navigateToSignUpPage = () => {
  router.push({ name: 'SignupPage' });
};

const navigateToMyPage = () => {
  router.push({ name: 'MyPage' });
};

</script>

<style scoped>
@font-face {
  font-family: "WooridaumB";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2205@1.0/WooridaumB.woff2")
    format("woff2");
  font-weight: 700;
  font-style: normal;
}

.logo-text {
  font-size: 18px;
  font-weight: bold;
  font-family: "WooridaumB", sans-serif; /* 적용한 폰트 스타일 사용 */
}

.logo-text:hover {
  text-shadow: 0px 1px 2px rgba(0, 0, 0, 0.2);
  cursor: pointer;
}
</style>
