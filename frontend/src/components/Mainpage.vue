<template>
  <v-layout class="rounded rounded-md">
    <v-main
      class="d-flex flex-column align-center justify-center"
      style="min-height: 400px"
    >
      <div class="mb-5" style="margin: 40px; font-size: 1.5em">
        우리WONFIT에서 자신에게 딱 맞는 금융상품을 알아보세요!
      </div>
      <div class="mb-15">
        <v-btn
          variant="tonal"
          class="d-flex justify-center align-center"
          style="padding: 30px; font-size: 1.1em; border-radius: 10px"
        >
          투자성향분석 시작!
        </v-btn>
      </div>

      <div class="d-flex">
        <v-btn
          variant="tonal"
          class="mr-5"
          style="padding: 30px"
          @click="goToRecommendedProducts"
        >
          추천상품 보러가기
        </v-btn>
        <v-btn variant="tonal" style="padding: 30px" @click="goToAllProducts">
          전체상품 보러가기
        </v-btn>
      </div>
    </v-main>
  </v-layout>
</template>

<script>
export default {
  methods: {
    goToRecommendedProducts() {
      // 추천상품 페이지로 이동하는 코드 작성
      // 예: this.$router.push('/recommended-products')
    },
    goToAllProducts() {
      // 전체상품 페이지로 이동하는 코드 작성
      // 예: this.$router.push('/all-products')
    },
  },
};
</script>
