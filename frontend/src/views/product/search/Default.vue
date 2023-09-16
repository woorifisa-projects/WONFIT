<template>
  <div class="bg-color" style="white-space: nowrap">
    <div class="d-flex flex-column align-center justify-center pt-5">
      <!-- <div style="margin: 20px">
        <p class="title-text">상품 유형</p>
      </div> -->

      <v-container>
        <v-row justify="center mt-4">
          <type-button content="예금" @click="navigateToSearchDefault" />
          <type-button content="적금" @click="navigateToSearchSavings" />
          <type-button content="펀드" @click="navigateToSearchFund" />
          <type-button content="대출" @click="navigateToSearchLoan" />
        </v-row>
      </v-container>
    </div>

    <v-text-field
      class="mx-auto mt-7 mb-n3 centered-text-field"
      v-model="searchQuery"
      variant="tonal"
      rounded
      label="상품명 또는 상품타입을 입력해주세요."
      prepend-inner-icon="mdi-magnify"
      single-line
      @click="search"
    ></v-text-field>

    <div class="py-10">
      <v-container>
        <v-row class="flex-child text-subtitle-2">
          <v-col class="mx-auto" width="900">
            <v-sheet class="bg-color">
              <!-- DepositCard 컴포넌트에 데이터 전달 -->
              <deposit-card
                v-for="productDetail in displayedData"
                :key="productDetail.id"
                :productId="productDetail.id"
                :depositName="productDetail.depositName"
                :depositInfo="productDetail.depositInfo"
                :interestRate="'기본금리: ' + productDetail.interestRate + '%'"
                :depositType="'상품타입: ' + getInvestmentType(productDetail.depositType)"
              />
              <div v-if="displayedData.length === 0">
                <p class="d-flex justify-center">검색 결과가 없습니다.</p>
              </div>
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
import DepositCard from "@/components/card/product/DepositCard.vue";
import axios from "axios";

const router = useRouter();
const depositData = ref([]);
const searchQuery = ref("");
const displayedData = ref([]);
const searchTimer = ref(null); // 추가된 부분

function getInvestmentType(depositType) {
  if (depositType === "safe") {
    return "안정형";
  } else if (depositType === "middle") {
    return "중립형";
  } else if (depositType === "attack") {
    return "공격형";
  }
}

// 상품 정보 가져오기
onBeforeMount(async () => {
  const data = await getApi({
    url: "/product/deposit",
  });
  depositData.value = data;
  console.log(depositData.value);
  displayedData.value = data;
});

// 검색 기능
const search = () => {
  const query = searchQuery.value.toLowerCase() || "";
  displayedData.value = depositData.value.filter((product) => {
    if (product.depositName || product.depositType) {
      return (
        product.depositName.toLowerCase().includes(query) ||
        product.depositType.toLowerCase().includes(query)
      );
    }
    return false;
  });
};

watch(searchQuery, () => {
  clearTimeout(searchTimer.value); // 이전 타이머 클리어
  search();
  searchTimer.value = setTimeout(() => {
    // 새로운 타이머 설정
    axios.post(
      "https://back.wonfit.site/member/mypage/searchlog",
      // "http://localhost:8080/member/mypage/searchlog",

      {
        searchWord: searchQuery,
      },
      {
        withCredentials: true,
      }
    );

    console.log(`검색어 "${searchQuery.value}"가 저장되었습니다.`);
  }, 5000);
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
  background-color: white;
}

.bg-color {
  background-color: #f6f7ff;
}
</style>
