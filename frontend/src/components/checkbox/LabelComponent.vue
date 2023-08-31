<template>
<v-checkbox
          class="checkbox logo-text"
          :label="label"
          hide-details="false"
        ></v-checkbox>
</template>


<script setup>
import { defineProps } from 'vue';  

const props = defineProps({
  label: String,  
});
</script>