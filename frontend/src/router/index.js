// Composables
import { createRouter, createWebHistory } from "vue-router";

const routes = [
  {
    path: "/",
    component: () => import("@/layouts/default/Default.vue"),
    children: [
      {
        path: "",
        name: "MainPage",
        component: () => import(/* webpackChunkName: "main" */ "@/views/Main.vue"),
      },

      {
        path: "login",
        name: "LoginPage",
        component: () => import(/* webpackChunkName: "login" */ "@/views/Login.vue"),
      },

      {
        path: "signup",
        name: "SignupPage",
        component: () => import(/* webpackChunkName: "signup" */ "@/views/Signup.vue"),
      },

      {
        path: "recommend",
        name: "Recommend",
        component: () => import(/* webpackChunkName: "recommend" */ "@/views/Recommend.vue"),
      },

      {
        path: "fundtest",
        name: "fundtest",
        component: () => import(/* webpackChunkName: "fundtest" */ "@/views/FundTest.vue"),
      },

      {
        path: "loantest",
        name: "loantest",
        component: () => import(/* webpackChunkName: "loantest" */ "@/views/LoanTest.vue"),
      },

      {
        path: "deposittest",
        name: "deposittest",
        component: () => import(/* webpackChunkName: "deposittest" */ "@/views/DepositTest.vue"),
      },

      {
        path: "savingstest",
        name: "savingstest",
        component: () => import(/* webpackChunkName: "savingstest" */ "@/views/SavingsTest.vue"),
      },

      {
        path: "managerpage",
        name: "Managerpage",
        component: () => import(/* webpackChunkName: "managerpage" */ "@/views/ManagerPage.vue"),
      },

      {
        path: "Income",
        name: "Income",
        component: () => import(/* webpackChunkName: "managerpage" */ "@/views/Income.vue"),
      },
      {
        path: "mypage",
        name: "MyPage",
        component: () => import(/* webpackChunkName: "mypage" */ "@/views/MyPage.vue"),
      },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
