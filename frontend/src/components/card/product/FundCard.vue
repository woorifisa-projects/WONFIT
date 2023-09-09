<template>
  <div class="logo-text mx-auto py-2">
    <v-card class="d-flex box-color mx-auto flex-row justify-space-between py-2 px-5" width="800">
      <div class="product-info">
        <v-card-item>
          <v-card-title
            class="clickable-title"
            style="font-size: 25px"
            @click="navigateToFundDetail(2)"
            >{{ fundName }}</v-card-title
          >
          <v-card-subtitle style="font-size: 17px">{{ fundInfo }}</v-card-subtitle>
        </v-card-item>
        <v-card-text>
          1개월 금리: {{ returnRate1 }}%<br />
          6개월 금리: {{ returnRate2 }}%<br />
          기준가: {{ fundPrice }}원<br />
          상품 타입: {{ fundType }}<br />
        </v-card-text>
      </div>
      <v-card-actions class="flex-row-reverse">
        <v-btn class="order-last" @click="navigateToSubscribe(2)">가입하기</v-btn>
        <call-num btnName="전화가입" />
        <v-btn class="order-first">관심상품</v-btn>
      </v-card-actions>
    </v-card>
  </div>
</template>

<script setup>
import { useRouter } from "vue-router";
import CallNum from "@/components/modal/CallNum.vue";

const router = useRouter();
const porps = defineProps({
  fundName: String,
  fundInfo: String,
  returnRate1: Number,
  returnRate2: Number,
  fundPrice: Number,
  fundType: String,
});

// 이전 페이지에서
// 선택된 상품의 ID를 전달하는 함수
const navigateToFundDetail = (productId) => {
  // productId는 선택된 상품의 ID입니다.
  // 라우터를 사용하여 선택된 상품 페이지로 이동합니다.
  console.log(productId);
  router.push({ name: "FundDetailId", params: { id: productId } });
};

// subscribe 페이지로 이동하는 코드
const navigateToSubscribe = (productId) => {
  router.push({ name: "SubFund", params: { id: productId } });
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
