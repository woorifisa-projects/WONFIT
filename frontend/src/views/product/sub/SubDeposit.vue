<template>
  <div class="mt-5">
    <v-card
      class="selected-name mx-auto my-11 d-flex align-center"
      max-width="900"
      height="80"
      elevation="3"
    >
      <span class="mx-4">선택한 상품명</span>
      <span class="mx-10"> {{ depositData.depositName }}</span>
    </v-card>

    <!-- 가입약관 CARD -->
    <div>
      <v-card class="mx-auto mt-16 mb-10" max-width="900" elevation="4">
        <v-card-title style="background-color: #e2eeff"> 가입약관 </v-card-title>
        <v-divider></v-divider>

        <v-card-item class="card-scroll"> 약관 내용 </v-card-item>
      </v-card>
      <v-checkbox
        class="d-flex justify-center mt-n7"
        v-model="selected"
        value="상품 확인"
        label="본인은 약관 및 상품설명서를 제공받고 내용을 충분히 이해하고 동의하며 본 상품에 가입함을 확인합니다."
      />
      <v-checkbox
        class="d-flex justify-center mt-n4"
        v-model="selected"
        value="해지 확인"
        label="본은은 인터넷뱅킹으로 예·적금을 해지할 경우 고객상담센터 또는 휴대폰 본인인증을 통해 해지가능함을 확인합니다."
      />
    </div>

    <!-- 정보입력 CARD -->
    <div>
      <v-card class="mx-auto my-10" max-width="900" elevation="4">
        <v-card-title style="background-color: #e2eeff"> 정보입력 </v-card-title>
        <v-divider></v-divider>

        <v-card-item>
          <div class="ma-5">
            <v-row>
              <v-col cols="2" class="pt-7">
                <span>출금계좌번호</span>
              </v-col>
              <v-col cols="8">
                <v-select
                  clearable
                  placeholder="출금 계좌번호를 선택해주세요."
                  single-line
                  :items="accountNumbers"
                  variant="outlined"
                  style="width: 500px; margin-left: 22px"
                ></v-select>
              </v-col>
            </v-row>

            <v-row>
              <v-col cols="2" class="pt-7">
                <span>계좌비밀번호</span>
              </v-col>
              <v-col cols="8">
                <v-text-field
                  v-model="password"
                  :rules="[rules.minLength]"
                  :type="show1 ? 'text' : 'password'"
                  placeholder="계좌 비밀번호를 입력해주세요."
                  hint="4글자를 입력해주세요."
                  maxLength="4"
                  variant="outlined"
                  style="width: 300px; margin-left: 22px"
                ></v-text-field>
              </v-col>
            </v-row>

            <v-row>
              <v-col cols="2" class="pt-7">
                <span>신규 금액</span>
              </v-col>
              <v-col cols="8">
                <v-text-field
                  placeholder="입금하고자하는 금액을 입력해주세요."
                  :rules="[rules.minDeposit]"
                  :hint="getHint()"
                  style="width: 300px; margin-left: 22px"
                  variant="outlined"
                >
                </v-text-field>
              </v-col>
              <v-col> </v-col>
            </v-row>

            <v-row>
              <v-col cols="2" class="pt-5">
                <span>가입 기간</span>
              </v-col>
              <v-col>
                <v-radio-group inline>
                  <v-radio label="3개월" value="3" style="color: black"></v-radio>
                  <v-radio label="6개월" value="6" style="color: black"></v-radio>
                  <v-radio label="12개월" value="12" style="color: black"></v-radio>
                </v-radio-group>
              </v-col>
            </v-row>

            <v-row>
              <v-col cols="2" class="pt-5">
                <span>세금우대선택</span>
              </v-col>
              <v-col>
                <v-radio-group>
                  <v-radio label="일반세율" value="1" style="color: black"></v-radio>
                  <v-radio
                    label="세금우대(1년 이상 가입 시 가능)"
                    value="2"
                    style="color: black"
                  ></v-radio>
                  <v-radio label="비과세(생계형)" value="3" style="color: black"></v-radio>
                </v-radio-group>
              </v-col>
            </v-row>

            <div class="mt-5 mb-11">
              <span>이자지급방법</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;
              &nbsp; 만기일시지급식
            </div>

            <div class="mb-10">
              <span>만기시해지방법</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              고객직접해지
            </div>
          </div>
        </v-card-item>
      </v-card>
    </div>

    <div class="d-flex justify-center my-10">
      <v-btn class="mx-3" color="primary" size="large" rounded> 가입하기 </v-btn>
      <v-btn class="mx-3" size="large" rounded @click="goBack"> 취소하기 </v-btn>
    </div>
  </div>
</template>

<script setup>
import { ref, onBeforeMount } from "vue";
import { getApi } from "@/api/modules";
import { useRoute } from "vue-router";

const depositData = ref([]);
const $route = useRoute();
// URL에서 productId를 가져오기 위해 $route.params를 사용합니다.
const productType = $route.params.productType;
const productId = $route.params.id;
// 약관 동의 체크박스
const selected = ref([]);
// 출금계좌번호
let accountNumbers = ref([]);
// 최소 입금 금액
let minDeposit = ref(0);

const show1 = ref(false);
const password = ref("");

const rules = {
  minLength: (v) => v.length <= 4,
  minDeposit: (v) => v >= minDeposit.value,
};

const getHint = () => {
  if (!value || value < minDeposit.value) {
    return `최소 입금 금액은 ${minDeposit.value}원 입니다.`;
  }
  return `최소 입금 금액은 ${minDeposit.value}원 입니다.`;
};
const value = ref(""); // v-model로 입력값을 받아올 변수

// 이전 페이지로 이동하는 코드
const goBack = () => {
  history.back();
};

// 상품 정보 가져오기
onBeforeMount(async () => {
  const data = await getApi({
    url: `/product/${productType}/${productId}`,
  });
  depositData.value = data;
  console.log(data);
  accountNumbers.value = [depositData.value.depositName];
  minDeposit.value = depositData.value.minDeposit;
});
</script>

<style scoped>
.card-scroll {
  height: 270px;
  overflow-y: scroll;
}

.selected-name {
  font-size: 22px;
}

span {
  font-size: 19px;
}

.v-radio-group {
  margin-left: 13px;
}
</style>
