<template>
  <div>
    <v-app>
      <v-main>
        <v-container>
          <div class="d-flex align-center justify-center">
            <v-row class="mx-auto mt-n16 text-center">
              <v-col>
                <v-card rounded="lg" class="asset-info mx-auto mt-n16 mb-10" max-width="700"
                  height="400"><v-card-title>마이데이터</v-card-title></v-card>
              </v-col>
              <!-- <v-col>
                <v-card class="mx-auto mt-n16" max-width="300" height="400"
                  ><v-card-title>소득수준</v-card-title></v-card
                >
              </v-col> -->
            </v-row>
          </div>
          <div class="mb-16 header">
            <p class="pt-10 d-flex justify-center" style="font-size: 27px">
              {{ memberName }} 고객님에게 딱 맞는 BEST 금융상품 4가지!
            </p>
          </div>
          <v-item-group>
            <div class="container">
              <v-item>
                <div class="glass" style="--r: -15" data-text="예금">
                  <svg-icon class="custom-icon mt-n8" type="mdi" :path="deposit" size="100"></svg-icon>
                </div>
              </v-item>
              <v-item>
                <div class="glass" style="--r: 5" data-text="적금">
                  <svg-icon class="custom-icon mt-n8" type="mdi" :path="savings" size="100"></svg-icon>
                </div>
              </v-item>
              <v-item>
                <div class="glass" style="--r: 25" data-text="펀드">
                  <svg-icon class="custom-icon mt-n8" type="mdi" :path="fund" size="100"></svg-icon>
                </div>
              </v-item>
              <v-item>
                <div class="glass" style="--r: 15" data-text="대출">
                  <svg-icon class="custom-icon mt-n8" type="mdi" :path="loan" size="100"></svg-icon>
                </div>
              </v-item>
            </div>
          </v-item-group>
        </v-container>
      </v-main>
    </v-app>
  </div>
</template>

<script setup>
import SvgIcon from "@jamescoyle/vue-icon";
import { mdiPiggyBank, mdiCashMultiple, mdiFinance, mdiAccountCash } from "@mdi/js";
import { ref, onBeforeMount } from "vue";
import { getApi } from "@/api/modules";

const deposit = ref(mdiPiggyBank);
const savings = ref(mdiAccountCash);
const fund = ref(mdiFinance);
const loan = ref(mdiCashMultiple);

const memberName = ref("");

// 상품 정보 가져오기
onBeforeMount(async () => {
  const data = await getApi({
    url: "/product/deposit",
  });
  depositData.value = data;
  displayedData.value = data;
});
</script>

<script>
import VueCookies from "vue-cookies";
import axios from "axios";

export default {
  methods: {
    async checkDepositCookie() {
      const depositValue = this.$cookies.get("deposit");

      if (["attack", "middle", "safe"].includes(depositValue)) {
        try {
          const response = await axios.get(`http://back.wonfit.site/product/deposit`);

          // 데이터가 어레이에 존재 하는지 확인
          if (Array.isArray(response.data) && response.data.length) {
            // 쿠키 밸류에 맞는 아이템이 있는지 확인
            let matchingItems = response.data.filter((item) => item.depositType === depositValue);

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
      const savingsValue = this.$cookies.get("savings");

      if (["attack", "middle", "safe"].includes(savingsValue)) {
        try {
          const response = await axios.get(`http://back.wonfit.site/product/savings`);

          // 데이터가 어레이에 존재 하는지 확인
          if (Array.isArray(response.data) && response.data.length) {
            // 쿠키 밸류에 맞는 아이템이 있는지 확인
            const matchingItems = response.data.filter((item) => item.savingsType === savingsValue);

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
      const fundValue = this.$cookies.get("fund");

      if (["attack", "middle", "safe"].includes(fundValue)) {
        try {
          const response = await axios.get(`http://back.wonfit.site/product/fund`);

          // 데이터가 어레이에 존재 하는지 확인
          if (Array.isArray(response.data) && response.data.length) {
            // 쿠키 밸류에 맞는 아이템이 있는지 확인
            const matchingItems = response.data.filter((item) => item.fundType === fundValue);

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
      const loanValue = this.$cookies.get("loan");

      if (["attack", "middle", "safe"].includes(loanValue)) {
        try {
          const response = await axios.get(`http://api.back.wonfit.site/product/loan`);

          // 데이터가 어레이에 존재 하는지 확인
          if (Array.isArray(response.data) && response.data.length) {
            // 쿠키 밸류에 맞는 아이템이 있는지 확인
            const matchingItems = response.data.filter((item) => item.loanType === loanValue);

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

<style lang="scss" scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

.header {
  text-align: center;
  /* 텍스트 중앙 정렬 */
  margin-top: 20px;
  /* 텍스트 상단 여백 조절 */
  color: #fff;
  /* 텍스트 색상 설정 */
}

.v-main {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 130vh;
  background-color: #285eb1;
}

.asset-info {
  border: 1px solid #b4cdf2;
  box-shadow: 5px 5px 20px 0px rgba(0, 0, 0, 0.3);
}

.v-card {
  background-color: #d1e4ffd3;
  color: #030303;
  margin: 0;
}

.container {
  display: flex;
  justify-content: center;
  align-items: center;
}

.container .glass {
  position: relative;
  width: 250px;
  height: 280px;
  background: linear-gradient(#fff2, transparent);
  border: 1px solid rgba(255, 255, 255, 0.1);
  box-shadow: 30px 50px 30px rgba(0, 0, 0, 0.25);
  backdrop-filter: blur(10px);
  display: flex;
  justify-content: center;
  align-items: center;
  transition: 0.5s;
  border-radius: 10px;
  margin: 0 -45px;
  transform: rotate(calc(var(--r) * 1deg));
}

.container:hover .glass {
  transform: rotate(0deg);
  margin: 0 20px;
  cursor: pointer;
}

.container .glass::before {
  content: attr(data-text);
  font-size: 21px;
  position: absolute;
  bottom: 0;
  width: 100%;
  height: 40px;
  background: rgba(255, 255, 255, 0.05);
  display: flex;
  justify-content: center;
  align-items: center;
  color: #fff;
}

.custom-icon {
  color: #fff;
}
</style>
