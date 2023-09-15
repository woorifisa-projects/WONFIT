<template>
  <div>
    <v-app>
      <v-main>
        <v-container>
          <div class="d-flex align-center justify-center">
            <v-row class="mx-auto mt-n16 text-center">
              <v-col>
                <v-card
                  rounded="lg"
                  class="asset-info mx-auto mt-n16 mb-10"
                  max-width="700"
                  height="400"
                  ><v-card-title>마이데이터</v-card-title></v-card
                >
              </v-col>
              <!-- <v-col>
                <v-card class="mx-auto mt-n16" max-width="300" height="400"
                  ><v-card-title>소득수준</v-card-title></v-card
                >
              </v-col> -->
            </v-row>
          </div>
          <div class="mb-16 header">
            <p class="pt-10 d-flex justify-center" style="font-size: 32px">
              {{ memberName }} 고객님에게 딱 맞는 BEST 금융상품 4가지!
            </p>
          </div>
          <v-item-group>
            <div class="container">
              <div class="card-wrap" @click="handleCardClick('deposit')">
                <div class="glass" data-text="예금">
                  <svg-icon
                    v-if="cardText.deposit === ''"
                    class="custom-icon mt-n8"
                    type="mdi"
                    :path="deposit"
                    size="100"
                  ></svg-icon>
                  <p
                    v-else
                    class="card-text"
                    @click.stop="navigateToProductDetail(cardProductId.value.deposit)"
                  >
                    {{ cardText.deposit }}
                  </p>
                </div>
              </div>
              <div class="card-wrap" @click="handleCardClick('savings')">
                <div class="glass" data-text="적금">
                  <svg-icon
                    v-if="cardText.savings === ''"
                    class="custom-icon mt-n8"
                    type="mdi"
                    :path="savings"
                    size="100"
                  ></svg-icon>
                  <p v-else class="card-text">{{ cardText.savings }}</p>
                </div>
              </div>
              <div class="card-wrap" @click="handleCardClick('fund')">
                <div class="glass" data-text="펀드">
                  <svg-icon
                    v-if="cardText.fund === ''"
                    class="custom-icon mt-n8"
                    type="mdi"
                    :path="fund"
                    size="100"
                  ></svg-icon>
                  <p v-else class="card-text">{{ cardText.fund }}</p>
                </div>
              </div>
              <div class="card-wrap" @click="handleCardClick('loan')">
                <div class="glass" data-text="대출">
                  <svg-icon
                    v-if="cardText.loan === ''"
                    class="custom-icon mt-n8"
                    type="mdi"
                    :path="loan"
                    size="100"
                  ></svg-icon>
                  <p v-else class="card-text">{{ cardText.loan }}</p>
                </div>
              </div>
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
import { ref, onBeforeMount, onMounted } from "vue";
import { getApi } from "@/api/modules";
import VueCookies from "vue-cookies";
import { useRouter } from "vue-router";

const router = useRouter();
const memberName = ref("");

onBeforeMount(async () => {
  const data = await getApi({
    url: "/member/detail",
  });
  memberName.value = data.name;
});

const navigateToProductDetail = (type, productId) => {
  let routeName;
  switch (type) {
    case "deposit":
      routeName = "DepositDetailId";
      break;
    case "savings":
      routeName = "SavingsDetailId";
      break;
    case "fund":
      routeName = "FundDetailId";
      break;
    case "loan":
      routeName = "LoanDetailId";
      break;
  }
  router.push({ name: routeName, params: { id: productId } });
};

const deposit = ref(mdiPiggyBank);
const savings = ref(mdiAccountCash);
const fund = ref(mdiFinance);
const loan = ref(mdiCashMultiple);

const cardText = ref({
  deposit: "",
  savings: "",
  fund: "",
  loan: "",
});
const cardProductId = ref({
  deposit: null,
  savings: null,
  fund: null,
  loan: null,
});

const handleCardClick = async (type) => {
  console.log(type);
  if (cardText.value[type] === "") {
    const cookieValue = VueCookies.get(type);

    // console.log(cookieValue);
    if (["attack", "middle", "safe"].includes(cookieValue)) {
      // console.log("!@#");
      try {
        const obj = {
          url: `/product/${type}`,
        };
        const response = await getApi(obj);

        console.log(response);
        // 데이터가 유효한지 확인
        if (response && Array.isArray(response) && response.length) {
          // 수정된 부분
          // console.log("aaa");
          // 쿠키 밸류에 맞는 아이템이 있는지 확인
          let matchingItems = response.filter((item) => item[`${type}Type`] === cookieValue);
          // console.log("bbb");

          // 아이템들을 interest_rate에 따라 내림차순으로 정렬
          matchingItems.sort((a, b) => b.interest_rate - a.interest_rate);

          // 정렬된 리스트의 첫 번째 아이템(가장 이자율이 높은)의 이름을 카드의 텍스트에 넣어줌
          if (matchingItems.length > 0) {
            // console.log("ddd");
            cardText.value[type] = matchingItems[0][`${type}Name`];
            cardProductId.value[type] = matchingItems[0].id;
            console.log(cardProductId.value[type]);
            console.log(cardProductId.value.deposit);
            return;
          }
        }
      } catch (error) {
        console.error(error);
      }
    } else {
      cardText.value[type] = "검사를 진행해 주세요";
    }
  } else {
    if (cardText.value[type] !== "" && cardText.value[type] !== "검사를 진행해 주세요") {
      navigateToProductDetail(type, cardProductId.value[type]);
    } else if (type === "deposit") {
      router.push({ name: "DepositTest" });
    } else if (type === "savings") {
      router.push({ name: "SavingsTest" });
    } else if (type === "fund") {
      router.push({ name: "FundTest" });
    } else if (type === "loan") {
      router.push({ name: "LoanTest" });
    }
  }
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
  margin-top: 10px;
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

.card-wrap {
  margin-right: 60px;
}

.card-wrap:hover {
  transform: scale(1.05);
  transition: transform 0.5s;
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
  background: linear-gradient(rgba(255, 255, 255, 0.199), transparent);
  border: 1px solid rgba(255, 255, 255, 0.1);
  box-shadow: 30px 40px 30px rgba(0, 0, 0, 0.25);
  backdrop-filter: blur(10px);
  display: flex;
  justify-content: center;
  align-items: center;
  transition: 0.5s;
  border-radius: 10px;
  cursor: pointer;
}

.container .glass::before {
  content: attr(data-text);
  font-size: 23px;
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
.glass p {
  position: absolute;
  margin-right: 10px;
  margin-left: 10px;
  margin-top: -15px;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #fff;
  font-size: 23px;
}

.custom-icon {
  color: #fff;
}

.card-text {
  font-size: 20px;
  color: #fff;
  font-weight: bold;
  margin-top: 10px;
}
</style>
