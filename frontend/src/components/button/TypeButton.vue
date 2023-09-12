<template>
  <v-col cols="auto">
    <v-btn variant="solo" size="x-large">
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

// 버튼 클릭 유지
</script>

<style lang="scss" scoped>
// 마우스 가져가면 버튼 떠오르는 효과
.v-btn {
  transition: 0.4s;
  &:hover {
    transform: translateY(-4px);
  }

  // border: 1px solid hwb(225 94% 1%);
  background-color: #ffffff;
  border: 1px solid #e6e8e9;
  border-radius: 10px;
}
</style>
