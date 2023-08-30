<template>
  <v-layout class="rounded rounded-md">
    <v-main class="d-flex flex-column align-center justify-center" style="min-height: 400px">
      <div class="mb-5 logo-text" style="margin: 40px; font-size: 1.5em">
        우리WONFIT에서 자신에게 딱 맞는 금융상품을 알아보세요!
      </div>
      <div class="mb-8">
        <grey-button content="소득정보 알아보기" @Click="navigateToIncomeAnalysisPage" />

      </div>

<<<<<<< Updated upstream
      <div>
        <custom-button content="투자하고 싶어요" />
        <custom-button content="빌리고 싶어요" />
        <custom-button content="모으고 싶어요" />
        <custom-button content="쌓고 싶어요" />
=======

      <div class = "button-container">
        <custom-button content="투자하고 싶어요" @Click="navigateToFundTestPage" />
        <custom-button content="빌리고 싶어요" width="165px"  @Click="navigateToLoanTestPage" />
        <custom-button content="모으고 싶어요" width="165px" @Click="navigateToDepositTestPage" />
        <custom-button content="쌓고 싶어요" width="170px" @Click="navigateToSavingsTestPage" />

>>>>>>> Stashed changes
      </div>
    </v-main>
  </v-layout>
</template>

<<<<<<< Updated upstream
<script>
import CustomButton from "@/components/button/CustomButton.vue";
=======
<script setup>

import CustomButton from '@/components/button/CustomButton.vue';
import GreyButton from '@/components/button/GreyButton.vue';

import { useRouter } from "vue-router";
const router = useRouter();
>>>>>>> Stashed changes

const navigateToIncomeAnalysisPage = () => {
  router.push({ name: "Income" });
};

const navigateToFundTestPage = () => {
  router.push({ name: "FundTest" });
};

const navigateToLoanTestPage = () => {
  router.push({ name: "LoanTest" });
};

const navigateToDepositTestPage = () => {
  router.push({ name: "DepositTest" });
};

<<<<<<< Updated upstream
    navigateToSavingsTestPage() {
      // SavingsTest 페이지로 이동하는 코드 작성
      this.$router.push({ name: "SavingsTest" });
    },
  },
  components: { CustomButton },
=======
const navigateToSavingsTestPage = () => {
  router.push({ name: "SavingsTest" });
};

const components = {
  CustomButton, GreyButton
>>>>>>> Stashed changes
};
</script>

<style scoped>
@font-face {
  font-family: "WooridaumB";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2205@1.0/WooridaumB.woff2") format("woff2");
  font-weight: 700;
  font-style: normal;
}

.logo-text {
  font-size: 18px;
  font-weight: bold;
  font-family: "WooridaumB", sans-serif;
}

.logo-text-button {
  font-size: 18px;
  font-weight: bold;
  font-family: "WooridaumB", sans-serif;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 30px;
  font-size: 1.1em;
  border-radius: 10px;
}

.button-container {
  display: flex;
  gap: 20px; /* 원하는 간격으로 조절하세요 */
  justify-content: center; /* 가운데 정렬 */
  
}
</style>
