<template>
  <div class="mt-5">
    <!-- 선택한 상품정보 CARD -->
    <div>
      <v-card class="mx-auto mt-12" max-width="900" elevation="3">
        <v-card-title style="background-color: #e2eeff"> 선택한 상품정보 </v-card-title>
        <v-divider></v-divider>

        <v-card-item>
          <v-row>
            <v-col cols="3" class="mx-2">
              <v-card-text style="font-size: large; letter-spacing: 1px; line-height: 2">
                상품명
              </v-card-text>
            </v-col>

            <v-col>
              <v-card-text
                class="px-0"
                style="font-size: large; letter-spacing: 1px; line-height: 2"
                >{{ fundData.fundName }}
              </v-card-text>
            </v-col>
          </v-row>

          <v-row>
            <v-col cols="3" class="mt-n10 mx-2">
              <v-card-text style="font-size: large; letter-spacing: 1px; line-height: 2">
                1개월 수익률
              </v-card-text>
            </v-col>

            <v-col class="mt-n10 px-0">
              <v-card-text style="font-size: large; letter-spacing: 1px; line-height: 2">
                {{ fundData.returnRate1 }}%
              </v-card-text>
            </v-col>
          </v-row>

          <v-row>
            <v-col cols="3" class="mt-n10 mx-2">
              <v-card-text style="font-size: large; letter-spacing: 1px; line-height: 2">
                6개월 수익률
              </v-card-text>
            </v-col>

            <v-col class="mt-n10 px-0">
              <v-card-text style="font-size: large; letter-spacing: 1px; line-height: 2">
                {{ fundData.returnRate2 }}%
              </v-card-text>
            </v-col>
          </v-row>

          <v-row>
            <v-col cols="3" class="mt-n10 mx-2">
              <v-card-text style="font-size: large; letter-spacing: 1px; line-height: 2">
                기준가
              </v-card-text>
            </v-col>

            <v-col class="mt-n10 px-0">
              <v-card-text style="font-size: large; letter-spacing: 1px; line-height: 2">
                {{ fundData.fundPrice }}원
              </v-card-text>
            </v-col>
          </v-row>
        </v-card-item>
      </v-card>
    </div>

    <!-- 가입약관 CARD -->
    <div>
      <v-card class="mx-auto mt-16 mb-10" max-width="900" elevation="3">
        <v-card-title style="background-color: #e2eeff"> 가입약관 </v-card-title>
        <v-divider></v-divider>

        <v-card-item class="card-scroll" style="color: #4c4b4b">
          <div class="ma-10 mt-16 pt-16">
            <br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
            <h3>펀드 상품 가입 약관</h3>
            <br />
            <h3>제 1 조 (목적)</h3>
            <p>
              본 약관은 펀드 상품에 관한 이용 조건 및 기타 필요한 사항을 규정함을 목적으로 합니다.
            </p>
            <br />
            <h3>제 2 조 (용어의 정의)</h3>
            <p>
              1. "은행"이라 함은 가입자에게 펀드 상품을 제공하는 은행을 의미합니다.<br />
              2. "가입자"라 함은 펀드 상품을 가입한 개인 또는 법인을 의미합니다.<br />
              3. "펀드 상품"이라 함은 은행이 제공하는 펀드 관련 상품을 의미합니다.
            </p>
            <br />
            <h3>제 3 조 (펀드 상품 가입)</h3>
            <p>
              가입자는 은행에서 제공하는 펀드 상품을 가입할 수 있으며, 가입 시 해당 펀드 상품의 약관
              및 조건을 따라야 합니다.
            </p>
            <br />
            <h3>제 4 조 (펀드 상품 이용)</h3>
            <p>
              가입자는 펀드 상품을 은행이 정한 조건과 방법에 따라 이용해야 하며, 이용 시 발생하는
              수수료 및 이자율 등에 대한 정보를 확인해야 합니다.
            </p>
            <br />

            <h3>제 5 조 (약관의 변경)</h3>
            <p>
              은행은 필요한 경우 본 약관을 변경할 수 있으며, 변경된 약관은 가입자에게 통지한 후
              적용됩니다.
            </p>
            <br />
            <p>
              본 예제는 단순한 예시이며, 실제 은행의 가입 약관은 더 복잡하고 법적인 규정을 따르게
              됩니다.
            </p>
          </div>
        </v-card-item>
      </v-card>
      <v-checkbox
        class="d-flex justify-center mt-n7"
        v-model="selected1"
        style="color: black"
        value="상품 확인"
        label="본인은 약관 및 상품설명서를 제공받고 내용을 충분히 이해하고 동의하며 본 상품에 가입함을 확인합니다."
      />
      <v-checkbox
        class="d-flex justify-center mt-n4"
        v-model="selected2"
        style="color: black"
        value="해지 확인"
        label="본인은 인터넷뱅킹으로 예·펀드을 해지할 경우 고객상담센터 또는 휴대폰 본인인증을 통해 해지가능함을 확인합니다."
      />
    </div>

    <!-- 정보입력 CARD -->
    <div>
      <v-card class="mx-auto my-10" max-width="900" elevation="3">
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
                  v-model="selectedAccountNumber"
                  clearable
                  placeholder="출금 계좌번호를 선택해주세요."
                  single-line
                  :items="bankAccountNumber"
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
                  :rules="[rules.minLength, rules.onlyNumbers, rules.isCorrectPassword]"
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
                <span>매수 수량</span>
              </v-col>
              <v-col cols="8">
                <v-text-field
                  v-model="fundQuantity"
                  class="mx-5"
                  placeholder="매수하고자하는 개수를 입력해주세요."
                  :rules="[rules.minQuantity]"
                  hint="1개 이상 입력해주세요."
                  style="width: 300px; margin-left: 22px"
                  variant="outlined"
                >
                </v-text-field>
              </v-col>
            </v-row>

            <div class="mt-9 mb-10">
              <span>투자 성향</span>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              {{ investmentType }}
            </div>
          </div>
        </v-card-item>
      </v-card>
    </div>

    <div class="d-flex justify-center my-10">
      <v-btn
        class="mx-3"
        color="primary"
        size="large"
        rounded
        @click="requestSubscribe"
        :disabled="!isAllChecked"
      >
        가입하기
      </v-btn>
      <v-btn class="mx-3" size="large" rounded @click="goBack"> 취소하기 </v-btn>
    </div>
  </div>
</template>

<script setup>
import { ref, onBeforeMount, computed } from "vue";
import { getApi, postApi } from "@/api/modules";
import { useRoute } from "vue-router";

const fundData = ref([]);
const accountData = ref([]);
const route = useRoute();
// URL에서 productId를 가져오기 위해 route.params를 사용합니다.
const productId = route.params.id;
// 약관 동의 체크박스
const selectedAccountNumber = ref(null);
const selected1 = ref(false);
const selected2 = ref(false);
// 가입 체크
const isAllChecked = computed(() => {
  return (
    selected1.value &&
    selected2.value &&
    selectedAccountNumber.value &&
    password.value === bankAccountPassword.value[0] &&
    password.value &&
    fundQuantity.value
  );
});
// 출금계좌번호
let bankAccountNumber = ref([]);
let bankAccountPassword = ref([]);

const show1 = ref(false);
const password = ref("");
const fundQuantity = ref();

const rules = {
  minLength: (v) => v.length <= 4,
  minQuantity: (v) => v >= 1,
  onlyNumbers: (v) => v == "" || /^\d+$/.test(v) || "숫자만 입력해 주세요.",
  isCorrectPassword: (v) =>
    v == "" || v === bankAccountPassword.value[0] || "비밀번호가 일치하지 않습니다.",
};

// 이전 페이지로 이동하는 코드
const goBack = () => {
  history.back();
};

// 상품 타입에 따라 투자성향을 다르게 표시
const investmentType = computed(() => {
  if (fundData.value.fundType === "safe") {
    return "안정형";
  } else if (fundData.value.fundType === "middle") {
    return "중립형";
  } else if (fundData.value.fundType === "attack") {
    return "공격형";
  }
});

// 상품 정보 가져오기
onBeforeMount(async () => {
  const data = await getApi({
    url: `/product/fund/${productId}`,
  });
  fundData.value = data;
  console.log(data);
});

// 계좌 정보 가져오기
onBeforeMount(async () => {
  const data = await getApi({
    url: `/member/detail`,
  });
  accountData.value = data;
  console.log(data);
  bankAccountNumber.value = [accountData.value.bankAccountNumber];
  bankAccountPassword.value = [accountData.value.bankAccountPassword];
});

// 상품 가입 post 요청
const requestSubscribe = async () => {
  try {
    const response = await postApi({
      url: `/member/mypage/sublog/fund/${productId}`,
      data: {
        fundQuantity: fundQuantity.value,
      },
    });
    console.log(response);
    if (response === "가입완료") {
      console.log("상품 가입 성공");
    } else {
      console.error("상품 가입 실패 error:", response.data); // 실패 시 에러 메시지를 출력
    }
  } catch (error) {
    console.error("상품 가입 실패:", error);
  }
};
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
