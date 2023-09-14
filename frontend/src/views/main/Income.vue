<template>
  <div class="d-flex align-center flex-column">
    <span class="logo" style="font-size: 30px; margin-top:30px; margin-bottom:5px" color="#3b7ee3">WONFIT에서 당신의 소득을 분석해
      보세요!</span>

    <img src="@/assets/wonfit.png" style="width: 200px; margin-right: 5px; margin-top:10px" />
    <span class="logo" style="font-size:25px; margin-top:5px; margin-bottom:30px" color="#3b7ee3">FIT YOUR ACCOUNT!</span>

    <label-component label="우리WONFIT 신용정보 제공 동의 (필수)" />
    <label-component label="우리WONFIT 개인정보 수집·이용 동의 (필수)" />
    <LabelComponent label="우리WONFIT 마케팅 수신 동의 (선택)" v-model:checked="marketingAgree" />

    <grey-button content="은행 선택하기" class="logo-text center-button" style="margin:30px; padding:25px"
      @click="navigateToBankSelect" />

  </div>
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import axios from "axios";


import LabelComponent from "@/views/main/LabelComponent.vue";
import GreyButton from "@/components/button/GreyButton.vue";

const router = useRouter();
const marketingAgree = ref(false); // 초기 값은 false


const navigateToBankSelect = async () => {
  console.log(marketingAgree.value)
  try {
    await axios.patch("http://localhost:8080/member/marketing", { marketingInfoAgree: marketingAgree.value });
    router.push({ name: "BankSelect" });
  } catch (error) {
    console.error(error);
  }
};

</script>

<style lang="scss" scoped>
.logo {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 8px;
}

.flex-column {
  flex-direction: column;
}

.checkbox {
  margin-top: 1px;

  /* Adjust the margin as needed */
}

@font-face {
  font-family: "WooridaumB";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2205@1.0/WooridaumB.woff2") format("woff2");
  font-weight: 700;
  font-style: normal;
}

.logo-text {
  font-size: 20px;
  font-weight: bold;

  font-family: "WooridaumB", sans-serif;
  /* 적용한 폰트 스타일 사용 */
}

.logo {
  font-size: 20px;
  font-weight: bold;
  color: #173966;
  font-family: "WooridaumB", sans-serif;
  /* 적용한 폰트 스타일 사용 */
}

.center-button {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 20px;
  /* 조정해보세요 */
}
</style>
