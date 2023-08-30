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
            <!-- <v-sheet class="box-color"> -->
            <FundCard
              fundName="펀드"
              fundInfo="상품 간단 설명"
              returnRate1="1.5"
              returnRate2="2.6"
              fundPrice="1000000"
              fundType="안정형"
            />
            <FundCard
              fundName="펀드"
              fundInfo="상품 간단 설명"
              returnRate1="1.5"
              returnRate2="2.6"
              fundPrice="1000000"
              fundType="안정형"
            />
            <FundCard
              fundName="펀드"
              fundInfo="상품 간단 설명"
              returnRate1="1.5"
              returnRate2="2.6"
              fundPrice="1000000"
              fundType="안정형"
            />
            <!-- </v-sheet> -->
          </v-col>
        </v-row>
      </v-container>
    </div>
  </div>
</template>

<script>
import CustomButton from "@/components/button/TypeButton.vue";
import FundCard from "@/components/card/product/FundCard.vue";

export default {
  data: () => ({
    loaded: false,
    loading: false,
  }),

  methods: {
    onClick() {
      this.loading = true;

      setTimeout(() => {
        this.loading = false;
        this.loaded = true;
      }, 1000);
    },
  },
  components: {
    CustomButton,
    FundCard,
  },
  methods: {
    navigateToSearchDefault() {
      this.$router.push({ name: "SearchDefault" });
    },
    navigateToSearchSavings() {
      this.$router.push({ name: "SearchSavings" });
    },

    navigateToSearchFund() {
      this.$router.push({ name: "SearchFund" });
    },

    navigateToSearchLoan() {
      this.$router.push({ name: "SearchLoan" });
    },
  },
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
