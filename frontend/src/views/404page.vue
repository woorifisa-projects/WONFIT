<template>
  <div class="d-flex justify-center">
    <img
      src="@/assets/404.png"
      @click="navigateToMainPage"
      style="width: 320px; margin-top: 50px"
    />
  </div>
  <div class="d-flex justify-center logo-text" style="font-size: 50px">404 ERROR</div>
  <div class="d-flex justify-center logo-text" style="font-size: 30px; color: #3b7ee3">
    PAGE NOT FOUND
  </div>
</template>

<script setup></script>

<style>
@font-face {
  font-family: "WooridaumB";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2205@1.0/WooridaumB.woff2")
    format("woff2");
  font-weight: 300;
  font-style: normal;
}

.logo-text {
  font-size: 15px;
  font-family: "WooridaumB", sans-serif;
}
</style>
