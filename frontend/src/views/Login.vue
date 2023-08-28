<template>
  <div style="margin-top: 50px">
    <v-card class="mx-auto pa-12 pb-8" elevation="8" max-width="448" rounded="lg">
      <div class="text-subtitle-1 text-medium-emphasis">ID</div>

      <v-text-field
        density="compact"
        placeholder="Enter your id"
        prepend-inner-icon="mdi-email-outline"
        variant="outlined"
        v-model="loginId"
      ></v-text-field>

      <div class="text-subtitle-1 text-medium-emphasis d-flex align-center justify-space-between">
        Password

        <a
          class="text-caption text-decoration-none text-blue"
          href="#"
          rel="noopener noreferrer"
          target="_blank"
        >
          Forgot login password?</a
        >
      </div>

      <v-text-field
        :append-inner-icon="visible ? 'mdi-eye-off' : 'mdi-eye'"
        :type="visible ? 'text' : 'password'"
        density="compact"
        placeholder="Enter your password"
        prepend-inner-icon="mdi-lock-outline"
        variant="outlined"
        v-model="password"
        @click:append-inner="visible = !visible"
      ></v-text-field>

        <v-btn block class="mb-8" color="blue" size="large" variant="tonal" @click="login"> Log In </v-btn>



      <v-card-text class="text-center">
        <a
          class="text-blue text-decoration-none"
          href="#"
          rel="noopener noreferrer"
          target="_blank"
        >
          Sign up now <v-icon icon="mdi-chevron-right"></v-icon>
        </a>
      </v-card-text>
    </v-card>
  </div>
</template>
<script>
import axios from 'axios';

export default {
  data: () => ({
    visible: false,
    loginId: '',     // 수정: memberid → loginId
    password: '',    // 수정: memberpw → password
  }),

  methods: {
    async login() {
      try {
        axios.defaults.withCredentials = true;

        const requestBody = {
          loginId: this.loginId,     // 수정: MemberId → loginId
          password: this.password,   // 수정: MemberPw → password
        };

        console.log(this.loginId);
        console.log(this.password);

        const response = await axios.post('http://localhost:8080/member/login', requestBody);
        console.log("로그인 성공~!~!");
        console.log(response.data); // 서버에서 전달된 데이터 출력

        // 로그인 성공 후 처리를 추가할 수 있습니다.
      } catch (error) {
        console.error('An error occurred:', error);
      }
    },
  },
};
</script>
