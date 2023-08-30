<template>
  <v-app id="inspire">
    <v-app-bar flat>
      <v-container class="mx-auto d-flex align-center justify-center">
        <!-- <v-avatar
          class="me-4 "
          color="grey-darken-1"
          size="32"
        ></v-avatar> -->

        <!-- <v-btn
          v-for="link in links"
          :key="link"
          :text="link"
          variant="text"
        ></v-btn> -->

        <v-spacer></v-spacer>

        <v-responsive max-width="200">
        
        </v-responsive>
      </v-container>
    </v-app-bar>

    <v-main class="bg-grey-lighten-3">
      <v-container>
        <v-row>
          <v-col cols="3">
            <v-sheet rounded="lg">
              <v-list rounded="lg">
                <!-- <v-list-item
                  v-for="n in 5"
                  :key="n"
                  link
                  :title="`내 정보 보기 ${n}`"
                ></v-list-item> -->

                <v-list-item>내 정보 보기</v-list-item>
                <v-list-item>내 가입상품 확인하기</v-list-item>
                <v-list-item>내 관심상품 확인하기</v-list-item>
                <v-list-item>나의 투자성향 보기</v-list-item>
              
                 
                

                <v-divider class="my-2"></v-divider>

                <v-list-item
                  color="grey-lighten-4"
                  link
                  title="회원 탈퇴"
                ></v-list-item>
              </v-list>
            </v-sheet>
          </v-col>

          <v-col>
            <v-sheet
              min-height="70vh"
              rounded="lg"
            >
              <!--  -->
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script setup>
  const links = [
    'Dashboard',
    'Messages',
    'Profile',
    'Updates',
  ]


  export default {
    data: () => ({
      links: [
        'Dashboard',
        'Messages',
        'Profile',
        'Updates',
      ],
    }),
  }
</script>

