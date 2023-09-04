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
        path: "search-default",
        name: "SearchDefault",
        component: () =>
          import(/* webpackChunkName: "searchdefault" */ "@/views/search/Default.vue"),
      },

      {
        path: "search-savings",
        name: "SearchSavings",
        component: () =>
          import(/* webpackChunkName: "searchsavings" */ "@/views/search/Savings.vue"),
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

      // {
      //   path: "talk",
      //   name: "SendTalkPage",
      //   component: () => import(/* webpackChunkName: "SendTalkPage" */ "@/views/talk.vue"),
      // },

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

      {
        path: "deposit-detail/:id",
        name: "DepositDetailId",
        component: () =>
          import(/* webpackChunkName: "DepositDetail" */ "@/views/detail/Deposit.vue"),
        props: true, // URL 파라미터를 컴포넌트 props로 전달함
      },

      {
        path: "savings-detail/:id",
        name: "SavingsDetailId",
        component: () =>
          import(/* webpackChunkName: "SavingsDetail" */ "@/views/detail/Savings.vue"),
        props: true, // URL 파라미터를 컴포넌트 props로 전달함
      },

      {
        path: "fund-detail/:id",
        name: "FundDetailId",
        component: () => import(/* webpackChunkName: "FundDetail" */ "@/views/detail/Fund.vue"),
        props: true, // URL 파라미터를 컴포넌트 props로 전달함
      },

      {
        path: "loan-detail/:id",
        name: "LoanDetailId",
        component: () => import(/* webpackChunkName: "LoanDetail" */ "@/views/detail/Loan.vue"),
        props: true, // URL 파라미터를 컴포넌트 props로 전달함
      },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
