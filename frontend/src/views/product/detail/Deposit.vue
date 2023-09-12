<template>
  <v-container class="mt-12">
    <div>
      <div>
        <suspense>
          <detail-title
            :name="depositData.depositName"
            :info="depositData.depositInfo"
            :interestRate="'기본 금리: ' + depositData.interestRate + '%'"
            :target="'가입 대상: ' + depositData.target"
            :period="'가입 기간: ' + depositData.period + '개월'"
            :minDeposit="'가입 금액: ' + depositData.minDeposit + '원'"
            :type="'상품 타입: ' + depositData.depositType"
            :button1="'가입하기'"
            :button2="'전화가입'"
            :url="'deposit'"
          />
        </suspense>
      </div>

      <div class="mb-10">
        <v-sheet elevation="4" max-width="900" rounded="lg" width="100%" class="pa-6 mt-10 mx-auto">
          <h2 class="logo-text text-h6 mb-5">상품 설명</h2>

          <v-divider class="mb-4"></v-divider>

          <detail-text dataName="개요" :dataContent="depositData.depositInfo" />
          <detail-text
            dataName="예금자 보호"
            dataContent='이 예금은 예금자보호법에 따라 예금보험공사가 보호하되, 보호 한도는 본 은행에 있는 귀하의
모든 예금보호 대상 금융상품의 원금과 소정의 이자를 합하여 1인당 "최고 5천만원"이며, 5천만원을
초과하는 나머지 금액은 보호하지 않습니다.'
          />
          <detail-text dataName="가입 대상" :dataContent="depositData.target" />
          <detail-text dataName="적립 금액" :dataContent="depositData.minDeposit + '원'" />
          <detail-text dataName="가입 기간" :dataContent="depositData.period + '개월'" />
          <detail-text dataName="기본 금리" :dataContent="depositData.interestRate + '%'" />
          <detail-text
            dataName="우대 금리"
            dataContent="
최대 연 0.2%p
① WON통장/우리꿈통장에서 출금하여 가입하는 경우 - 연 0.1%p
② 우리 오픈뱅킹 서비스에 타행계좌가 등록되어 있는 경우- 연 0.1%p

   ※ 세부 우대조건은 아래 상품 약관 및 상품설명서를 확인해 주세요"
          />
          <detail-text
            dataName="만기 후 이율"
            dataContent="만기일 당시 영업점 및 인터넷 홈페이지에 고시한 일반정기적금 만기후이율을 적용"
          />
          <detail-text
            dataName="중도해지 이율"
            dataContent="신규일 당시 영업점 및 인터넷 홈페이지에 고시한 중도해지이율을 적용"
          />
          <detail-text dataName="세제혜택" dataContent="비과세종합저축 가입가능 (본인한도 내)" />
          <detail-text dataName="이자지급방법" dataContent="만기일시지급식" />
          <detail-text
            dataName="추가내용"
            dataContent='
※ 우리WON뱅킹 설치 및 상품 가입하는 방법

1. "Play 스토어" 또는 "App Store"에서 "우리WON뱅킹"을 검색 후 설치

2. 기존 우리은행 원터치개인뱅킹을 이용하신 고객님은 별도 회원가입 없이 이용 가능

3. 로그인 후 화면 하단 "추전상품" 클릭 후 예금상품에서 "WON플러스 예금" 가입

· 유의사항

계좌에 압류, 가압류 등이 등록될 경우 원금 및 이자의 지급이 제한될 수 있습니다.

일반금융소비자는 금융소비자보호법 제19조 제1항에 따라 은행으로부터 충분한 설명을 받을 권리가 있으며, 본 금융상품에 관한 계약을 체결하기 전에 상품설명서 및 약관을 읽어보시기 바랍니다.

※ 상품에서 제공하는 우대사항(수수료 면제, 환율 우대, 부가서비스 등) 제공조건은 상품설명서를 꼭 참고해 주시고, 문의사항은 가까운 우리은행 영업점 또는 고객센터(1588-5000, 1599-5000)으로 문의하시기 바랍니다.'
          />
        </v-sheet>
      </div>
    </div>
  </v-container>
</template>

<script setup>
import { ref, onBeforeMount, defineAsyncComponent } from "vue";
import { getApi } from "@/api/modules";
import { useRoute } from "vue-router";
import DetailText from "@/components/card/carddetail/DetailText.vue";

const depositData = ref([]);
const route = useRoute();
// URL에서 productId를 가져오기 위해 route.params를 사용합니다.
const productId = route.params.id;

let detailTitle;

// 상품 정보 가져오기
onBeforeMount(async () => {
  const data = await getApi({
    url: `/product/deposit/${productId}`,
  });
  detailTitle = defineAsyncComponent(() => import("@/components/card/carddetail/DetailTitle.vue"));
  console.log(data);
  depositData.value = data;
});
</script>

<style scoped>
@font-face {
  font-family: "WooridaumB";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2205@1.0/WooridaumB.woff2")
    format("woff2");
  font-weight: 700;
  font-style: normal;
}
.logo-text {
  font-size: 18px;
  font-weight: bold;
  font-family: "WooridaumB", sans-serif;
}

/* .custom-container {
  background-color: #eeeeee;
  margin: 0px;
  padding: 120px;
} */
</style>
