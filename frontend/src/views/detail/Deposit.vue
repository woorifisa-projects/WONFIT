<template>
  <div>
    <p>deposit detil page</p>
  </div>
</template>

<script setup>
defineProps({
  depositName: String,
  depositInfo: String,
  interestRate: Number,
  target: String,
  period: Number,
  minDeposit: Number,
  depositType: String,
});
</script>

<style></style>
