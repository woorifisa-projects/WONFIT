<template>
  <v-app-bar flat max-height="70px">
    <v-app-bar-title class="d-flex align-left" style="margin-top: 5px">
      <div class="logo" style="margin-left: 150px">
        <div class="d-flex align-center">
          <img
            class="clickable-title"
            src="@/assets/wonfit.png"
            @click="navigateToMainPage"
            style="width: 55px; margin-top: 6px"
          />
          <span
            class="logo-text clickable-title"
            style="font-size: 23px"
            @click="navigateToMainPage"
            >우리WONFIT</span
          >

          <div
            class="logo-text clickable-title"
            style="margin: 23px"
            @click="navigateToProductSearchPage"
          >
            상품 검색
          </div>
          <div class="logo-text clickable-title" @click="navigateToRecommend">FIT 결과보기</div>
        </div>
      </div>
    </v-app-bar-title>

    <!--로그인하면 로그아웃으로 변경-->
    <template v-if="auth.isLogin">
      <div class="logo-text mt-2" style="margin-right: 23px" @click="navigateToMyPage">
        마이페이지
      </div>
      <div>
        <div class="logout-btn mt-2" style="margin-right: 200px" @click="logout">로그아웃</div>
      </div>
    </template>

    <template v-else-if="auth.isAdmin">
      <div class="logo-text mt-2" style="margin-right: 23px" @click="navigateToManagerPage">
        관리자
      </div>
      <div>
        <div class="logout-btn mt-2" style="margin-right: 200px" @click="managerLogout">
          로그아웃
        </div>
      </div>
    </template>

    <template v-else>
      <div class="logo-text mt-2" style="margin-right: 23px" @click="navigateToSignup">
        회원가입
      </div>
      <div class="logo-text mt-2" style="margin-right: 200px" @click="navigateToLoginPage">
        로그인
      </div>
    </template>
  </v-app-bar>
</template>

<script setup>
import { useRouter } from "vue-router";
import { postApi } from "@/api/modules";
import { useAuthStore } from "@/store/modules/useAuthStore";

const router = useRouter();

const auth = useAuthStore();

const logout = async () => {
  try {
    await postApi({
      url: "/member/logout",
    });
    auth.setIsLogin(false);
    router.push({ name: "MainPage" });
  } catch (error) {
    console.error(error);
  }
};

const managerLogout = async () => {
  try {
    await postApi({
      url: "/manager/logout",
    });
    auth.setIsAdmin(false);
    router.push({ name: "MainPage" });
  } catch (error) {
    console.error(error);
  }
};

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

const navigateToMyPage = () => {
  router.push({ name: "MyPage" });
};

const navigateToManagerPage = () => {
  router.push({ name: "ManagerPage" });
};

const navigateToSignup = () => {
  router.push({ name: "Signup" });
};
</script>

<style scoped>
@font-face {
  font-family: "WooridaumB";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2205@1.0/WooridaumB.woff2")
    format("woff2");
  font-style: normal;
}

.logo {
  display: flex;
  align-items: center;
}
.v-app-bar {
  background-color: #fff;
  box-shadow: 0px 1px 20px rgba(0, 0, 0, 0.151);
  height: 70px;
}
.logo-text {
  font-size: 16px;
  color: rgb(49, 49, 49);
}

.logo-text:hover {
  text-shadow: 0px 1px 2px rgba(0, 0, 0, 0.2);
  cursor: pointer;
}

.clickable-title:hover {
  text-shadow: 0px 1px 2px rgba(0, 0, 0, 0.2);
  cursor: pointer;
}

.logout-btn:hover {
  margin-right: 15px;
  text-shadow: 0px 1px 2px rgba(0, 0, 0, 0.2);
  cursor: pointer;
}
</style>
