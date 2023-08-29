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
        path: "fund-test",
        name: "FundTest",
        component: () => import(/* webpackChunkName: "fundtest" */ "@/views/FundTest.vue"),
      },

      {
        path: "loan-test",
        name: "LoanTest",
        component: () => import(/* webpackChunkName: "loantest" */ "@/views/LoanTest.vue"),
      },

      {
        path: "deposit-test",
        name: "DepositTest",
        component: () => import(/* webpackChunkName: "deposittest" */ "@/views/DepositTest.vue"),
      },

      {
        path: "savings-test",
        name: "SavingsTest",
        component: () => import(/* webpackChunkName: "savingstest" */ "@/views/SavingsTest.vue"),
      },

      {
        path: "manager-page",
        name: "ManagerPage",
        component: () => import(/* webpackChunkName: "managerpage" */ "@/views/ManagerPage.vue"),
      },

      {
        path: "income",
        name: "Income",
        component: () => import(/* webpackChunkName: "managerpage" */ "@/views/Income.vue"),
      },
      {
        path: "mypage",
        name: "MyPage",
        component: () => import(/* webpackChunkName: "mypage" */ "@/views/MyPage.vue"),
      },
      {
        path: "search-default",
        name: "SearchDefault",
        component: () =>
          import(/* webpackChunkName: "searchdefault" */ "@/views/SearchDefault.vue"),
      },
      {
        path: "search-savings",
        name: "SearchSavings",
        component: () =>
          import(/* webpackChunkName: "searchsavings" */ "@/views/SearchSavings.vue"),
      },
      {
        path: "search-fund",
        name: "SearchFund",
        component: () => import(/* webpackChunkName: "searchfund" */ "@/views/SearchFund.vue"),
      },
      {
        path: "search-loan",
        name: "SearchLoan",
        component: () => import(/* webpackChunkName: "searchloan" */ "@/views/SearchLoan.vue"),
      },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
