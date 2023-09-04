<template>
  <v-app id="inspire" style="margin-top:20px">

    <v-main class="bg-grey-lighten-3">
      <v-container>
        <v-row>
          <v-col cols="3">
            <v-sheet rounded="lg">
              <v-list rounded="lg">
        

                <v-list-item class="logo-text" @click="navigateToMyPage" >내 정보 보기</v-list-item>
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
            <v-sheet class="logo-text" style="padding:40px" min-height="70vh" rounded="lg">
              <div >주소
                
                <div class="text-center">
    <v-select
      v-model="location"
      :items="locations"
      label="Location"
    ></v-select>
    <v-menu :location="location">
      <template v-slot:activator="{ props }">
       
      </template>

      <v-list>
        <v-list-item
          v-for="(item, index) in items"
          :key="index"
        >
          <v-list-item-title>{{ item.title }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>
  </div>
                
              </div>
              <div class=my-10>
                결혼여부
                <v-radio-group inline style="margin:10px">
                <v-radio label="결혼" value="1"></v-radio>
  <v-radio label="미혼" value="2"></v-radio>
  </v-radio-group>
              </div>
              <div class=my-10>
                자녀수
                <v-radio-group inline style="margin:10px">
          <v-radio label="0명" value="1"></v-radio>
  <v-radio label="1명" value="2"></v-radio>
  <v-radio label="2명" value="3"></v-radio>
  <v-radio label="3명" value="4"></v-radio>
  <v-radio label="4명 이상" value="5"></v-radio>
</v-radio-group>
              </div>
              <div class=my-10>
                세대주 여부
                <v-radio-group inline style="margin:10px">
                <v-radio label="예" value="1"></v-radio>
  <v-radio label="아니요" value="2"></v-radio>
  </v-radio-group>
              </div>
              <div class=my-10>
                연금 소득 여부
                <v-radio-group inline style="margin:10px">
                <v-radio label="있음" value="1"></v-radio>
  <v-radio label="없음" value="2"></v-radio>
  </v-radio-group>
              </div>
              <div class=my-10 style="margin-bottom:30px">
                직업
                <v-radio-group inline style="margin:10px">
                <v-radio label="직장인" value="1"></v-radio>
  <v-radio label="개인사업자" value="2"></v-radio>
  <v-radio label="프리랜서" value="3"></v-radio>
  <v-radio label="학생" value="4"></v-radio>
  <v-radio label="주부" value="5"></v-radio>
  <v-radio label="은퇴생활자" value="6"></v-radio>
  <v-radio label="무직" value="7"></v-radio>
  </v-radio-group>
              
              </div>
              <v-btn
          variant="tonal"
          class="d-flex justify-end align-center logo-text-button"
          style="padding: 25px; font-size: 1.1em; border-radius: 5px;margin-left: auto"

        >
          저장
        </v-btn>
            </v-sheet>
          
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script setup>
import { useRouter } from 'vue-router';
import { ref } from 'vue';
import axios from 'axios';

const router = useRouter();
const menuData = ref([]);



  const locations = [
      '서울특별시',
      '인천광역시',
      '대전광역시',
      '울산광역시',
      '대구광역시',
      '광주광역시',
      '부산광역시',
      '세종특별자치시',
      '경기도',
      '강원특별자치도',
      '전라남도',
      '전라북도',
      '전라남도',
      '전라북도',
      '충청북도',
      '충청남도',
      '경상남도',
      '경상북도',
      '제주특별자치도',
    ];
    const location = '주소를 선택해주세요';

  const navigateToMyPage = () => {
  router.push({ name: "MyPage" });
  };

  const navigateToMySubscribeProduct = () => {
  router.push({ name: "MySubscribeProduct" });
};

const navigateToMyLikedProduct = () => {
  router.push({ name: "MyLikedProduct" });
};

const navigateToRecommend = () => {
  router.push({ name: "Recommend" });
};

const navigateToWithdraw = () => {
  router.push({ name: "Withdraw" });
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