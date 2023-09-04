<template>
  <div class="logo-text mx-auto py-2" color="#eeeeee">
    <v-card class="d-flex box-color mx-auto flex-row justify-space-between py-2 px-5" width="800">
      <div class="product-info">
        <v-card-item>
          <v-card-title
            class="clickable-title"
            style="font-size: 25px"
            @click="navigateToSavingsDetail(2)"
            >{{ savingsName }}</v-card-title
          >
          <v-card-subtitle style="font-size: 17px">{{ savingsInfo }}</v-card-subtitle>
        </v-card-item>
        <v-card-text>
          상품 금리: {{ interestRate }}%<br />
          가입 대상: {{ target }}<br />
          가입 기간: {{ period }}개월<br />
          적립 금액: {{ maxDeposit }}원<br />
          상품 타입: {{ savingsType }}<br />
        </v-card-text>
      </div>
      <v-card-actions class="flex-row-reverse">
        <v-btn class="order-last" text>가입하기</v-btn>
        <v-btn text>전화가입</v-btn>
        <v-btn class="order-first" text>관심상품</v-btn>
      </v-card-actions>
    </v-card>
  </div>
</template>

<script setup>
import { useRouter } from "vue-router";

const router = useRouter();

defineProps({
  savingsName: String,
  savingsInfo: String,
  target: String,
  interestRate: Number,
  period: Number,
  maxDeposit: Number,
  savingsType: String,
});

// 이전 페이지에서
// 선택된 상품의 ID를 전달하는 함수
const navigateToSavingsDetail = (productId) => {
  // productId는 선택된 상품의 ID입니다.
  // 라우터를 사용하여 선택된 상품 페이지로 이동합니다.
  console.log(productId);
  router.push({ name: "SavingsDetailId", params: { id: productId } });
};
</script>

<style lang="scss" scoped>
.product-info {
  flex-basis: 50%;
}

.clickable-title:hover {
  text-shadow: 0px 1px 2px rgba(0, 0, 0, 0.2);
  cursor: pointer;
}

.v-card-actions {
  flex-basis: 50%;
  justify-self: end;
}

.v-card-actions .v-btn {
  margin-left: 10px;
  margin-right: 10px;
  font-size: 17px;
  font-weight: bold;
  font-family: "WooridaumB", sans-serif;
}

.v-card-text {
  font-size: 17px;
}

.box-color {
  border-radius: 15px;
}
</style>
