<template>
  <v-card class="mx-auto" max-width="500" style="margin: 50px" title="Member Registration">
    <v-form>
      <v-container>
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
          hint="8자 이상 20자 이하, 문자/숫자/특수문자를 모두 포함해야 합니다."
          maxLength="20"
          variant="underlined"
          :rules="passwordRules"
        ></v-text-field>

        <v-text-field
          v-model="name"
          color="primary"
          label="이름"
          variant="underlined"
        ></v-text-field>

        <v-text-field
          v-model="registrationNumber"
          @input="onChangeRn"
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

        <v-form @submit.prevent>
          <v-text-field
            v-model="bankAccountPassword"
            color="primary"
            label="계좌 비밀번호"
            variant="underlined"
            readonly
            hint="비밀번호 4자리를 입력해 주세요."
            :append-inner-icon="visible ? 'mdi-eye-off' : 'mdi-eye'"
            :type="visible ? 'text' : 'password'"
            @click:append-inner="visible = !visible"
            @click.self.prevent.stop="keyboardVisible = true"
          ></v-text-field>

          <div v-if="keyboardVisible" ref="keyboardContainer">
            <VirtualKeyboard v-model="bankAccountPassword" @click.stop />
          </div>
        </v-form>

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
          label="[필수] 우리WONFIT 서비스 이용약관 동의"
        ></v-checkbox>
      </v-container>

      <v-divider></v-divider>

      <v-card-actions>
        <v-spacer></v-spacer>

        <WithdrawAlert
          @click="signup"
          btnName="Complete Registration"
          text="회원가입이 완료되었습니다."
          class="logo-text center-button"
          style="margin: 15px"
        />
        <v-icon icon="mdi-chevron-right"></v-icon>
      </v-card-actions>
    </v-form>
  </v-card>
</template>

<script setup>
import { ref, onMounted, onUnmounted } from "vue";
import { useRouter } from "vue-router";
import { postApi } from "@/api/modules";
import WithdrawAlert from "@/components/modal/WithdrawAlert.vue";
import VirtualKeyboard from "@/views/main/VirtualKeyboard.vue";

const router = useRouter();

const visible = ref(false);
const bankAccountPassword = ref("");
const name = ref();
const bankAccountNumber = ref();
const id = ref();
const password = ref();
const address = ref();
const email = ref();
const phoneNumber = ref();
const terms = ref(false); // 초기값으로 false를 설정합니다.

const passwordRules = [
  (v) => !!v || "비밀번호는 필수 입력 항목입니다.",
  (v) =>
    /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{8,20}$/.test(v) ||
    "비밀번호는 영어 대소문자, 숫자 및 특수 문자가 최소 하나 이상 포함된 8~20 자리여야 합니다.",
];

const registrationNumber = ref("");

const onChangeRn = () => {
  if (registrationNumber.value.length > 7) {
    // 주민등록번호 앞자리와 '-'(7자리) 이후부터 마스크 처리 시작
    const front = registrationNumber.value.slice(0, 7); // 앞부분 추출
    const back = "*".repeat(registrationNumber.value.length - 7); // 뒷부분은 '*'로 대체
    registrationNumber.value = front + back;
  }
};

// For Virtual Keyboard
const keyboardVisible = ref(false);
const keyboardContainer = ref(null);

onMounted(() => {
  document.addEventListener("click", handleClickOutside);
});

onUnmounted(() => {
  document.removeEventListener("click", handleClickOutside);
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
      marketingInfoAgree: terms.value,
    };

    const response = await postApi({
      url: `/wonfit/register`,
      data: requestBody,
    });

    if (response.status == 200) {
      router.push({ name: "MainPage" });
      console.log("데이터 업데이트 성공:", response);
    }
  } catch (error) {
    console.error("데이터 업데이트 오류:", error);
  }
}
</script>