import { defineStore } from "pinia";
import { ref } from "vue";

export const useAuthStore = defineStore("auth", () => {
  // 로그인 상태
  const isLogin = ref(false);
  const isAdmin = ref(false);

  const login = () => {
    isLogin.value = true;
    localStorage.setItem("isLogin", true);
  };

  const logout = () => {
    isLogin.value = false;
    localStorage.removeItem("isLogin");
  };

  const initializeAuth = () => {
    const storedIsLogin = localStorage.getItem("isLogin");
    if (storedIsLogin) {
      isLogin.value = true;
    } else {
      isLogin.value = false;
    }
  };

  // 로그인 상태를 변경하는 함수
  const setIsLogin = (value) => {
    isLogin.value = value;
  };

  const setIsAdmin = (value) => {
    isAdmin.value = value;
  };

  return { isLogin, isAdmin, setIsLogin, setIsAdmin, login, logout, initializeAuth };
});
