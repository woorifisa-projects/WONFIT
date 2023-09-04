<template>
    <v-app id="inspire" style="margin-top:20px">
  
      <v-main class="bg-grey-lighten-3">
        <v-container>
          <v-row>
            <v-col cols="3">
              <v-sheet rounded="lg">
                <v-list rounded="lg">
          
  
                  <v-list-item class="logo-text" @click="navigateToManagerPage" >사용자 관리</v-list-item>
                  <v-list-item class="logo-text" @click="navigateToManageProduct">상품 관리</v-list-item>
                  <v-list-item class="logo-text" @click="navigateToSendTalk">알림톡 보내기</v-list-item>
                  <v-list-item class="logo-text" @click="navigateToMemberSign">사용자 서명 관리</v-list-item>
                
                
                
                </v-list>
              </v-sheet>
            </v-col>
  
            <v-col>
              <v-sheet class="logo-text" style="padding:10px" min-height="70vh" rounded="lg">
              
              </v-sheet>
            
            </v-col>
          </v-row>
        </v-container>
      </v-main>
    </v-app>
  </template>
  
  <script setup>
  import { useRouter } from 'vue-router';
  
      const router = useRouter();
  
    const navigateToManagerPage = () => {
    router.push({ name: "ManagerPage" });
    };
  
    const navigateToManageProduct = () => {
    router.push({ name: "ManageProduct" });
    };
  
  const navigateToSendTalk = () => {
    router.push({ name: "SendTalk" });
  };
  
  const navigateToMemberSign = () => {
    router.push({ name: "MemberSign" });
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