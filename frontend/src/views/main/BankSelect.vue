<template>
  <v-layout class="rounded rounded-md">
    <v-main class="d-flex flex-column align-center justify-center" style="margin-top: 30px; min-height: 400px">
      <div class="d-flex flex-column align-center justify-center logo-text" style="font-size: 1.5em">
        어떤 은행사를 연결할까요?
        <div class="image-grid bank-name">
          <div class="grid-row">
            <div class="grid-item">
              <button class="bank-button" :class="{ 'bank-button-selected': selectedBank.includes('국민은행') }"
                @click="toggleBank('국민은행')">
                <img src="@/assets/kookmin.png" alt="국민은행" />
                <p>국민은행</p>
              </button>
            </div>
            <div class="grid-item">
              <button class="bank-button" :class="{ 'bank-button-selected': selectedBank.includes('우리은행') }"
                @click="toggleBank('우리은행')">
                <img src="@/assets/woori.png" alt="우리은행" />
                <p>우리은행</p>
              </button>
            </div>
            <div class="grid-item">
              <button class="bank-button" :class="{ 'bank-button-selected': selectedBank.includes('신한은행') }"
                @click="toggleBank('신한은행')">
                <img src="@/assets/shinhan.png" alt="신한은행" />
                <p>신한은행</p>
              </button>
            </div>
          </div>
          <div class="grid-row">
            <div class="grid-item">
              <button class="bank-button" :class="{ 'bank-button-selected': selectedBank.includes('카카오뱅크') }"
                @click="toggleBank('카카오뱅크')">
                <img src="@/assets/kakao.png" alt="카카오뱅크" />
                <p>카카오뱅크</p>
              </button>
            </div>
            <div class="grid-item">
              <button class="bank-button" :class="{ 'bank-button-selected': selectedBank.includes('토스뱅크') }"
                @click="toggleBank('토스뱅크')">
                <img src="@/assets/toss.png" alt="토스뱅크" />
                <p>토스뱅크</p>
              </button>
            </div>
            <div class="grid-item">
              <button class="bank-button" :class="{ 'bank-button-selected': selectedBank.includes('케이뱅크') }"
                @click="toggleBank('케이뱅크')">
                <img src="@/assets/kbank.png" alt="케이뱅크" />
                <p>케이뱅크</p>
              </button>
            </div>
          </div>
          <div class="grid-row">
            <div class="grid-item">
              <button class="bank-button" :class="{ 'bank-button-selected': selectedBank.includes('농협은행') }"
                @click="toggleBank('농협은행')">
                <img src="@/assets/nonghyup.png" alt="농협은행" />
                <p>농협은행</p>
              </button>
            </div>
            <div class="grid-item">
              <button class="bank-button" :class="{ 'bank-button-selected': selectedBank.includes('IBK기업은행') }"
                @click="toggleBank('IBK기업은행')">
                <img src="@/assets/ibk.png" alt="IBK기업은행" />
                <p>IBK기업은행</p>
              </button>
            </div>
            <div class="grid-item">
              <button class="bank-button" :class="{ 'bank-button-selected': selectedBank.includes('SC제일은행') }"
                @click="toggleBank('SC제일은행')">
                <img src="@/assets/sc.png" alt="SC제일은행" />
                <p>SC제일은행</p>
              </button>
            </div>
          </div>
        </div>
      </div>

      <div class="mb-5 logo-text" style="margin: 60px; font-size: 1.5em">
        <AnnualIncomeComponent @update="(val) => annualIncome = val" />

      </div>

      <div class="mb-2 logo-text d-flex flex-column align-center justify-center" style="margin: 10px; font-size: 1.5em">
        <AgeGroupComponent @update:group="(val) => ageGroup = val" />

      </div>

      <v-spacer></v-spacer>
      <div class="mb-15">
        <v-btn variant="tonal" class="d-flex justify-center align-center logo-text-button"
          style="padding: 30px; font-size: 1.1em; border-radius: 10px" @click="navigateToIncomeAnalysisPage">
          결과보기
        </v-btn>
      </div>
    </v-main>
  </v-layout>
</template>

<script setup>
import { ref } from 'vue';
import axios from 'axios';
import { useRouter } from "vue-router";
import AnnualIncomeComponent from './AnnualIncomeComponent.vue';
import AgeGroupComponent from './AgeGroupComponent.vue';

const router = useRouter();

const annualIncome = ref(null);
const ageGroup = ref(null);
const selectedBank = ref([]);

const toggleBank = (bankName) => {
  if (selectedBank.value.includes(bankName)) {
    // 이미 선택된 은행이면 제거
    selectedBank.value = selectedBank.value.filter((bank) => bank !== bankName);
  } else {
    // 선택되지 않은 은행이면 추가
    selectedBank.value.push(bankName);
  }
};

const navigateToIncomeAnalysisPage = async () => {
  console.log(annualIncome.value); // .value 를 사용하여 ref의 값을 가져옵니다.

  const body = {
    annualIncome: annualIncome.value, // .value 를 사용하여 ref의 값을 가져옵니다.
    ageGroup: ageGroup.value, // .value 를 사용하여 ref의 값을 가져옵니다. 
  }

  await axios.patch('http://localhost:8080/member/mydata', body);

  router.push({ name: "Recommend" });
}

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

/* Add the following styles for the image grid */
.image-grid {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.bank-button-selected {
  border: 2px solid #007bff;
  border-radius: 5px;
}

.grid-row {
  display: flex;
  justify-content: space-between;
  /* Update this line */
  margin-top: 30px;
  margin-bottom: 10px;
}

.bank-name {
  font-size: 15px;
  text-align: center;
}

.grid-item {
  margin: 0 15px;
}

.grid-item img {
  width: 70px;
  height: 70px;
}

.bank-button {
  background-color: transparent;
  padding: 0;
  cursor: pointer;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.bank-button:focus {
  outline: none;
}

/* :hover 스타일 추가 */
.bank-button:hover {
  /* 원하는 스타일을 여기에 추가하세요 */
  border: 2px solid #007bff;
  /* 예: 파란 테두리 */
  border-radius: 5px;
}
</style>

