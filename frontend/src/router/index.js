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
        component: () => import(/* webpackChunkName: "Recommend" */ "@/views/Recommend.vue"),
      },

      {
        path: "fund-test",
        name: "FundTest",
        component: () => import(/* webpackChunkName: "fundtest" */ "@/views/test/FundTest.vue"),
      },

      {
        path: "loan-test",
        name: "LoanTest",
        component: () => import(/* webpackChunkName: "loantest" */ "@/views/test/LoanTest.vue"),
      },

      {
        path: "deposit-test",
        name: "DepositTest",
        component: () =>
          import(/* webpackChunkName: "deposittest" */ "@/views/test/DepositTest.vue"),
      },

      {
        path: "savings-test",
        name: "SavingsTest",
        component: () =>
          import(/* webpackChunkName: "savingstest" */ "@/views/test/SavingsTest.vue"),
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
        path: "bank-select",
        name: "BankSelect",
        component: () => import(/* webpackChunkName: "bankselectpage" */ "@/views/BankSelect.vue"),
      },

      {
        path: "my-liked-product",
        name: "MyLikedProduct",
        component: () =>
          import(/* webpackChunkName: "MyLikedProduct" */ "@/views/MyLikedProduct.vue"),
      },

      {
        path: "my-subscribe-product",
        name: "MySubscribeProduct",
        component: () =>
          import(/* webpackChunkName: "MySubscribeProduct" */ "@/views/MySubscribeProduct.vue"),
      },

      {
        path: "withdraw",
        name: "Withdraw",
        component: () => import(/* webpackChunkName: "Withdraw" */ "@/views/Withdraw.vue"),
      },

      {
        path: "search-savings",
        name: "SearchSavings",
        component: () =>
          import(/* webpackChunkName: "searchsavings" */ "@/views/search/Savings.vue"),
      },

      {
        path: "search-default",
        name: "SearchDefault",
        component: () =>
          import(/* webpackChunkName: "searchdefault" */ "@/views/search/Default.vue"),
      },

      {
        path: "search-fund",
        name: "SearchFund",
        component: () => import(/* webpackChunkName: "searchfund" */ "@/views/search/Fund.vue"),
      },

      {
        path: "search-loan",
        name: "SearchLoan",
        component: () => import(/* webpackChunkName: "searchloan" */ "@/views/search/Loan.vue"),
      },

      {
        path: "deposit-detail",
        name: "DepositDetail",
        component: () =>
          import(/* webpackChunkName: "depositdetail" */ "@/views/detail/Deposit.vue"),
      },

      {
        path: "savings-detail",
        name: "SavingsDetail",
        component: () =>
          import(/* webpackChunkName: "savingsdetail" */ "@/views/detail/Savings.vue"),
      },

      {
        path: "fund-detail",
        name: "FundDetail",
        component: () => import(/* webpackChunkName: "funddetail" */ "@/views/detail/Fund.vue"),
      },

      {
        path: "loan-detail",
        name: "LoanDetailPage",
        component: () => import(/* webpackChunkName: "loandetail" */ "@/views/detail/Loan.vue"),
      },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
