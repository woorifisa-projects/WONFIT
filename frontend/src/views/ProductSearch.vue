<template>
  <v-card flat>
    <v-toolbar color="primary" dark extended flat> </v-toolbar>

    <v-card class="mx-auto" max-width="700" style="margin-top: -64px">
      <v-card
        class="pa-4"
        flat
        height="100px"
        img="https://cdn.vuetifyjs.com/images/toolbar/map.jpg"
      >
        <v-toolbar dense floating>
          <v-text-field hide-details single-line></v-text-field>
          <v-btn icon>
            <v-icon>mdi-magnify</v-icon>
          </v-btn>
        </v-toolbar>
      </v-card>
      <v-divider></v-divider>

      <v-card-text style="height: 500px"> test </v-card-text>
    </v-card>
  </v-card>
</template>

<script>
export default {};
</script>

<style></style>
