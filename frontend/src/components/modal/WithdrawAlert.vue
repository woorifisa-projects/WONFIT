<template>
  <div class="text-center">
    <v-btn style="font-size: 17px" @click="dialog = true"> {{ btnName }} </v-btn>

    <v-dialog v-model="dialog" max-width="250">
      <v-card class="text-center" style="border-radius: 15px">
        <v-card-text class="pt-7 pb-0"> 회원탈퇴가 완료되었습니다. </v-card-text>
        <v-card-actions class="d-flex justify-center">
          <v-btn color="primary" style="border-radius: 16px" @click="closeDialog">닫기</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>

<script setup>
import { ref, defineProps } from "vue";

const dialog = ref(false);
const props = defineProps({
  btnName: String,
});

// "닫기" 버튼을 누를 때 호출되는 함수
function closeDialog() {
  dialog.value = false; // 다이얼로그 닫기
  router.push("/"); // 메인 페이지로 이동
}
</script>

<style scope></style>
