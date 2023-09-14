<template>
  <div>
    <!-- 배너 영역 -->
    <div class="banner-container d-flex justify-center">
      <!-- 배너 이미지 추가 -->
      <p class="mainFontSize" style="margin: 120px 210px">
        우리WONFIT에서<br />
        나에게 딱 맞게
      </p>
      <img
        src="@/assets/puzzler.png"
        class="banner-image"
        style="width: 320px; transform: rotate(7deg)"
      />
    </div>
    <v-container style="position: relative">
      <div class="banner-content" style="font-size: 30px">
        <!-- <p>목적에 맞는 금융상품을</p>
        <p>성향분석 검사를 통해 편리하게 추천 받으세요</p> -->
        <P>내게 맞는 금융상품 찾기 힘드시죠?</P>
        <p style="margin-top: 5px">
          나만의 <span style="color: #2965ed">FIT 퍼즐</span>을 찾아 보세요!
        </p>
        <p style="margin-top: 35px; font-size: 20px">성향분석 검사하기</p>
      </div>
      <div>
        <div class="scrolldown">
          <span></span>
          <span></span>
        </div>
      </div>
      <v-item-group>
        <div class="container">
          <div class="puzzle-wrap">
            <div class="button" style="--r: -15" @click="navigateToDepositTestPage">
              <span></span>
              <span></span>
              <span></span>
              <span></span>
              <p>예금 퍼즐</p>
            </div>
          </div>

          <div class="puzzle-wrap">
            <div class="button" style="--r: 5" @click="navigateToSavingsTestPage">
              <span></span>
              <span></span>
              <span></span>
              <span></span>
              <p>적금 퍼즐</p>
            </div>
          </div>

          <div class="puzzle-wrap">
            <div class="button" style="--r: 25" @click="navigateToFundTestPage">
              <span></span>
              <span></span>
              <span></span>
              <span></span>
              <p>펀드 퍼즐</p>
            </div>
          </div>

          <div class="puzzle-wrap">
            <div class="button" style="--r: 15" @click="navigateToLoanTestPage">
              <span></span>
              <span></span>
              <span></span>
              <span></span>
              <p>대출 퍼즐</p>
            </div>
          </div>
        </div>
      </v-item-group>
    </v-container>

    <!-- 배너 영역 -->
    <div class="banner-container2 d-flex justify-center">
      <!-- 배너 이미지 추가 -->
      <p class="mainFontSize" style="margin: 100px 200px">
        모든 금융내역을<br />
        한 곳에서 관리하세요 <br />
        <v-btn
          color="#2965ED"
          height="50px"
          width="200px"
          style="margin-top: 30px; font-size: 16px; color: white"
          @click="navigateToIncomeAnalysisPage"
          >마이데이터 보러가기</v-btn
        >
      </p>
      <img src="@/assets/receipt.png" class="banner-image" style="250px" />
    </div>
  </div>
</template>

<script setup>
import { useRouter } from "vue-router";
const router = useRouter();

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

const navigateToSavingsTestPage = () => {
  router.push({ name: "SavingsTest" });
};
</script>

<style lang="scss" scoped>
.banner-container {
  height: 600px;
  background-color: #d1e4ffd3;
  padding: 20px; /* 내부 여백 추가 */
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-top: 10px;
}

.banner-container2 {
  height: 600px;
  background-color: #d1e4ffd3;
  padding: 20px; /* 내부 여백 추가 */
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-bottom: 50px;
}

/* 배너 이미지 스타일 */
.banner-image {
  max-height: 300px; /* 이미지의 최대 높이 설정 */
  margin-right: 250px;
  object-fit: cover; /* 이미지를 부모 요소에 맞추고 가로/세로 비율 유지 */
  margin-right: 140px;
}

/* 배너 내용 스타일 */
.banner-content {
  margin-top: 100px;
  margin-bottom: 200px;
  text-align: center;
}

.mainFontSize {
  font-size: 40px;
  color: #333; /* 텍스트 색상 설정 */
}

* {
  padding: 0;
  margin: 0;
}

.container {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 130px;
  margin-left: 70px;
}

.puzzle-wrap {
  margin-right: 60px;
}
.button {
  box-shadow: inset -9px 7px 2px #02122555;
  border: 1px solid;
}

.button::after {
  content: "";
  box-shadow: inset 6px -5px 7px rgba(208, 222, 255, 0.4784313725);
  z-index: -1;
  border-radius: 1rem;
  width: 100px;
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}

.container .button {
  position: relative;
  width: 11rem;
  height: 11rem;
  font-size: 23px;
  background-color: #2965ed;
  border: 1px solid rgba(255, 255, 255, 0.1);
  color: #f6f7ff;

  display: flex;
  justify-content: center;
  align-items: center;
  transition: 0.5s;
  border-radius: 1rem;
  margin: 0 -45px;
  transform: rotate(calc(var(--r) * 1deg));
}

.container:hover .button {
  transform: rotate(0deg);
  margin: 0 20px;
  cursor: pointer;
}

.button p {
  margin-top: -13px;
  margin-left: 3px;
}

.button > span:nth-child(n) {
  position: absolute;
  width: 4rem;
  height: 4rem;
  border-radius: 100%;
}
.button > span:nth-child(1) {
  background-color: #2965ed;
  box-shadow: inset -4px 8px 2px #02122555;
  top: -2rem;
  left: 3.5rem;
}
.button > span:nth-child(2) {
  background-color: #2965ed;
  box-shadow: inset -10px 1px 2px #02122555;
  right: -2rem;
  top: 3rem;
}
.button > span:nth-child(3) {
  background-color: #2965ed;
  box-shadow: inset 7px -2px 4px rgba(208, 222, 255, 0.397);
  left: -2rem;
  top: 3rem;
}
.button > span:nth-child(4) {
  background-color: white;
  bottom: -2rem;
  left: 3.5rem;
}

.scrolldown {
  position: absolute;
  top: 49%;
  bottom: 30px;
  left: 52%;
  width: 40px;
  height: 40px;
  transform: translateY(-80px) translateX(-50px) rotate(45deg);
}

.scrolldown span {
  position: absolute;
  top: 0;
  left: 0;
  display: block;
  width: 100%;
  height: 100%;
  border-bottom: 2px solid #9e9e9e;
  border-right: 2px solid #9e9e9e;
  animation: animate 1.5s linear infinite;
  opacity: 0;
}

.scrolldown span:nth-child(1) {
  transform: translate(-15px, -15px);
  animation-delay: -0.4s;
}
.scrolldown span:nth-child(2) {
  transform: translate(0, 0);
  animation-delay: -0.2s;
}

@keyframes animate {
  0% {
    top: -5px;
    left: -5px;
    opacity: 0;
  }
  25% {
    top: 0px;
    left: 0px;
    opacity: 1;
  }
  50% {
    top: 5px;
    left: 5px;
    opacity: 0;
  }
}
</style>
