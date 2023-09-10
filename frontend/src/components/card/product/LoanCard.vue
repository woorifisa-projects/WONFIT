<template>
  <div class="logo-text mx-auto py-3">
    <v-card
      class="d-flex box-border mx-auto flex-row justify-space-between py-2 px-5"
      variant="outlined"
      width="800"
    >
      <div class="product-info" @click="navigateToLoanDetail(2)">
        <v-card-item>
          <v-card-title
            style="font-size: 25px; color: rgb(0, 86, 199)"
            @click="navigateToLoanDetail(2)"
            >{{ loanName }}</v-card-title
          >
          <v-card-subtitle style="font-size: 17px">{{ loanInfo }}</v-card-subtitle>
        </v-card-item>
        <v-card-text>
          <p class="py-3">{{ interestRate }}</p>
          <p class="pb-3">{{ loanLimit }}</p>
          <p>{{ loanType }}</p>
        </v-card-text>
      </div>
      <v-card-actions class="flex-row-reverse" @click="navigateToLoanDetail(2)">
        <v-btn class="order-last" text @click.stop="navigateToSubscribe(2)">대출신청</v-btn>
        <call-num btnName="전화신청" @click.stop />
        <v-btn class="order-first" @click.stop>관심상품</v-btn>
      </v-card-actions>
    </v-card>
  </div>
</template>

<script setup>
import { useRouter } from "vue-router";
import CallNum from "@/components/modal/CallNum.vue";

const router = useRouter();

defineProps({
  loanName: String,
  loanInfo: String,
  interestRate: Number,
  target: String,
  period: Number,
  loanLimit: Number,
  loanType: String,
});

// 이전 페이지에서
// 선택된 상품의 ID를 전달하는 함수
const navigateToLoanDetail = (productId) => {
  // productId는 선택된 상품의 ID입니다.
  // 라우터를 사용하여 선택된 상품 페이지로 이동합니다.
  console.log(productId);
  router.push({ name: "LoanDetailId", params: { id: productId } });
};

// subscribe 페이지로 이동하는 코드
const navigateToSubscribe = (productId) => {
  router.push({ name: "SubLoan", params: { id: productId } });
};
</script>

<style lang="scss" scoped>
.product-info {
  flex-basis: 50%;
  cursor: pointer;
}

.v-card-actions {
  flex-basis: 50%;
  justify-self: end;
  cursor: pointer;
}

.v-card-actions .v-btn {
  margin-left: 10px;
  margin-right: 10px;
  font-size: 17px;
}

.v-card-text {
  font-size: 17px;
}

.box-border {
  border: 1px solid #e6e8e9;
  border-radius: 15px;
}
.box-border:hover {
  box-shadow: 3px 3px 15px #dae6f6;
}
</style>
