<template>
       <v-btn
        variant="tonal"
        class="mr-3 logo-text"
        style="margin-top : 40px; padding: 90px 15px; background-color:rgb(59, 126, 227); color:white; font-weight: bold"
        @click="navigateToFundTestPage"
        >
            {{ content }}
        </v-btn>
</template>

<script setup>
// props를 정의하겠다
defineProps({
    content: { // props 중에는 content라는 이름의 props 하나를 정의
        Type: String,
        default:'',
    },
    // props는 여러 개가 될 수 있음
})
</script>

<style lang="scss" scoped>

</style>