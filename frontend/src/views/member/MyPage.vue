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
            <v-sheet class="logo-text" style="padding: 40px" min-height="70vh" rounded="lg">
              <div>
                <v-form @submit.prevent="saveChanges">
                  <h4>이름</h4>
                  <v-text-field
                    disabled
                    :value="memberData.name"
                    variant="underlined"
                  ></v-text-field
                  ><br />
                  <h4>주민등록번호</h4>
                  <v-text-field
                    disabled
                    :value="memberData.registrationNumber"
                    variant="underlined"
                  ></v-text-field
                  ><br />

                  <h4>계좌번호</h4>
                  <v-text-field
                    disabled
                    :value="memberData.bankAccountNumber"
                    variant="underlined"
                  ></v-text-field
                  ><br />

                  <h4>아이디</h4>
                  <v-text-field
                    disabled
                    :value="memberData.loginId"
                    variant="underlined"
                  ></v-text-field
                  ><br />

                  <h4>비밀번호</h4>

                  <v-text-field
                    :disabled="!isEditMode"
                    v-model="memberData.password"
                    variant="underlined"
                  ></v-text-field
                  ><br />

                  <h4>이메일</h4>
                  <v-text-field
                    :disabled="!isEditMode"
                    v-model="memberData.email"
                    variant="underlined"
                  ></v-text-field
                  ><br />

                  <h4>전화번호</h4>
                  <v-text-field
                    :disabled="!isEditMode"
                    v-model="memberData.phoneNumber"
                    variant="underlined"
                  ></v-text-field
                  ><br />

                  <h4>주소</h4>

                  <v-text-field
                    :disabled="!isEditMode"
                    v-model="memberData.address"
                    variant="underlined"
                  ></v-text-field
                  ><br />
                  <div class="d-flex justify-center">
                    <v-btn text class="mx-2" @click="toggleEditMode">수정하기</v-btn>
                    <v-btn type="submit" text>저장하기</v-btn>
                  </div>
                </v-form>
              </div>
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script setup>
import { useRouter } from "vue-router";
import { ref, onBeforeMount } from "vue";
import { getApi } from "@/api/modules";
// import { patchApi } from "@/api/modules";

import axios from "axios";

//axios.defaults.withCredentials = true;

const isEditMode = ref(false);
const memberData = ref({
  name: "",
  registrationNumber: "",
  loginId: "",
  password: "",
  email: "",
  phoneNumber: "",
  bankAccountNumber: "",
  address: "",
});

const toggleEditMode = () => {
  isEditMode.value = !isEditMode.value;
};

const saveChanges = async () => {
  try {
    const updatedData = {
      name: memberData.value.name,
      registrationNumber: memberData.value.registrationNumber,
      loginId: memberData.value.loginId,
      password: memberData.value.password,
      email: memberData.value.email,
      phoneNumber: memberData.value.phoneNumber,
      bankAccountNumber: memberData.value.bankAccountNumber,
      address: memberData.value.address,
    };

    const response = await axios.patch("http://13.125.155.169:8080/member/detail", updatedData, {
      withCredentials: true,
    });

    console.log("데이터 업데이트 성공:", response);
  } catch (error) {
    console.error("데이터 업데이트 오류:", error);
  }
};

onBeforeMount(async () => {
  const data = await getApi({
    url: `/member/detail`,
  });
  memberData.value = data;
});

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
