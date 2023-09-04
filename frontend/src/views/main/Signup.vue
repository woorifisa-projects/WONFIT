<template>
    <v-card
      class="mx-auto"
      max-width="500"
      style="margin:50px"
      title="Member Registration"
    
    >
      <v-container>
     
        <v-text-field
          v-model="name"
          color="primary"
          label="Name"
          placeholder="Enter your name"
          variant="underlined"
        ></v-text-field>

        <v-text-field
          v-model="id"
          color="primary"
          label="ID"
          placeholder="Enter your id"
          variant="underlined"
        ></v-text-field>

        <v-text-field
          v-model="password"
          color="primary"
          label="Password"
          placeholder="Enter your password"
          variant="underlined"
        ></v-text-field>
  
  
        <v-text-field
          v-model="email"
          color="primary"
          label="Email"
          placeholder="Enter your email"
          variant="underlined"
        ></v-text-field>
  
        
        <v-checkbox
          v-model="terms"
          color="secondary"
          label="I agree to WooriWONFIT terms and conditions"
        ></v-checkbox>
      </v-container>
  
      <v-divider></v-divider>
  
      <v-card-actions>
        <v-spacer></v-spacer>
  
        <v-btn color="blue">
          Complete Registration
  
          <v-icon icon="mdi-chevron-right" end></v-icon>
        </v-btn>
      </v-card-actions>
    </v-card>
  </template>
  <script>
    export default {
      data: () => ({
        name: null,
        id: null,
        password: null,
        email: null,
        terms: false,
      }),
    }
  </script>