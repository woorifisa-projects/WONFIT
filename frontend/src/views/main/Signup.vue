<template>
  <v-card class="mx-auto" max-width="500" style="margin: 50px" title="Member Registration">
    <v-form>
      <v-container>
        <v-text-field v-model="id" color="primary" label="아이디" hint="5자 이상 15자 이하로 입력해 주세요." maxLength="15"
          variant="underlined"></v-text-field>

        <v-text-field v-model="password" color="primary" label="비밀번호"
          :append-inner-icon="visible ? 'mdi-eye-off' : 'mdi-eye'" :type="visible ? 'text' : 'password'"
          @click:append-inner="visible = !visible" hint="8자 이상 20자 이하로 입력해 주세요." maxLength="20"
          variant="underlined"></v-text-field>
        <v-text-field v-model="name" color="primary" label="이름" variant="underlined"></v-text-field>
        <v-text-field v-model="registrationNumber" color="primary" label="주민등록번호" variant="underlined"></v-text-field>

        <v-text-field v-model="bankAccountNumber" color="primary" label="계좌번호" variant="underlined"></v-text-field>

        <v-form @submit.prevent>
          <v-text-field v-model="bankAccountPassword" color="primary" label="계좌 비밀번호" variant="underlined" readonly
            hint="비밀번호 4자리를 입력해 주세요." :append-inner-icon="visible ? 'mdi-eye-off' : 'mdi-eye'"
            :type="visible ? 'text' : 'password'" @click:append-inner="visible = !visible"
            @click.self.prevent.stop="keyboardVisible = true"></v-text-field>

          <div v-if="keyboardVisible" ref="keyboardContainer">
            <VirtualKeyboard v-model="bankAccountPassword" @click.stop />
          </div>
        </v-form>


        <v-text-field v-model="email" color="primary" label="이메일" variant="underlined"></v-text-field>

        <v-text-field v-model="phoneNumber" color="primary" label="전화번호" variant="underlined"></v-text-field>

        <v-text-field v-model="address" color="primary" label="주소" variant="underlined"></v-text-field>

        <v-checkbox v-model="terms" color="secondary" label="[필수] 우리WONFIT 서비스 이용약관 동의"></v-checkbox>
      </v-container>

      <v-divider></v-divider>

      <v-card-actions>
        <v-spacer></v-spacer>

        <!-- <v-btn type="submit" @click="navigateToMainPage" color="blue">
          Complete Registration

          <v-icon icon="mdi-chevron-right" end></v-icon>
        </v-btn> -->

        <WithdrawAlert @click="signup" btnName="Complete Registration" text="회원가입이 완료되었습니다."
          class="logo-text center-button" style="margin: 15px" />
        <v-icon icon="mdi-chevron-right"></v-icon>
      </v-card-actions>
    </v-form>
  </v-card>
</template>

<script setup>
import { ref, onMounted, onUnmounted } from 'vue';
import { useRouter } from "vue-router";
import { postApi } from "@/api/modules";
import WithdrawAlert from "@/components/modal/WithdrawAlert.vue";
import VirtualKeyboard from '@/views/main/VirtualKeyboard.vue';

const router = useRouter();

const visible = ref(false);
const bankAccountPassword = ref('');
const name = ref();
const registrationNumber = ref();
const bankAccountNumber = ref();
const id = ref();
const password = ref();
const address = ref();
const email = ref();
const phoneNumber = ref();
const terms = ref(false); // 초기값으로 false를 설정합니다.

// For Virtual Keyboard
const keyboardVisible = ref(false);
const keyboardContainer = ref(null);

onMounted(() => {
  document.addEventListener('click', handleClickOutside);
});

onUnmounted(() => {
  document.removeEventListener('click', handleClickOutside);
});

function handleClickOutside(e) {
  if (keyboardContainer.value && !keyboardContainer.value.contains(e.target)) {
    keyboardVisible.value = false;
  }
}

// Signup function
async function signup() {
  try {
    const requestBody = {
      name: name.value,
      registrationNumber: registrationNumber.value,
      bankAccountNumber: bankAccountNumber.value,
      bankAccountPassword: bankAccountPassword.value,
      loginId: id.value,
      password: password.value,
      status: true,
      address: address.value,
      email: email.value,
      phoneNumber: phoneNumber.value,
      marketingInfoAgree: terms.value
    };

    const response = await postApi({
      url: `/wonfit/register`,
      data: requestBody
    });

    if (response.status == 200) {
      router.push({ name: "MainPage" });
      console.log("데이터 업데이트 성공:", response);
    }
  } catch (error) {
    console.error("데이터 업데이트 오류:", error)
  }
}
</script>

