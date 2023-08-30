<template>
  <v-app id="inspire" style="margin-top:20px">

    <v-main class="bg-grey-lighten-3">
      <v-container>
        <v-row>
          <v-col cols="3">
            <v-sheet rounded="lg">
              <v-list rounded="lg">
        

                <v-list-item class="logo-text" @click="navigateToMyInfo" >내 정보 보기</v-list-item>
                <v-list-item class="logo-text" @click="navigateToMySubscribeProduct">내 가입상품 확인하기</v-list-item>
                <v-list-item class="logo-text" @click="navigateToMyLikedProduct">내 관심상품 확인하기</v-list-item>
                <v-list-item class="logo-text" @click="navigateToRecommend">나의 투자성향 보기</v-list-item>
              
              
                <v-divider class="my-2"></v-divider>

                <v-list-item
                  class="logo-text"
                  color="grey-lighten-4"
                  link
                  @click="navigateToWithdraw">
                  회원 탈퇴
                </v-list-item>
              </v-list>
            </v-sheet>
          </v-col>

          <v-col>
            <v-sheet
              min-height="70vh"
              rounded="lg"
            >
            </v-sheet>
          
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
export default {
  methods: {
    navigateToMyInfo() {
      this.$router.push({ name: "MyInfo" });
    },
    
    navigateToMySubscribeProduct() {
      this.$router.push({ name: "MySubscribeProduct" });
    },

    navigateToMyLikedProduct() {
      this.$router.push({ name: "MyLikedProduct" });
    },

    navigateToRecommend() {
      this.$router.push({ name: "Recommend" });
    },

    navigateToWithdraw() {
      this.$router.push({ name: "Withdraw" });
    },

   

  },
}
 
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