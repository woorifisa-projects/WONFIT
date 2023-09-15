<template>
    <div>
        연령대를 선택해주세요
        <v-radio-group group v-model="ageGroup" inline style="margin: 10px">
            <v-radio label="20대 이하" value="20"></v-radio>
            <v-radio label="30대" value="30"></v-radio>
            <v-radio label="40대" value="40"></v-radio>
            <v-radio label="50대" value="50"></v-radio>
            <v-radio label="60대 이상" value="60"></v-radio>
        </v-radio-group>
    </div>
</template>

<script setup>
import { ref, watchEffect } from 'vue';

const ageGroup = ref(null);
const emit = defineEmits(['update:group']);

watchEffect(() => {
    emit('update:group', ageGroup.value);
});
</script>