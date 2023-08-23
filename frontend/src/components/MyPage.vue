<template>
  <!-- <v-card> -->
  <!-- v-card를 사용하면 레이아웃이 깨짐 -->
  <v-layout>
    <v-navigation-drawer floating permanent>
      <v-list density="compact" nav>
        <v-list-item
          prepend-icon="mdi-account"
          title="사용자 관리"
          value="사용자 관리"
        ></v-list-item>
        <v-list-item
          prepend-icon="mdi-view-dashboard"
          title="상품관리"
          value="상품 관리"
        ></v-list-item>
        <v-list-item
          prepend-icon="mdi-forum"
          title="알림톡 보내기"
          value="알림톡 보내기"
        ></v-list-item>
      </v-list>
    </v-navigation-drawer>
    <v-main
      style="
        height: 250px;
        display: flex;
        justify-content: center;
        align-items: center;
      "
    >
      <v-sheet :height="200" :width="800" color="grey-lighten-3">
        <v-table fixed-header height="300px">
          <thead>
            <tr>
              <th></th>
              <th class="text-left">번호</th>
              <th class="text-left">아이디</th>
              <th class="text-left">이름</th>
              <th class="text-left">등급</th>
              <th class="text-left">상태</th>
              <th class="text-left">접속수</th>
              <th class="text-left">가입일</th>
            </tr>
          </thead>
          <template v-slot:column.name="{ column }">
            {{ column.title.toUpperCase() }}
          </template>
          <tbody>
            <tr v-for="item in users" :key="item.id">
              <v-checkbox style="margin-top: 1.3rem"></v-checkbox>
              <td>{{ item.idx }}</td>
              <td>{{ item.id }}</td>
              <td>{{ item.name }}</td>
              <td>{{ item.grade }}</td>
              <td>{{ item.status }}</td>
              <td>{{ item.loginCount }}</td>
              <td>{{ item.regDate }}</td>
            </tr>
          </tbody>
        </v-table>
      </v-sheet>
    </v-main>
  </v-layout>
  <!-- </v-card> -->
</template>

<script>
export default {
  data() {
    return {
      users: [
        {
          idx: 1,
          id: "bjj1234",
          name: "김원핏",
          grade: "일반",
          status: "정상",
          loginCount: 1,
          regDate: "2020-01-01",
        },
        {
          idx: 1,
          id: "bjj1234",
          name: "김원핏",
          grade: "일반",
          status: "정상",
          loginCount: 1,
          regDate: "2020-01-01",
        },
        {
          idx: 1,
          id: "bjj1234",
          name: "김원핏",
          grade: "일반",
          status: "정상",
          loginCount: 1,
          regDate: "2020-01-01",
        },
        {
          idx: 1,
          id: "bjj1234",
          name: "김원핏",
          grade: "일반",
          status: "정상",
          loginCount: 1,
          regDate: "2020-01-01",
        },
        {
          idx: 1,
          id: "bjj1234",
          name: "김원핏",
          grade: "일반",
          status: "정상",
          loginCount: 1,
          regDate: "2020-01-01",
        },
        {
          idx: 1,
          id: "bjj1234",
          name: "김원핏",
          grade: "일반",
          status: "정상",
          loginCount: 1,
          regDate: "2020-01-01",
        },
        {
          idx: 1,
          id: "bjj1234",
          name: "김원핏",
          grade: "일반",
          status: "정상",
          loginCount: 1,
          regDate: "2020-01-01",
        },
      ],
    };
  },
};
</script>

<style scoped></style>
```
