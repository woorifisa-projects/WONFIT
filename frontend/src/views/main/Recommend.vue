<template>
  <div class="logo-text d-flex justify-center align-center" style="margin: 40px; font-size: 1.8em">
    조윤나 고객님에게 딱 맞는 BEST 금융상품 4가지!
  </div>
  <v-item-group selected-class="bg-primary" style="margin:70px">
    <v-container class="d-flex justify-center align-center min-vh-100">
      <v-row >
        <v-col >
          <v-item v-slot="{ isSelected, selectedClass, toggle }">
            <v-card
              :class="['logo-text d-flex align-center', selectedClass]"
              dark
              height="300"
              @click="toggle"
            >
              <div class="text-h3 flex-grow-1 text-center">
                {{ isSelected ? "우리WON예금" : "예금" }}
              </div>
            </v-card>
            
          </v-item>
        </v-col>
        <v-col >
          <v-item v-slot="{ isSelected, selectedClass, toggle }">
            <v-card
              :class="['d-flex align-center', selectedClass]"
              dark
              height="300"
              @click="toggle"
            >
              <div class="text-h3 flex-grow-1 text-center">
                {{ isSelected ? "우리WON적금" : "적금" }}
              </div>
            </v-card>
            
          </v-item>
        </v-col>
        <v-col>
          <v-item v-slot="{ isSelected, selectedClass, toggle }">
            <v-card
              :class="['d-flex align-center', selectedClass]"
              dark
              height="300"
              @click="toggle"
            >
              <div class="text-h3 flex-grow-1 text-center">
                {{ isSelected ? "우리WON펀드" : "펀드" }}
              </div>
            </v-card>
            
          </v-item>
        </v-col>
        <v-col >
          <v-item v-slot="{ isSelected, selectedClass, toggle }">
            <v-card
              :class="['d-flex align-center', selectedClass]"
              dark
              height="300"
              @click="toggle"
            >
              <div class="text-h3 flex-grow-1 text-center">
                {{ isSelected ? "우리WON대출" : "대출" }}
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

<style scoped>
@font-face {
  font-family: "WooridaumB";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2205@1.0/WooridaumB.woff2")
    format("woff2");
  font-weight: 300;
  font-style: normal;
}

.logo-text {
  font-size: 15px;
  font-family: "WooridaumB", sans-serif;
}

</style>