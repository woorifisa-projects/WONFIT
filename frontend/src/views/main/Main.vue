<template>
  <div >
   
    <!-- 배너 영역 -->
    <div class="banner-container logo-text d-flex justify-center">
      <!-- 배너 이미지 추가 -->
      <h1 style="margin:120px 210px">우리WONFIT에서<br>
    나에게 딱 맞게</h1>
      <img src="@/assets/puzzler.png" class="banner-image"/>
    
      </div>


     
      <div class="banner-content logo-text">
        <h2>목적에 맞는 금융상품을</h2>
        <p>성향분석 검사를 통해 편리하게 추천 받으세요</p>
      </div>

      <v-row class="d-flex justify-center">

        <div class="image-with-text-container clickable-title" @click="navigateToDepositTestPage">
      <img src="@/assets/piece.png" class="puzzle-image image"/>
       <div class="text logo-text" >예금<br> 퍼즐찾기</div></div>

       <div class="image-with-text-container clickable-title" @click="navigateToSavingsTestPage">
      <img src="@/assets/piece.png"  class="puzzle-image image"/>
       <div class="text logo-text" @click="navigateToSavingsTestPage">적금<br> 퍼즐찾기</div></div>

       <div class="image-with-text-container clickable-title" @click="navigateToFundTestPage">
      <img src="@/assets/piece.png" class="puzzle-image image"/>
       <div class="text logo-text" >펀드<br> 퍼즐찾기</div></div>

       <div class="image-with-text-container clickable-title" @click="navigateToLoanTestPage">
      <img src="@/assets/piece.png" class="puzzle-image image"/>
       <div class="text logo-text" >대출<br> 퍼즐찾기</div></div>
       </v-row>

 

   <!-- 배너 영역 -->
   <div class="banner-container2 logo-text d-flex justify-center">
      <!-- 배너 이미지 추가 -->
      <h1 style="margin:100px 200px">모든 금융내역을<br>
    한 곳에서 관리하세요 <br>
    <v-btn class = "logo-text" style="margin-top:30px; font-weight: bold;" @click="navigateToIncomeAnalysisPage">마이데이터 보러가기</v-btn></h1>
      <img src="@/assets/receipt.png" class="banner-image"/>
    
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
@font-face {
  font-family: "WooridaumB";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2205@1.0/WooridaumB.woff2")
    format("woff2");
  font-weight: 700;
  font-style: normal;
}

.logo-text {
  font-size: 16px;
  font-weight: bold;
  font-family: "WooridaumB", sans-serif; /* 적용한 폰트 스타일 사용 */
}


.banner-container {
  background-color: #f6f7ff; /* 배경색 설정 */
  padding: 20px; /* 내부 여백 추가 */
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-top:10px;
}

.banner-container2 {
  background-color: #f6f7ff; /* 배경색 설정 */
  padding: 20px; /* 내부 여백 추가 */
  display: flex;
  align-items: center;
  justify-content: space-between;

  margin-bottom:50px;
}

/* 배너 이미지 스타일 */
.banner-image {
  width: 210px; /* 이미지를 부모 요소의 너비에 맞춤 */
  max-height: 300px; /* 이미지의 최대 높이 설정 */
  margin-right:250px;
  object-fit: cover; /* 이미지를 부모 요소에 맞추고 가로/세로 비율 유지 */
}

.puzzle-image {
  display: flex;
  align-items: center;
  width: 200px; /* 이미지를 부모 요소의 너비에 맞춤 */
  max-height: 300px; /* 이미지의 최대 높이 설정 */
  margin-right:20px;

}

/* 배너 내용 스타일 */
.banner-content {
  margin-top:60px;
  margin-bottom:70px;
  text-align: center;
}

.banner-content h2 {
  font-size: 24px;
  color: #333; /* 텍스트 색상 설정 */
}

.banner-content p {
  font-size: 16px;
  color: #666; /* 텍스트 색상 설정 */
}

/* 각 span 요소를 중앙 정렬하고 간격을 조정합니다 */
.banner-content span {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 10px; /* 간격 조정 */
}
.puzzle-text {
  position: absolute;
  top: 50%; /* 텍스트를 이미지 상단 중앙에 배치합니다 */
  left: 50%;
  transform: translate(-50%, -50%);
  font-size: 16px;
  color: #fff; /* 텍스트 색상 설정 */
  text-align: center;
  background-color: rgba(0, 0, 0, 0.7); /* 텍스트 배경색과 투명도 설정 */
  padding: 5px 10px;
}

/* 이미지와 텍스트 컨테이너 스타일 */
.image-with-text-container {
  position: relative;
  display: inline-block; /* 컨테이너가 이미지와 텍스트의 크기에 맞게 조절되도록 설정 */
  margin-bottom:100px;
}

/* 이미지 스타일 */
.image {
  max-width: 100%; /* 이미지를 컨테이너의 너비에 맞춤 */
  height: auto; /* 이미지 높이를 자동으로 조절하여 비율 유지 */
}

/* 텍스트 스타일 */
.text {
  position: absolute;
  top: 81px; /* 텍스트를 이미지 상단에 배치하려면 필요한 위치 조절 */
  left: 55px; /* 텍스트를 이미지 왼쪽에 배치하려면 필요한 위치 조절 */
  font-size: 15px;
  color:white;
  background-color:#00acea; /* 텍스트 배경색과 투명도 설정 */
  padding: 5px 10px;
}

.clickable-title:hover {
  text-shadow: 0px 1px 2px rgba(0, 0, 0, 0.2);
  cursor: pointer;
}
</style>
