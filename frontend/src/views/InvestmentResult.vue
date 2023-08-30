<template>
  <v-app>
    <v-navigation-drawer app></v-navigation-drawer>
    <v-toolbar app></v-toolbar>
    // 본문
    <v-content>
      <v-container>
        // 내용 // 그리드
        <v-row>
          <v-col> // 그리드 cell 내용 </v-col>
        </v-row>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
export default {
  data: () => ({
    visible: false,
  }),
};
</script>

<style></style>
