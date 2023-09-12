<template>
  <div class="text-center">
    <v-btn
      style="font-size: 15px; border-radius: 15px"
      height="40px"
      @click="dialog = true"
      color="#3C7FE3"
    >
      {{ btnName }}
    </v-btn>

    <v-dialog v-model="dialog" max-width="250">
      <v-card class="text-center" style="border-radius: 15px">
        <v-card-text class="pt-7 pb-0"> {{ text }} </v-card-text>
        <v-card-actions class="d-flex justify-center">
          <v-btn color="primary" style="border-radius: 16px" @click="closeDialog">닫기</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>

<script setup>
import { ref, defineProps } from "vue";
import { useRouter } from "vue-router";
const router = useRouter();

const dialog = ref(false);
const props = defineProps({
  btnName: String,
  text: String,
});

// "닫기" 버튼을 누를 때 호출되는 함수
function closeDialog() {
  dialog.value = false; // 다이얼로그 닫기
  router.push({ name: "MainPage" }); // 메인 페이지
}
</script>

<style scope></style>
