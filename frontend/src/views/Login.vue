<template>
  <div style="margin-top: 50px">
    <v-card class="mx-auto pa-12 pb-8" elevation="8" max-width="448" rounded="lg">
      <div class="text-subtitle-1 text-medium-emphasis">ID</div>

      <v-text-field density="compact" placeholder="Enter your id" prepend-inner-icon="mdi-email-outline"
                    variant="outlined" v-model="loginId"></v-text-field>

      <div class="text-subtitle-1 text-medium-emphasis d-flex align-center justify-space-between">
        Password

        <a class="text-caption text-decoration-none text-blue" href="#" rel="noopener noreferrer" target="_blank">
          Forgot login password?
        </a>
      </div>

      <v-text-field :append-inner-icon="visible ? 'mdi-eye-off' : 'mdi-eye'" :type="visible ? 'text' : 'password'"
                    density="compact" placeholder="Enter your password" prepend-inner-icon="mdi-lock-outline" v-model="password"
                    variant="outlined" @click:append-inner="visible = !visible"></v-text-field>

      <v-btn block class="mb-8" color="blue" size="large" variant="tonal" @click="login">
        Log In
      </v-btn>

      <v-card-text class="text-center">
        <a class="text-blue text-decoration-none" href="#" rel="noopener noreferrer" target="_blank">
          Sign up now <v-icon icon="mdi-chevron-right"></v-icon>
        </a>
      </v-card-text>
    </v-card>
  </div>
</template>

<script setup>
import axios from "axios";
import { ref } from "vue";
import { useRouter } from "vue-router";
const router = useRouter();

const setCookie = function (key, value, exp) {
  const date = new Date();
  //console.log("현재 시간 : " + date);
  date.setTime(date.getTime() + exp * 1000);// UTC 타임스탬프를 밀리초로 변환하여 현재 시간에 더해주기

  document.cookie = key + '=' + value + ';expires=' + date.toUTCString() + ';path=/';
}

const parseJwt = (token) => {
  const base64Url = token.split('.')[1];
  const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
  const jsonPayload = decodeURIComponent(atob(base64).split('').map(function (c) {
    return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
  }).join(''));
  return JSON.parse(jsonPayload);
};

const visible = ref(false);
const loginId = ref("");
const password = ref("");

const login = async () => {
  try {
    axios.defaults.withCredentials = true;

    const requestBody = {
      loginId: loginId.value,
      password: password.value,
    };

    const response = await axios.post("http://localhost:8080/member/login", requestBody);
    if (response.status == 200) { // 쿠키 저장 메소드
      const value = response.data.result;
      const jwt = parseJwt(response.data.result);
      const key = "key";

      setCookie(key, value, jwt.exp);
      router.push({ name: "MainPage" });;
    }
  } catch (error) {
    console.error("An error occurred:", error);
  }
};
</script>
