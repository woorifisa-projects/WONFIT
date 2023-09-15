<template>
    <div>
        당신의 연봉은 얼마인가요?
        <v-text-field v-model="annualIncome" :rules="rules" style="margin: 10px" placeholder="연봉을 입력해주세요"></v-text-field>
    </div>
</template>

<script setup>
import { ref, watchEffect } from 'vue';

const annualIncome = ref(null);
const emit = defineEmits(['update']);

watchEffect(() => {
    emit('update', annualIncome.value);
});
</script>