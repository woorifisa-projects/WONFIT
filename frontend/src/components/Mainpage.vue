<template>
  <v-layout class="rounded rounded-md">
    <v-main
      class="d-flex flex-column align-center justify-center"
      style="min-height: 400px"
    >
      <div class="mb-5 logo-text" style="margin: 40px; font-size: 1.5em">
        우리WONFIT에서 자신에게 딱 맞는 금융상품을 알아보세요!
      </div>
      <div class="mb-15">
        <v-btn
  variant="tonal"
  class="d-flex justify-center align-center logo-text-button"
  style="padding: 30px; font-size: 1.1em; border-radius: 10px"
  @click="navigateToIncomeAnalysisPage"
>
  소득정보 알아보기
</v-btn>

      </div>

      <div>
        <v-btn
          variant="tonal"
          class="mr-3 logo-text"
          style="padding: 90px 15px; background-color:rgb(59, 126, 227); color:white; font-weight: bold"
          @click="navigateToFundTestPage"
        >
          투자하고 싶어요
        </v-btn>

        <v-btn
          variant="tonal"
          class="mr-3 logo-text"
          style="padding: 90px 20px; background-color:rgb(59, 126, 227); color:white; font-weight: bold;"
          @click="navigateToLoanTestPage"
        >
          빌리고 싶어요
        </v-btn>

        <v-btn
          variant="tonal"
          class="mr-3 logo-text"
          style="padding: 90px 20px; background-color:rgb(59, 126, 227); color:white; font-weight: bold"
          @click="navigateToDepositTestPage"
        >
          모으고 싶어요
        </v-btn>

        <v-btn
          variant="tonal"
          class="mr-3 logo-text"
          style="padding: 90px 30px; background-color:rgb(59, 126, 227); color:white; font-weight: bold"
          @click="navigateToSavingsTestPage"
        >
          쌓고 싶어요
        </v-btn>
      </div>
    </v-main>
  </v-layout>
</template>

<script>
export default {
  methods: {
    navigateToIncomeAnalysisPage() {
      // IncomeAnalysis 페이지로 이동하는 코드 작성
      this.$router.push({ name: "Income" });
    },

    navigateToFundTestPage() {
      // FundTest 페이지로 이동하는 코드 작성
      this.$router.push({ name: "fundtest" });
    },

    navigateToLoanTestPage() {
      // LoanTest 페이지로 이동하는 코드 작성
      this.$router.push({ name: "loantest" });
    },

    navigateToDepositTestPage() {
      // DepositTest 페이지로 이동하는 코드 작성
      this.$router.push({ name: "deposittest" });
    },

    navigateToSavingsTestPage() {
      // SavingsTest 페이지로 이동하는 코드 작성
      this.$router.push({ name: "savingstest" });
    },
  },
};
</script>

<style scoped>
@font-face {
  font-family: "WooridaumB";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2205@1.0/WooridaumB.woff2")
    format("woff2");
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

</style>
