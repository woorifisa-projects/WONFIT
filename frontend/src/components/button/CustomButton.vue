<template>
    <v-btn variant="tonal" class="mr-3 logo-text"
        style="margin-top : 40px; padding: 90px 15px; background-color:rgb(59, 126, 227); color:white; font-weight: bold"
       >
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