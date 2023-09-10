import { defineStore } from "pinia";
import { ref } from "vue";

export const useAuthStore = defineStore("auth", () => {
  // 로그인 상태
  const isLogin = ref(false);

  // 로그인 상태를 변경하는 함수
  const setIsLogin = (value) => {
    isLogin.value = value;
  };

  return { isLogin, setIsLogin };
});
