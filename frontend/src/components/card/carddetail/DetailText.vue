<template>
  <v-row>
    <v-col cols="3">
      <v-card-text style="font-size: medium; letter-spacing: 1px; line-height: 2">
        {{ dataName }}
      </v-card-text>
    </v-col>

    <v-col>
      <v-card-text style="font-size: medium; letter-spacing: 1px; line-height: 2">
        {{ dataContent }}
      </v-card-text>
    </v-col>
  </v-row>
</template>

<script setup>
defineProps({
  dataName: String,
  dataContent: String,
});
</script>

<style></style>
