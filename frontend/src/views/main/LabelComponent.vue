<template>
    <div>
        <input type="checkbox" :id="label" :checked="modelValue" @change="$emit('update:checked', $event.target.checked)">
        <label :for="label">{{ label }}</label>
    </div>
</template>

<script setup>
import { defineProps } from 'vue'

const props = defineProps({
    label: String,
    checked: Boolean // v-model:checked의 값이 여기로 전달됩니다.
})
const emit = defineEmits(['update:checked']);


</script>

