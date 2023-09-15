<template>
  <v-app id="inspire" style="margin-top: 20px">
    <v-main class="bg-grey-lighten-3">
      <v-container>
        <v-row>
          <v-col cols="3">
            <v-sheet rounded="lg">
              <v-list rounded="lg">
                <v-list-item class="logo-text" @click="navigateToManagerPage">사용자 관리</v-list-item>
                <v-list-item class="logo-text" @click="navigateToManageProduct">상품 관리</v-list-item>
                <v-list-item class="logo-text" @click="navigateToSendTalk">SMS 관리</v-list-item>
              </v-list>
            </v-sheet>
          </v-col>
          <v-col>
            <v-sheet class="logo-text" style="padding: 10px" min-height="50vh" rounded="lg">
              <v-table fixed-header height="500px">
                <thead>
                  <tr>
                    <th></th>
                    <th class="text-left">번호</th>
                    <th class="text-left">이름</th>
                    <th class="text-left">회원 아이디</th>
                    <th class="text-left">전화번호</th>
                    <th class="text-left">상태</th>
                  </tr>
                </thead>
                <template v-slot:column.name="{ column }">
                  {{ column.title.toUpperCase() }}
                </template>
                <tbody>
                  <tr v-for="item in memberData" :key="item.idx">
                    <v-checkbox style="margin-top: 1.3rem"></v-checkbox>
                    <td>{{ item.idx }}</td>
                    <td @click="[toggleCardDetails(item), onClickLoginLog()]" class="logo-text hoverable">
                      {{ item.name }}
                    </td>
                    <td>{{ item.loginId }}</td>
                    <td>{{ item.phoneNumber }}</td>
                    <td>
                      <span v-if="item.status">정상</span>
                      <span v-else>탈퇴</span>
                    </td>
                  </tr>
                </tbody>
              </v-table>
            </v-sheet>
            <v-sheet class="logo-text" style="margin-top: 20px" min-height="50vh" rounded="lg" v-if="showCardDetails">
              <v-card>
                <v-tabs bg-color="blue" center-active class="d-flex justify-center">
                  <v-tab style="margin-left: 210px" @click="onClickLoginLog">로그인 기록</v-tab>
                  <v-tab style="margin-left: 210px">검색 기록</v-tab>
                </v-tabs>
              </v-card>
              <v-table fixed-header height="500px">
                <thead>
                  <tr>
                    <th></th>
                    <th class="text-left">번호</th>
                    <th class="text-left">접속 브라우저</th>
                    <th class="text-left">접속 기기</th>
                    <th class="text-left">로그인 시간</th>
                    <th class="text-left">IP</th>
                  </tr>
                </thead>
                <template v-slot:column.name="{ column }">
                  {{ column.title.toUpperCase() }}
                </template>
                <tbody>
                  <tr v-for="item in loginLogData" :key="item.idx">
                    <v-checkbox style="margin-top: 1.3rem"></v-checkbox>
                    <td>{{ item.idx }}</td>
                    <td>{{ item.loginBrowser }}</td>
                    <td>{{ item.loginDevice }}</td>
                    <td>{{ item.loginTime }}</td>
                    <td>{{ item.loginIp }}</td>
                  </tr>
                </tbody>
              </v-table>
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script setup>
import { useRouter } from "vue-router";
import { ref, onBeforeMount } from "vue";
import { getApi, postApi } from "@/api/modules";

const router = useRouter();
const memberData = ref([]);
const loginLogData = ref([]);

const showCardDetails = ref(false);

const memberId = ref([]);

const toggleCardDetails = (item) => {
  if (!showCardDetails.value) {
    showCardDetails.value = !showCardDetails.value;
  }
  memberId.value = item.loginId;
};


onBeforeMount(async () => {
  const data = await getApi({
    url: `/manager/members`,
  });

  for (let i = 0; i < data.length; i++) {
    data[i].idx = i + 1;
  }
  memberData.value = data;
});

const onClickLoginLog = async () => {
  try {
    const requestBody = {
      loginId: memberId.value,
    };
    const data = await postApi({
      url: `/member/mypage/loginlog/by/loginid`,
      data: requestBody
    });
    for (let i = 0; i < data.length; i++) {
      data[i].idx = i + 1;
    }
    loginLogData.value = data;

    console.log('로그 데이터:', data);
  } catch (error) {
    console.error('에러 발생:', error);
  }
};

const navigateToManagerPage = () => {
  router.push({ name: "ManagerPage" });
};

const navigateToManageProduct = () => {
  router.push({ name: "ManageProduct" });
};
// /member/mypage/loginlog/loginId

const navigateToSendTalk = () => {
  router.push({ name: "SendTalk" });
};
</script>

<style scoped>
@font-face {
  font-family: "WooridaumB";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2205@1.0/WooridaumB.woff2") format("woff2");
  font-weight: 300;
  font-style: normal;
}

.logo-text {
  font-size: 15px;
  font-family: "WooridaumB", sans-serif;
}

.logo-text:hover {
  cursor: pointer;
}
</style>
