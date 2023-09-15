<!-- VirtualKeyboard.vue -->
<template>
    <div id="virtual-keyboard">
        <button v-for="n in 9" :key="n" @click="appendNumber(n)">{{ n }}</button>
        <button @click="appendNumber(0)">0</button>
        <button @click="deleteLastCharacter">Delete</button>
    </div>
</template>
  
<script setup>
import { ref } from 'vue';

const password = ref('');
const emit = defineEmits(['update:modelValue']);

const appendNumber = (number) => {
    password.value += number;
    emit('update:modelValue', password.value);
};

const deleteLastCharacter = () => {
    password.value = password.value.slice(0, -1);
    emit('update:modelValue', password.value);
};
</script>
  
<style scoped>
#virtual-keyboard {
    display: grid;
    grid-template-columns: repeat(3, 1fr);
}
</style> 
  