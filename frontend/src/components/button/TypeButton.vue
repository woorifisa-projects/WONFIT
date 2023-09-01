<template>
  <v-col cols="auto">
    <v-btn size="x-large">
      {{ content }}
    </v-btn>
  </v-col>
</template>

<script setup>
// props를 정의하겠다
defineProps({
  content: {
    // props 중에는 content라는 이름의 props 하나를 정의
    Type: String,
    default: "",
  },
  // props는 여러 개가 될 수 있음
});
</script>

<style lang="scss" scoped></style>
