<template>
  <v-card class="mx-auto" max-width="500" style="margin: 50px" title="Member Registration">
    <v-form @submit.prevent="signup">
      <v-container>
        <v-text-field
          v-model="name"
          color="primary"
          label="이름"
          variant="underlined"
        ></v-text-field>
        <v-text-field
          v-model="registrationNumber"
          color="primary"
          label="주민등록번호"
          variant="underlined"
        ></v-text-field>

        <v-text-field
          v-model="bankAccountNumber"
          color="primary"
          label="계좌번호"
          variant="underlined"
        ></v-text-field>

        <v-text-field
          v-model="id"
          color="primary"
          label="아이디"
          hint="5자 이상 15자 이하로 입력해 주세요."
          maxLength="15"
          variant="underlined"
        ></v-text-field>

        <v-text-field
          v-model="password"
          color="primary"
          label="비밀번호"
          :append-inner-icon="visible ? 'mdi-eye-off' : 'mdi-eye'"
          :type="visible ? 'text' : 'password'"
          @click:append-inner="visible = !visible"
          hint="8자 이상 20자 이하로 입력해 주세요."
          maxLength="20"
          variant="underlined"
        ></v-text-field>

        <v-text-field
          v-model="email"
          color="primary"
          label="이메일"
          variant="underlined"
        ></v-text-field>

        <v-text-field
          v-model="phoneNumber"
          color="primary"
          label="전화번호"
          variant="underlined"
        ></v-text-field>

        <v-text-field
          v-model="address"
          color="primary"
          label="주소"
          variant="underlined"
        ></v-text-field>

        <v-checkbox
          v-model="terms"
          color="secondary"
          label="I agree to WooriWONFIT terms and conditions"
        ></v-checkbox>
      </v-container>

      <v-divider></v-divider>

      <v-card-actions>
        <v-spacer></v-spacer>

        <v-btn type="submit" color="blue">
          Complete Registration

          <v-icon icon="mdi-chevron-right" end></v-icon>
        </v-btn>
      </v-card-actions>
    </v-form>
  </v-card>
</template>

<script setup>
import { useRouter } from "vue-router";
const router = useRouter();

import { postApi } from "@/api/modules";
import { ref } from "vue";

const visible = ref(false);

const name = ref();
const registrationNumber = ref();
const bankAccountNumber = ref();
const id = ref();
const password = ref();
const address = ref();
const email = ref();
const phoneNumber = ref();
const terms = ref();

const signup = async () => {
  try {
    const requestBody = {
      name: name.value,
      registrationNumber: registrationNumber.value,
      bankAccountNumber: bankAccountNumber.value,
      loginId: id.value,
      password: password.value,
      status: true,
      address: address.value,
      email: email.value,
      phoneNumber: phoneNumber.value,
      terms: terms.value,
    };

    const response = await postApi({
      url: `/wonfit/register`,
      data: requestBody,
    });

    if (response.status == 200) {
      // 쿠키 저장 메소드
      router.push({ name: "MainPage" }); // 성공하면 메인페이지로 이동

      // 요청이 성공하면 적절한 처리를 수행합니다.
      console.log("데이터 업데이트 성공:", response);
    }
  } catch (error) {
    // 요청이 실패하면 오류 처리를 수행합니다.
    console.error("데이터 업데이트 오류:", error);
  }
};
</script>
