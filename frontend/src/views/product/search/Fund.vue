<template>
  <div style="white-space: nowrap" class="logo-text">
    <div class="d-flex flex-column align-center justify-center mt-10">
      <v-container>
        <v-row justify="center">
          <type-button content="예금" @click="navigateToSearchDefault" />
          <type-button content="적금" @click="navigateToSearchSavings" />
          <type-button content="펀드" @click="navigateToSearchFund" />
          <type-button content="대출" @click="navigateToSearchLoan" />
        </v-row>
      </v-container>
    </div>

    <v-text-field
      class="mx-auto mt-10 mb-n5 centered-text-field"
      v-model="searchQuery"
      variant="tonal"
      rounded
      label="상품명을 입력해주세요."
      prepend-inner-icon="mdi-magnify"
      single-line
      @click="search"
    ></v-text-field>

    <div class="py-10">
      <v-container>
        <v-row class="flex-child text-subtitle-2">
          <v-col class="mx-auto" width="900">
            <v-sheet>
              <!-- FundCard 컴포넌트에 데이터 전달 -->
              <fund-card
                v-for="productDetail in displayedData"
                :key="productDetail.id"
                :fundName="productDetail.fundName"
                :fundInfo="productDetail.fundInfo"
                :returnRate1="'1개월 수익률: ' + productDetail.returnRate1 + '%'"
                :returnRate2="'6개월 수익률: ' + productDetail.returnRate2 + '%'"
                :fundPrice="'기준가: ' + productDetail.fundPrice + '원'"
                :fundType="'상품 타입: ' + productDetail.fundType"
              />
              <div v-if="displayedData.length === 0">검색 결과가 없습니다.</div>
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </div>
  </div>
</template>

<script setup>
import { ref, onBeforeMount, watch } from "vue";
import { useRouter } from "vue-router";
import { getApi } from "@/api/modules";
import TypeButton from "@/components/button/TypeButton.vue";
import FundCard from "@/components/card/product/FundCard.vue";

const router = useRouter();
const fundData = ref([]);
const searchQuery = ref("");
const displayedData = ref([]);

// 상품 정보 가져오기
onBeforeMount(async () => {
  const data = await getApi({
    url: "/product/fund",
  });
  fundData.value = data;
  displayedData.value = data;
});

// 검색 기능
const search = () => {
  const query = searchQuery.value.toLowerCase() || "";
  displayedData.value = fundData.value.filter((product) => {
    if (product.fundName) {
      return product.fundName.toLowerCase().includes(query);
    }
    return false;
  });
  console.log(displayedData);
};

watch(searchQuery, () => {
  search();
});

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
.centered-text-field {
  border: 1px solid #e0e0e0;
  border-radius: 50px;
  height: 55px;
  width: 530px;
}
</style>
