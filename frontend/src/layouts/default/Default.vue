<template>
  <v-app>
    <default-bar />

    <!-- <default-view class="mx-auto" flat width="1500px" /> -->
    <default-view />

    <default-footer />
  </v-app>
</template>

<script setup>
import DefaultBar from "./AppBar.vue";
import DefaultView from "./View.vue";
import DefaultFooter from "./Footer.vue";
</script>
