<template>

        <v-card :subtitle="subtitle" :text="text" width="450px"></v-card>

</template>

<script setup>
import { defineProps } from 'vue';

const props = defineProps({
    subtitle: String, // subtitle 속성 추가
    text: String,     // text 속성 추가
});
</script>

<style lang="scss" scoped>

</style>