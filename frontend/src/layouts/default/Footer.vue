<template>
  <v-footer>
    <v-row justify="center" no-gutters>
      <v-btn
        v-for="link in links"
        :key="link"
        color="black"
        variant="text"
        class="mx-2"
        rounded="xl"
      >
        {{ link }}
      </v-btn>
      <v-col class="text-center mt-2" cols="12">
        {{ new Date().getFullYear() }} — <strong>WONFIT</strong>
      </v-col>
    </v-row>
  </v-footer>
</template>
<script>
export default {
  data: () => ({
    links: ["Home", "About Us", "Team", "github", "Contact Us"],
  }),
};
</script>
<style lang="scss" scoped>
.v-footer {
  background-color: #fff;
  padding: 10px; /* 내부 여백 추가 */
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin: 2px 0;
}
</style>
