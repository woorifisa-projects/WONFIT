<template>
    <v-form>
        <v-container fluid>
            <v-row class="d-flex justify-center mt-10">
  
                <v-col cols="6" sm="6">
                    <v-text-field :append-icon="show2 ? 'mdi-eye' : 'mdi-eye-off'" :rules="[rules.required, rules.min]"
                        :type="show2 ? 'text' : 'password'" name="input-10-2" label="비밀번호를 입력하세요"
                        hint="At least 8 characters" class="input-group--focused"
                        @click:append="show2 = !show2"></v-text-field>

                        <v-chip class="logo-text mt-5" style="margin-left:180px">탈퇴하기</v-chip>
                </v-col>
             
               
            </v-row>
        </v-container>
    </v-form>
  </template>
  
  <script>
  export default {
    data() {
        return {
            show1: false,
            show2: true,
            password: 'Password',
            rules: {
                required: value => !!value || 'Required.',
                min: v => v.length >= 8 || 'Min 8 characters',
                emailMatch: () => (`The email and password you entered don't match`),
            },
        }
    },
  }
  </script>

<style scoped>
@font-face {
  font-family: "WooridaumB";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2205@1.0/WooridaumB.woff2")
    format("woff2");
  font-weight: 300;
  font-style: normal;
}

.logo-text {
  font-size: 15px;
  font-family: "WooridaumB", sans-serif;
}

</style>