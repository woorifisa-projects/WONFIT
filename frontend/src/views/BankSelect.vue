<template>
  <v-layout class="rounded rounded-md">
    <v-main class="d-flex flex-column align-center justify-center" style="margin-top:30px; min-height: 400px">
      <div class="d-flex flex-column align-center justify-center logo-text" style="font-size: 1.5em">
        어떤 은행사를 연결할까요?
        <div class="image-grid bank-name ">
          <div class="grid-row ">
            <div class="grid-item">
              <img src="@/assets/kookmin.png"  /> <p>국민은행</p>
            </div>
            <div class="grid-item">
              <img src="@/assets/woori.png" /> <p>우리은행</p>
            </div>
            <div class="grid-item">
              <img src="@/assets/shinhan.png" /> <p>신한은행</p>
            </div>
          </div>
          <div class="grid-row">
            <div class="grid-item">
              <img src="@/assets/kakao.png" /> <p>카카오뱅크</p>
            </div>
            <div class="grid-item">
              <img src="@/assets/toss.png" /> <p>토스뱅크</p>
            </div>
            <div class="grid-item">
              <img src="@/assets/kbank.png" /><p>케이뱅크</p>
            </div>
          </div>
          <div class="grid-row">
            <div class="grid-item">
              <img src="@/assets/nonghyup.png" /> <p>농협은행</p>
            </div>
            <div class="grid-item">
              <img src="@/assets/ibk.png" /> <p>IBK기업은행</p>
            </div>
            <div class="grid-item">
              <img src="@/assets/sc.png" /><p>SC제일은행</p>
            </div>
          </div>
        </div>
      </div>
      
      <div class="mb-5 logo-text" style="margin: 60px; font-size: 1.5em">
        당신의 연봉은 얼마인가요?
        <v-text-field :rules="rules" style="margin: 10px"  placeholder="연봉을 입력해주세요"></v-text-field>
      </div>

      <div class="mb-2 logo-text d-flex flex-column align-center justify-center" style="margin: 10px; font-size: 1.5em">
        연령대를 선택해주세요
        <v-radio-group inline style="margin:10px">
          <v-radio label="20대 이하" value="1"></v-radio>
  <v-radio label="30대" value="2"></v-radio>
  <v-radio label="40대" value="3"></v-radio>
  <v-radio label="50대" value="4"></v-radio>
  <v-radio label="60대 이상" value="5"></v-radio>
</v-radio-group>
      </div>
      
     
      <v-spacer></v-spacer>
      <div class="mb-15">
        <v-btn
          variant="tonal"
          class="d-flex justify-center align-center logo-text-button"
          style="padding: 30px; font-size: 1.1em; border-radius: 10px"
          @click="navigateToIncomeAnalysisPage"
        >
          결과보기
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

/* Add the following styles for the image grid */
.image-grid {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.grid-row {
  display: flex;
  justify-content: center;
  margin-top: 30px;
  margin-bottom: 10px;
}

.bank-name{
  font-size: 15px;
  text-align: center;
}
.grid-item {
  margin: 0 15px;
  
}

.grid-item img {
  width: 70px;
  height: auto;
  
}
</style>
