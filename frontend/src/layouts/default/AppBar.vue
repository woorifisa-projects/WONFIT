<template>
  <v-app-bar flat>
    <v-app-bar-title class="d-flex align-left" style="margin-top:5px">
      <div class="logo" style="margin-left:100px" @click="navigateToMainPage">
        <div class="d-flex align-center">
          <img src="@/assets/wonfit.png" style="width:55px; margin-top: 8px" />
          <span class="logo-text" style="font-size: 23px">우리WONFIT</span>
          <div class="logo-text"  style="margin:30px" @click="navigateToProductSearchPage">상품 검색</div> 
          <div class="logo-text"  style="margin:10px" @click="navigateToRecommend">FIT 결과보기</div>
        </div>
      </div>
    </v-app-bar-title>  

          
          <div class="logo-text"  style="margin:40px" @click="navigateToLoginPage">로그인</div> <!--로그인하면 로그아웃으로 변경-->
          <div class="logo-text" style="margin-right:100px" @click="navigateToMyPage">마이페이지</div>


  </v-app-bar>
</template>

<script setup>
import { useRouter } from "vue-router";

const router = useRouter();

const navigateToMainPage = () => {
  router.push({ name: "MainPage" });
};

const navigateToRecommend = () => {
  router.push({ name: "Recommend" });
};

const navigateToProductSearchPage = () => {
  router.push({ name: "SearchDefault" });
};

const navigateToLoginPage = () => {
  router.push({ name: "LoginPage" });
};

const navigateToSignUpPage = () => {
  router.push({ name: "SignupPage" });
};

const navigateToMyPage = () => {
  router.push({ name: "MyPage" });
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

.logo {
  display: flex;
  align-items: center;
}

.logo-text {
  font-size: 16px;
  font-weight: bold;
  font-family: "WooridaumB", sans-serif; /* 적용한 폰트 스타일 사용 */
}

.logo-text:hover {
  text-shadow: 0px 1px 2px rgba(0, 0, 0, 0.2);
  cursor: pointer;
}

</style>
