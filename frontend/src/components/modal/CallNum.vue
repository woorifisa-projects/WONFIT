<template>
  <div class="text-center">
    <v-btn style="font-size: 17px" @click="dialog = true"> {{ btnName }} </v-btn>

    <v-dialog v-model="dialog" max-width="250">
      <v-card class="text-center" style="border-radius: 15px">
        <v-card-text class="pt-7 pb-0"> 고객상담 02-123-4567 </v-card-text>
        <v-card-actions class="d-flex justify-center">
          <v-btn color="primary" style="border-radius: 16px" @click="dialog = false">닫기</v-btn>
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
</script>

<style scope></style>
