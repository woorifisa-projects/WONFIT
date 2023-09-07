import { defineStore } from "pinia";
import { computed, ref } from "vue";

export const useAuthStore = defineStore("auth", () => {
  // 로그인 상태
  const isLogin = ref(false);

  // 로그인 상태를 변경하는 함수
  const setIsLogin = (value) => {
    isLogin.value = value;
  };

  // 로그인 상태를 가져오는 함수
  const getIsLogin = computed(() => isLogin.value);

  // 로그인 상태를 초기화하는 함수
  const resetIsLogin = () => {
    isLogin.value = false;
  };

  return { isLogin, setIsLogin, getIsLogin, resetIsLogin };
});
