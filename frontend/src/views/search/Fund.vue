<template>
  <div style="white-space: nowrap" class="logo-text">
    <div class="d-flex flex-column align-center justify-center">
      <div style="margin: 20px">
        <p class="title-text">상품 유형</p>
      </div>

      <v-container>
        <v-row justify="center">
          <custom-button content="예금" @click="navigateToSearchDefault" />
          <custom-button content="적금" @click="navigateToSearchSavings" />
          <custom-button content="펀드" @click="navigateToSearchFund" />
          <custom-button content="대출" @click="navigateToSearchLoan" />
        </v-row>
      </v-container>
    </div>

    <v-card class="mx-auto" flat>
      <v-toolbar color="primary" dark extended flat></v-toolbar>
    </v-card>
    <v-responsive class="mx-auto" max-width="600px" style="margin-top: -75px">
      <v-text-field
        :loading="loading"
        density="comfortable"
        variant="solo"
        label="상품명을 입력해주세요."
        append-inner-icon="mdi-magnify"
        single-line
        hide-details
        @click:append-inner="onClick"
        rounded="xl"
      ></v-text-field>
    </v-responsive>

    <div class="box-color py-10">
      <v-container>
        <v-row class="flex-child text-subtitle-2">
          <v-col class="mx-auto" width="900">
            <v-sheet class="box-color">
              <!-- DepositCard 컴포넌트에 데이터 전달 -->
              <FundCard
                v-for="productDetail in productsDetail"
                :key="productDetail.id"
                :fundName="productDetail.fundName"
                :fundInfo="productDetail.fundInfo"
                :returnRate1="productDetail.returnRate1"
                :returnRate2="productDetail.returnRate2"
                :fundPrice="productDetail.fundPrice"
                :fundType="productDetail.fundType"
              />
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRouter } from "vue-router";
import CustomButton from "@/components/button/TypeButton.vue";
import FundCard from "@/components/card/product/FundCard.vue";
import { findFund } from "@/api/modules/getApi.js";

const loaded = ref(false);
const loading = ref(false);
const router = useRouter();

// productsDetail 데이터를 저장할 ref
const productsDetail = ref([
  {
    fundName: "",
    fundInfo: "",
    returnRate1: 0,
    returnRate2: 0,
    fundPrice: 0,
    fundType: "",
  },
]);

// API 호출 함수를 사용하여 productDetail 데이터 받아오기
const fetchFund = async () => {
  try {
    const response = await findFund();
    console.log(response);
    productsDetail.value = response.data;
    // 받아온 데이터를 productDetail ref에 저장
    Object.assign(productsDetail, response);
  } catch (error) {
    console.error(error.message);
  }
};

// 컴포넌트가 마운트되면 자동으로 데이터 호출
onMounted(() => {
  fetchFund();
});

const onClick = () => {
  loading.value = true;

  setTimeout(() => {
    loading.value = false;
    loaded.value = true;
  }, 1000);
};

const navigateToSearchDefault = () => {
  router.push({ name: "SearchDefault" });
};

const navigateToSearchSavings = () => {
  router.push({ name: "SearchSavings" });
};

const navigateToSearchFund = () => {
  router.push({ name: "SearchFund" });
};

const navigateToSearchLoan = () => {
  router.push({ name: "SearchLoan" });
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

.title-text {
  font-size: 30px;
  font-family: "WooridaumB", sans-serif;
}

.box-color {
  background-color: #eeeeee;
}
</style>
