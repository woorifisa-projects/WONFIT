<template>
  <v-sheet elevation="3" max-width="900" rounded="lg" width="100%" class="px-6 pt-5 mx-auto">
    <v-card-item style="line-height: 1.7">
      <v-card-title class="clickable-title" style="font-size: 25px">{{ name }}</v-card-title>
      <v-card-subtitle style="font-size: 17px">{{ info }}</v-card-subtitle>
    </v-card-item>

    <v-divider class="mb-2"></v-divider>

    <v-row>
      <v-col cols="6">
        <v-card-text class="py-5" style="font-size: large; letter-spacing: 1px; line-height: 2">
          <p>{{ interestRate }}</p>
          <p v-if="returnRate2">{{ returnRate2 }}</p>
          <p v-if="target">{{ target }}</p>
          <p v-if="period">{{ period }}</p>
          <p v-if="minDeposit">{{ /*예금 - 가입 금액*/ minDeposit }}</p>
          <p v-if="maxDeposit">{{ /*적금 - */ maxDeposit }}</p>
          <p v-if="fundPrice">{{ /*펀드 - 기준가*/ fundPrice }}</p>
          <p v-if="loanLimit">{{ /*대출 - */ loanLimit }}</p>
          <p>{{ type }}</p>
        </v-card-text>
      </v-col>
      <v-col cols="6">
        <v-card-text>
          <div class="text-end">
            <div class="pa-2">
              <v-btn
                color="#3C7FE3"
                rounded="xl"
                width="160"
                height="45"
                style="font-size: large; color: white"
                @click="handleButtonClick"
              >
                {{ button1 }}
              </v-btn>
            </div>

            <div class="pa-2">
              <v-btn
                color="#3C7FE3"
                rounded="xl"
                width="160"
                height="45"
                style="font-size: large; color: white"
              >
                {{ button2 }}
              </v-btn>
            </div>
            <div class="pa-2 mt-1">
              <v-btn rounded="xl" width="160" height="45" style="font-size: medium">
                <svg-icon
                  type="mdi"
                  :path="path"
                  style="margin-right: 8px"
                  color="#1867C0"
                ></svg-icon>
                관심상품 등록</v-btn
              >
            </div>
          </div>
        </v-card-text>
      </v-col>
    </v-row>
  </v-sheet>
</template>

<script setup>
import { ref, watch, defineProps, defineEmits } from "vue";
import SvgIcon from "@jamescoyle/vue-icon";
import { mdiPuzzleHeart } from "@mdi/js";

// ref를 사용하여 초기값이 false인 loading 데이터를 정의합니다.
const loading = ref(false);
const path = ref(mdiPuzzleHeart);
const emits = defineEmits(["button-click"]);

// loading 데이터가 변경될 때 실행될 함수를 정의합니다.
watch(loading, (val) => {
  if (!val) return;

  setTimeout(() => {
    loading.value = false;
  }, 2000);
});

const props = defineProps([
  "name",
  "info",
  "interestRate",
  "returnRate2",
  "target",
  "period",
  "minDeposit",
  "maxDeposit",
  "fundPrice",
  "loanLimit",
  "type",
  "button1",
  "button2",
]);

// 상품에 상관없이 불러올 수 있는 값
const name = props.name;
const info = props.info;
const type = props.type;

// 버튼 클릭 핸들러를 정의합니다.
const handleButtonClick = () => {
  // 버튼이 클릭되었을 때 이벤트를 발생시킵니다.
  emits("button-click", "button1");
};
</script>

<style></style>
