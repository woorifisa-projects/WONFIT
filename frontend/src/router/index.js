// Composables
import { createRouter, createWebHistory } from "vue-router";

const routes = [
  {
    path: "/",
    component: () => import("@/layouts/default/Default.vue"),
    children: [
      // views/main
      {
        path: "",
        name: "MainPage",
        component: () => import(/* webpackChunkName: "main" */ "@/views/main/Main.vue"),
      },

      {
        path: "bank-select",
        name: "BankSelect",
        component: () =>
          import(/* webpackChunkName: "bankselectpage" */ "@/views/main/BankSelect.vue"),
      },

      {
        path: "login",
        name: "LoginPage",
        component: () => import(/* webpackChunkName: "login" */ "@/views/main/Login.vue"),
      },

      {
        path: "signup",
        name: "Signup",
        component: () => import(/* webpackChunkName: "signup" */ "@/views/main/Signup.vue"),
      },

      {
        path: "recommend",
        name: "Recommend",
        component: () => import(/* webpackChunkName: "Recommend" */ "@/views/main/Recommend.vue"),
      },

      {
        path: "income",
        name: "Income",
        component: () => import(/* webpackChunkName: "managerpage" */ "@/views/main/Income.vue"),
      },

      // views/manager
      {
        path: "manager-page",
        name: "ManagerPage",
        component: () =>
          import(/* webpackChunkName: "managerpage" */ "@/views/manager/ManagerPage.vue"),
      },
      {
        path: "manager-page",
        name: "ManagerPage",
        component: () =>
          import(/* webpackChunkName: "managerpage" */ "@/views/manager/ManagerPage.vue"),
      },

      {
        path: "manage-product",
        name: "ManageProduct",
        component: () =>
          import(/* webpackChunkName: "ManageProduct" */ "@/views/manager/ManageProduct.vue"),
      },

      {
        path: "send-talk",
        name: "SendTalk",
        component: () => import(/* webpackChunkName: "SendTalk" */ "@/views/manager/SendTalk.vue"),
      },

      {
        path: "member-sign",
        name: "MemberSign",
        component: () =>
          import(/* webpackChunkName: "MemberSign" */ "@/views/manager/MemberSign.vue"),
      },

      // views/member
      {
        path: "mypage",
        name: "MyPage",
        component: () => import(/* webpackChunkName: "mypage" */ "@/views/member/MyPage.vue"),
      },

      {
        path: "my-liked-product",
        name: "MyLikedProduct",
        component: () =>
          import(/* webpackChunkName: "MyLikedProduct" */ "@/views/member/MyLikedProduct.vue"),
      },

      {
        path: "my-subscribe-product",
        name: "MySubscribeProduct",
        component: () =>
          import(
            /* webpackChunkName: "MySubscribeProduct" */ "@/views/member/MySubscribeProduct.vue"
          ),
      },

      {
        path: "withdraw",
        name: "Withdraw",
        component: () => import(/* webpackChunkName: "Withdraw" */ "@/views/member/Withdraw.vue"),
      },

      // views/product

      {
        path: "deposit-detail/:id",
        name: "DepositDetailId",
        component: () =>
          import(/* webpackChunkName: "DepositDetail" */ "@/views/product/detail/Deposit.vue"),
        props: true, // URL 파라미터를 컴포넌트 props로 전달함
      },

      {
        path: "savings-detail/:id",
        name: "SavingsDetailId",
        component: () =>
          import(/* webpackChunkName: "SavingsDetail" */ "@/views/product/detail/Savings.vue"),
        props: true, // URL 파라미터를 컴포넌트 props로 전달함
      },

      {
        path: "fund-detail/:id",
        name: "FundDetailId",
        component: () =>
          import(/* webpackChunkName: "FundDetail" */ "@/views/product/detail/Fund.vue"),
        props: true, // URL 파라미터를 컴포넌트 props로 전달함
      },

      {
        path: "loan-detail/:id",
        name: "LoanDetailId",
        component: () =>
          import(/* webpackChunkName: "LoanDetail" */ "@/views/product/detail/Loan.vue"),
        props: true, // URL 파라미터를 컴포넌트 props로 전달함
      },

      {
        path: "search-savings",
        name: "SearchSavings",
        component: () =>
          import(/* webpackChunkName: "searchsavings" */ "@/views/product/search/Savings.vue"),
      },

      {
        path: "search-default",
        name: "SearchDefault",
        component: () =>
          import(/* webpackChunkName: "searchdefault" */ "@/views/product/search/Default.vue"),
      },

      {
        path: "search-fund",
        name: "SearchFund",
        component: () =>
          import(/* webpackChunkName: "searchfund" */ "@/views/product/search/Fund.vue"),
      },

      {
        path: "search-loan",
        name: "SearchLoan",
        component: () =>
          import(/* webpackChunkName: "searchloan" */ "@/views/product/search/Loan.vue"),
      },

      {
        path: "subscribe/:productType/:id",
        name: "SubDeposit",
        component: () =>
          import(/* webpackChunkName: "subdeposit" */ "@/views/product/sub/SubDeposit.vue"),
        props: true,
      },

      {
        path: "fund-test",
        name: "FundTest",
        component: () =>
          import(/* webpackChunkName: "fundtest" */ "@/views/test/FundTest.vue"),
      },

      {
        path: "loan-test",
        name: "LoanTest",
        component: () =>
          import(/* webpackChunkName: "loantest" */ "@/views/test/LoanTest.vue"),
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
    ],
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
