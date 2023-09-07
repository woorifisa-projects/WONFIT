<template>
  <div class="logo-text d-flex justify-center align-center" style="margin: 40px; font-size: 1.8em">
    조윤나 고객님에게 딱 맞는 BEST 금융상품 4가지!
  </div>
  <v-item-group selected-class="bg-primary" style="margin:70px">
    <v-container class="d-flex justify-center align-center min-vh-100">
      <v-row>
        <v-col>
          <v-item v-slot="{ isSelected, selectedClass, toggle }">
            <v-card :class="['logo-text d-flex align-center', selectedClass]" dark height="300"
              @click="toggle(), checkDepositCookie()">
              <div class="text-h3 flex-grow-1 text-center">
                {{ depositText }}
              </div>
            </v-card>
          </v-item>
        </v-col>
        <v-col>
          <v-item v-slot="{ isSelected, selectedClass, toggle }">
            <v-card :class="['logo-text d-flex align-center', selectedClass]" dark height="300"
              @click="toggle(), checkSavingsCookie()">
              <div class="text-h3 flex-grow-1 text-center">
                {{ savingsText }}
              </div>
            </v-card>
          </v-item>
        </v-col>
        <v-col>
          <v-item v-slot="{ isSelected, selectedClass, toggle }">
            <v-card :class="['logo-text d-flex align-center', selectedClass]" dark height="300"
              @click="toggle(), checkFundCookie()">
              <div class="text-h3 flex-grow-1 text-center">
                {{ fundText }}
              </div>
            </v-card>
          </v-item>
        </v-col>
        <v-col>
          <v-item v-slot="{ isSelected, selectedClass, toggle }">
            <v-card :class="['logo-text d-flex align-center', selectedClass]" dark height="300"
              @click="toggle(), checkLoanCookie()">
              <div class="text-h3 flex-grow-1 text-center">
                {{ loanText }}
              </div>
            </v-card>
          </v-item>
        </v-col>
      </v-row>
    </v-container>
  </v-item-group>
</template>
<script>
import VueCookies from 'vue-cookies';
import axios from 'axios';

export default {
  data() {
    return {
      depositText: "우리WON예금",
      savingsText: "우리WON적금",
      fundText: "우리WON펀드",
      loanText: "우리WON대출",
    };
  },

  methods: {
    async checkDepositCookie() {
      const depositValue = this.$cookies.get('deposit');

      if (['attack', 'middle', 'safe'].includes(depositValue)) {
        try {
          const response = await axios.get(`http://localhost:8080/product/deposit`);

          // 데이터가 어레이에 존재 하는지 확인
          if (Array.isArray(response.data) && response.data.length) {
            // 쿠키 밸류에 맞는 아이템이 있는지 확인
            let matchingItems = response.data.filter(item => item.depositType === depositValue);

            // 아이템들을 interest_rate에 따라 내림차순으로 정렬
            matchingItems.sort((a, b) => b.interest_rate - a.interest_rate);

            // 정렬된 리스트의 첫 번째 아이템(가장 이자율이 높은)의 이름을 카드의 텍스트에 넣어줌
            if (matchingItems.length > 0) {
              this.depositText = matchingItems[0].depositName;
            }
          }
        } catch (error) {
          console.error(error);
        }

      } else {
        this.depositText = "검사를 진행 해주세요";
      }
    },

    async checkSavingsCookie() {
      const savingsValue = this.$cookies.get('savings');

      if (['attack', 'middle', 'safe'].includes(savingsValue)) {
        try {
          const response = await axios.get(`http://localhost:8080/product/savings`);

          // 데이터가 어레이에 존재 하는지 확인
          if (Array.isArray(response.data) && response.data.length) {
            // 쿠키 밸류에 맞는 아이템이 있는지 확인
            const matchingItems = response.data.filter(item => item.savingsType === savingsValue);

            // 아이템들을 interest_rate에 따라 내림차순으로 정렬
            matchingItems.sort((a, b) => b.interest_rate - a.interest_rate);

            // 정렬된 리스트의 첫 번째 아이템(가장 이자율이 높은)의 이름을 카드의 텍스트에 넣어줌
            if (matchingItems.length > 0) {
              this.savingsText = matchingItems[0].savingsName;
            }
          }
        } catch (error) {
          console.error(error);
        }

      } else {
        this.savingsText = "검사를 진행 해주세요";
        this.$router.push({ name: "SavingsTest" });

      }
    },
    async checkFundCookie() {
      const fundValue = this.$cookies.get('fund');

      if (['attack', 'middle', 'safe'].includes(fundValue)) {
        try {
          const response = await axios.get(`http://localhost:8080/product/fund`);

          // 데이터가 어레이에 존재 하는지 확인
          if (Array.isArray(response.data) && response.data.length) {
            // 쿠키 밸류에 맞는 아이템이 있는지 확인
            const matchingItems = response.data.filter(item => item.fundType === fundValue);

            // 아이템들을 return_rate1에 따라 내림차순으로 정렬
            matchingItems.sort((a, b) => b.return_rate1 - a.return_rate1);

            // 정렬된 리스트의 첫 번째 아이템(가장 이자율이 높은)의 이름을 카드의 텍스트에 넣어줌
            if (matchingItems.length > 0) {
              this.fundText = matchingItems[0].fundName;
            }
          }
        } catch (error) {
          console.error(error);
        }

      } else {
        this.fundText = "검사를 진행 해주세요";
      }
    },
    async checkLoanCookie() {
      const loanValue = this.$cookies.get('loan');

      if (['attack', 'middle', 'safe'].includes(loanValue)) {
        try {
          const response = await axios.get(`http://localhost:8080/product/loan`);

          // 데이터가 어레이에 존재 하는지 확인
          if (Array.isArray(response.data) && response.data.length) {
            // 쿠키 밸류에 맞는 아이템이 있는지 확인
            const matchingItems = response.data.filter(item => item.loanType === loanValue);

            // 아이템들을 interest_rate에 따라 내림차순으로 정렬
            matchingItems.sort((a, b) => b.interest_rate - a.interest_rate);

            // 정렬된 리스트의 첫 번째 아이템(가장 이자율이 높은)의 이름을 카드의 텍스트에 넣어줌
            if (matchingItems.length > 0) {
              this.loanText = matchingItems[0].loanName;
            }
          }
        } catch (error) {
          console.error(error);
        }

      } else {
        this.loanText = "검사를 진행 해주세요";
      }
    },

  },
};
</script>

<style scoped>
@font-face {
  font-family: "WooridaumB";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2205@1.0/WooridaumB.woff2") format("woff2");
  font-weight: 300;
  font-style: normal;
}

.logo-text {
  font-size: 15px;
  font-family: "WooridaumB", sans-serif;
}

.v-card {
  transition: all 0.5s ease-in-out;
}
</style>
