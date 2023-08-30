<template>
  <v-btn variant="tonal" class="d-flex justify-center align-center logo-text-button"
    style="padding: 30px; font-size: 1.1em; border-radius: 10px" @click="navigateToIncomeAnalysisPage">
    {{ content }}
  </v-btn>
</template>

<script setup>

import { defineProps } from 'vue';

const props = defineProps({
  content: String,
});


</script>

<style lang="scss" scoped></style>