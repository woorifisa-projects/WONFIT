// Composables
import { createRouter, createWebHistory } from "vue-router";

const routes = [
  {
    path: "/",
    component: () => import("@/layouts/default/Default.vue"),
    children: [
      {
        path: "",
        name: "Main",
        component: () =>
          import(/* webpackChunkName: "main" */ "@/views/Main.vue"),
      },

      {
        path: "login",
        name: "Login",
        component: () =>
          import(/* webpackChunkName: "login" */ "@/views/Login.vue"),
      },

      {
        path: "signup",
        name: "Signup",
        component: () =>
          import(/* webpackChunkName: "signup" */ "@/views/Signup.vue"),
      },

      {
        path: "recommend",
        name: "Recommend",
        component: () =>
          import(/* webpackChunkName: "recommend" */ "@/views/Recommend.vue"),
      },

      {
        path: "ivtest",
        name: "Ivtest",
        component: () =>
          import(/* webpackChunkName: "ivtest" */ "@/views/Ivtest.vue"),
      },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
