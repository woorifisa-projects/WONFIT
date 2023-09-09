<template>
  <v-container class="mt-12">
    <div>
      <div>
        <Suspense>
          <detailTitle
            :name="loanData.loanName"
            :info="loanData.loanInfo"
            :interestRate="'상품 금리: ' + loanData.interestRate + '%'"
            :target="'대출 대상: ' + loanData.target"
            :period="'대출 기간: ' + loanData.period + '개월'"
            :loanLimit="'대출 한도: ' + loanData.loanLimit + '원'"
            :type="'상품 타입: ' + loanData.loanType"
            :button1="'대출신청'"
            :button2="'전화신청'"
            :url="'loan'"
          />
        </Suspense>
      </div>

      <div>
        <v-sheet elevation="4" max-width="900" rounded="lg" width="100%" class="pa-6 mt-10 mx-auto">
          <h2 class="logo-text text-h6 mb-5">상품 설명</h2>

          <v-divider class="mb-4"></v-divider>

          <detail-text data-name="개요" :dataContent="loanData.loanInfo" />
          <detail-text dataName="대출 대상" :dataContent="loanData.target" />
          <detail-text dataName="대출한도 금액" :dataContent="loanData.loanLimit + '원'" />
          <detail-text dataName="대출 기간" :dataContent="loanData.period + '개월'" />
          <detail-text dataName="기본 금리" :dataContent="loanData.interestRate + '%'" />
          <detail-text
            dataName="우대 금리"
            dataContent="
  최대 연 0.2%p
  ① WON통장/우리꿈통장에서 출금하여 가입하는 경우 - 연 0.1%p
  ② 우리 오픈뱅킹 서비스에 타행계좌가 등록되어 있는 경우- 연 0.1%p
  
     ※ 세부 우대조건은 아래 상품 약관 및 상품설명서를 확인해 주세요"
          />
          <detail-text
            dataName="상환 방법"
            dataContent="통장대출 형식 한도거래대출(마이너스통장)
- 한도거래대출 내에서 자유로이 상환하며, 대출 만기일에 전액상환하는 방식"
          />
          <detail-text dataName="담보" dataContent="신용 대출" />
          <detail-text
            dataName="고객부담비용"
            dataContent="
인지세 등 고객부담비용 : 없음, 
중도상환해약금 : 없음"
          />

          <detail-text
            dataName="이자 납입"
            dataContent="※ 이자계산방법 
- 한도대출(마이너스통장)
   (매일의 적수에 대하여 이자계산)
  (매일의 적수 : 마감잔액+(일중 최고잔액-개시잔액 또는 마감잔액 중 큰금액) 
※ 이자납입방법
- 한도대출(마이너스통장)
   은행이 정한 매월 결산일에 납입
   매월 셋째주 토요일 (공휴일인 경우 직전 영업일)을 기준(다음날 고객님의 계좌에서 자동인출)"
          />
          <detail-text
            dataName="지연배상금"
            dataContent="※ 연체이자율 : 대출금리 + 연 3% (최고 年 12%) 
※ 연체이자(지연배상금)을 납부하셔야 하는 경우 
 ① 대출금을 만기일에 상환하지아니한 때
    - 대출 잔액에 대하여  만기일의 다음날 부터 상환일 전일까지 연체이자를 납부하셔야 합니다.
 ② 대출금의 기한의 이익이 상실된 때
    - 대출 잔액에 대하여 기한의 이익이 상실된 다음날부터 상환일 전일까지 연체이자를 납부하셔야합니다.
 ③ 이자를 납부하기로 약정한 날에 납부하지 아니한 때
    - 이자를 납부하여야 할 날의 다음날부터 1개월 해당일까지는 납부하여야 할 이자에 대하여, 그 이후에는
      대출 잔액에 대하여 이자납부 전일까지 연체이자를 납부하셔야 합니다.
 ④ 분할상환금(또는 분할상환원리금)을 납부하기로 한 날 에 상환하지 아니한 때
    - 1회 지체 시에는 지연된 분할상환금 (또는 분할상환 원리금)에 대하여, 연속 2회 이상 지체 시에는 대출 잔액에
     대하여 분할상환금 (또는 분할상환 원리금) 납입 전일까지 연체이자를 납부하셔야 합니다."
          />
          <detail-text
            dataName="계약의 해지 또는 갱신방법"
            dataContent="※ 계약의 해지
 - 고객이 대출금을 전액 상환하거나, 통장대출 약정에 대한 해지의사를 표시 한때
   (영업점, 인터넷, 스마트뱅킹등을 통하여 상환 및 신청가능) 
※ 기한연장
 - 만기도래시 당행에서 정한 일정요건을 갖춘 경우 기간연장 가능합니다.
 - 영업점, 스마트뱅킹에서 연장신청 가능"
          />
          <detail-text
            data-name="원금 또는 이자상환 제한"
            dataContent="영업점, 인터넷, 스마트등 채널에 관계없이 자유롭게 상환 가능합니다.
휴일에 원금 또는 이자상환 가능합니다."
          />
          <detail-text
            data-name="본인확인"
            dataContent="대출신청단계에서 휴대폰 SMS인증을 실시하며, '본인명의'의 휴대폰이 아닐 경우 다음 단계 진행이 불가능 하오니, 이점 감안하시어 신청하시기 바랍니다."
          />
          <detail-text
            data-name="거래제한"
            dataContent="※ 대출 취급 부적격 고객(연체대출금 보유, 신용도 판단정보 등록 고객, 상품 대상요건에 충족하지 않는 고객 등)은 대출이 취급되지 않거나 제한하여 운용될 수 있습니다.
※ 기간연장 시점에서 개인신용도에 따라 대출금의 일부 또는 전부가 회수될 수 있습니다."
          />
          <detail-text
            data-name="유의사항"
            dataContent="※ 일반금융소비자는 금융소비자보호법 제19조 제1항에 따라 은행으로부터 충분한 설명을 받을 권리가 있으며, 본 대출에 관한 계약을 체결하기 전에 상품설명서 및 약관을 읽어보시기 바랍니다.
          ※ 당행의 심사기준과 고객 신용도에 따라 대출여부 및 대출한도가 결정됩니다.
※ 단시일내에 타금융기관 대출신청(한도조회 포함) 횟수가 과다할 경우, 승인이 제한될 수 있습니다.
※ 알뜰폰 사용자는 대출이 불가합니다.
※ 대출약정조건에 따라 대출이자 또는 원금을 약정한 날에 납입(상환)하지 않을 경우 연체이자율이 적용되며, 신용도 하락 및 예금등 기타 채권과의 상계나 법적절차 등으로 불이익을 받으실 수 있습니다.
※ 대출금의 만기경과, 이자납입일 지연, 기한의 이익상실시 다음의 불이익이 발생할 수 있습니다.
· 대출 잔액에 대하여 연체이자를 납부
· ‘신용정보의 이용 및 보호에 관한 법률’, ‘신용정보관리규약’에 근거, 신용도판단정보(연체정보, 대위변제 및 대지급정보, 부도정보, 금융질서문란정보 등) 등록자로 등재되어 금융거래시 불이익 발생가능
· 보유 중인 예금과의 상계, 담보목적물 처분, 발견재산에 대한 보전조치 등의 법적절차 진행가능
· 신용관리대상자, 연체이력보유자, 신용거래 정보부족 등 여신부적격자로 분류되어 대출취급이 제한될 수 있음
※ 상환능력에 비해 대출금 사용액이 과도할 경우 개인신용평점이 하락할 수 있습니다. 개인신용평점 하락으로 금융거래와 관련된 불이익이 발생할 수 있습니다.
※ 일정 기간 납부해야할 원리금이 연체될 경우에 계약만료 기한이 도래하기 전에 모든 원리금을 변제해야할 의무가 발생할 수 있습니다
※ 금리인하요구권 : 본 상품은 금리인하요구권 신청이 가능합니다. 단, 은행의 심사결과에 따라 금리인하 요청이 반영되지 않을 수도 있습니다.
※ 대출계약철회권 : 본 상품은 대출계약철회권 신청이 가능합니다.
※ 위법계약해지권 : 은행과 체결한 대출계약이 금융소비자보호법상 적합성·적정성 원칙 또는 설명의무를 위반하였거나, 불공정영업행위·부당권유행위에 해당하는 경우, 법 위반사실을 안 날부터 1년 또는 계약서류 수령일·계약체결일·대출금 수령일로부터 5년 중 먼저 도달한 기간 이내에 서면, 전화, 컴퓨터 통신으로 해당 계약의 해지를 요구할 수 있습니다. 은행은 해지를 요구받은 날부터 10일 이내에 고객에게 수락여부 및 그 사유를 고객에게 통지합니다.
※ 자료열람요구권 : 본 상품은 자료열람요구권 신청이 가능합니다.
※ 상기 상품 내용은 우리은행 내부기준에 따라 대출조건이 변경 또는 제한될 수 있습니다.
※ 본 설명서는 상품에 대한 이해를 돕고, 중요내용을 알려드리기 위한 참고자료이며, 실제 상품의 계약은 여신거래기본약관 및 대출거래약정서의 적용을 받습니다.
※ 기타 추가적인 세부내용은 하단의 여신거래기본약관 및 가계대출 상품설명서를 참고하시기 바랍니다."
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

const loanData = ref([]);
const route = useRoute();
// URL에서 productId를 가져오기 위해 route.params를 사용합니다.
const productId = route.params.id;

let detailTitle;

// 상품 정보 가져오기
onBeforeMount(async () => {
  const data = await getApi({
    url: `/product/loan/${productId}`,
  });

  detailTitle = defineAsyncComponent(() => import("@/components/card/carddetail/DetailTitle.vue"));
  console.log(data);
  loanData.value = data;
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
