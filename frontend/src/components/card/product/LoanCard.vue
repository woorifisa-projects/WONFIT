<template>
  <div class="logo-text mx-auto py-3">
    <v-card
      class="d-flex box-border mx-auto flex-row justify-space-between py-2 px-5"
      variant="outlined"
      width="800"
    >
      <div class="product-info" @click="navigateToDetail">
        <v-card-item>
          <v-card-title class="py-2" style="font-size: 25px; color: rgb(0, 86, 199)">{{
            loanName
          }}</v-card-title>
          <v-card-subtitle style="font-size: 17px">{{ loanInfo }}</v-card-subtitle>
        </v-card-item>
        <v-card-text>
          <p class="py-3">{{ interestRate }}</p>
          <p class="pb-3">{{ loanLimit }}</p>
          <p>{{ loanType }}</p>
        </v-card-text>
      </div>
      <v-card-actions class="flex-row-reverse" @click="navigateToDetail">
        <v-btn class="order-last" text @click.stop="navigateToSubscribe">대출신청</v-btn>
        <call-num btnName="전화신청" @click.stop />
        <v-btn class="order-first" @click.stop="toggleLike"
          ><svg-icon
            type="mdi"
            :path="isShow ? heartOutline : heart"
            color="#0056C7"
            size="27"
          ></svg-icon
          >관심상품</v-btn
        >
      </v-card-actions>
    </v-card>
  </div>
</template>

<script setup>
import { useRouter } from "vue-router";
import { ref, defineProps, onBeforeMount } from "vue";
import SvgIcon from "@jamescoyle/vue-icon";
import { mdiPuzzleHeart, mdiPuzzleHeartOutline } from "@mdi/js";
import { getApi } from "@/api/modules";
import CallNum from "@/components/modal/CallNum.vue";

const heart = ref(mdiPuzzleHeart);
const heartOutline = ref(mdiPuzzleHeartOutline);
const isShow = ref(true);
const likedData = ref([]);

const router = useRouter();

const props = defineProps({
  productId: Number,
  loanName: String,
  loanInfo: String,
  interestRate: Number,
  loanLimit: Number,
  loanType: String,
});

const productId = props.productId;
const navigateToDetail = () => {
  console.log(productId);
  router.push({ name: "LoanDetailId", params: { id: productId } });
};

const navigateToSubscribe = () => {
  router.push({ name: "SubLoan", params: { id: productId } });
};

// "좋아요" 상태를 토글하는 메서드
const toggleLike = () => {
  isShow.value = !isShow.value; // "좋아요" 상태를 반전시킵니다.
};

// 관심상품 정보 가져오기
onBeforeMount(async () => {
  const data = await getApi({
    url: "/member/mypage/liked",
  });
  likedData.value = data;
  console.log(likedData);
});
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
  background-color: white;
  box-shadow: 1px 1px 5px #dae6f6;
}
.box-border:hover {
  box-shadow: 5px 5px 20px #dae6f6;
}
</style>
