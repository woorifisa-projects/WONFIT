<template>
  <v-app id="inspire" style="margin-top: 20px">
    <v-main class="bg-grey-lighten-3">
      <v-container>
        <v-row>
          <v-col cols="3">
            <v-sheet rounded="lg">
              <v-list rounded="lg">
                <v-list-item class="logo-text" @click="navigateToMyPage">내 정보 보기</v-list-item>
                <v-list-item class="logo-text" @click="navigateToMySubscribeProduct">내 가입상품 확인하기</v-list-item>
                <v-list-item class="logo-text" @click="navigateToMyLikedProduct">내 관심상품 확인하기</v-list-item>
                <v-list-item class="logo-text" @click="navigateToRecommend">나의 투자성향 보기</v-list-item>

                <v-divider class="my-2"></v-divider>

                <v-list-item class="logo-text" @click="navigateToWithdraw">회원 탈퇴</v-list-item>
              </v-list>
            </v-sheet>
          </v-col>

          <v-col>
            <v-sheet min-height="50vh" rounded="lg">
              <v-form @submit.prevent="withdraw">
                <v-responsive>
                  <v-text-field v-model="id" color="primary" placeholder="Enter your id" maxLength="15" variant="outlined"
                    :style="{ width: '300px', margin: '30px auto' }"></v-text-field>

                  <v-text-field :append-inner-icon="visible ? 'mdi-eye-off' : 'mdi-eye'"
                    :type="visible ? 'text' : 'password'" placeholder="Enter your password" v-model="password"
                    variant="outlined" @click:append-inner="visible = !visible"
                    :style="{ width: '300px', margin: '10px auto' }"></v-text-field></v-responsive>

                <div class="d-flex flex-column align-center justify-center">
                  <WithdrawAlert type="submit" btnName="탈퇴하기" text="회원탈퇴가 완료되었습니다." class="logo-text center-button"
                    style="margin: 30px; padding: 25px" @click="withdraw" />
                </div>
              </v-form>
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script setup>
// import GreyButton from "@/components/button/GreyButton.vue";
import WithdrawAlert from "@/components/modal/WithdrawAlert.vue";

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

import { postApi } from "@/api/modules";
import { ref } from "vue";

const visible = ref(false);
const id = ref();
const password = ref();

const withdraw = async () => {
  try {
    const requestBody = {
      loginId: id.value,
      password: password.value,
    };

    const response = await postApi({
      url: `/member/leave`,
      data: requestBody,
    });

    if (response.status == 200) {
      // 쿠키 저장 메소드
      router.push({ name: "MainPage" });

      // 요청이 성공하면 적절한 처리를 수행합니다.
      console.log("데이터 업데이트 성공:", response);
    }
  } catch (error) {
    // 요청이 실패하면 오류 처리를 수행합니다.
    console.error("데이터 업데이트 오류:", error);
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
