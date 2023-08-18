<template>
  <div
    class="d-flex justify-center align-center"
    style="margin: 40px; font-size: 1.8em"
  >
    조윤나 고객님에게 딱 맞는 BEST 금융상품 3가지!
  </div>
  <v-item-group selected-class="bg-primary" style="margin: 60px">
    <v-container class="d-flex justify-center align-center min-vh-100">
      <v-row>
        <v-col v-for="n in 3" :key="n" cols="12" md="4" style="padding: 20px">
          <v-item v-slot="{ isSelected, selectedClass, toggle }">
            <v-card
              :class="['d-flex align-center', selectedClass]"
              dark
              height="300"
              @click="toggle"
            >
              <div class="text-h3 flex-grow-1 text-center">
                {{ isSelected ? "상세보기" : "추천상품" }}
              </div>
            </v-card>
          </v-item>
        </v-col>
      </v-row>
    </v-container>
  </v-item-group>
</template>
<script>
export default {
  // 컴포넌트 옵션
};
</script>
