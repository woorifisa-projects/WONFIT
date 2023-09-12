<template>
  <v-sheet elevation="3" max-width="900" rounded="lg" width="100%" class="px-6 pt-5 mx-auto">
    <v-card-item style="line-height: 1.7">
      <v-card-title class="clickable-title" style="font-size: 25px">{{ name }}</v-card-title>
      <v-card-subtitle style="font-size: 17px">{{ info }}</v-card-subtitle>
    </v-card-item>

    <v-divider class="mb-2"></v-divider>

    <v-row>
      <v-col cols="6">
        <v-card-text class="py-5" style="font-size: large; letter-spacing: 1px; line-height: 2">
          <p>{{ interestRate }}</p>
          <p v-if="returnRate2">{{ returnRate2 }}</p>
          <p v-if="target">{{ target }}</p>
          <p v-if="period">{{ period }}</p>
          <p v-if="minDeposit">{{ /*예금 - 가입 금액*/ minDeposit }}</p>
          <p v-if="maxDeposit">{{ /*적금 - */ maxDeposit }}</p>
          <p v-if="fundPrice">{{ /*펀드 - 기준가*/ fundPrice }}</p>
          <p v-if="loanLimit">{{ /*대출 - */ loanLimit }}</p>
          <p>{{ type }}</p>
        </v-card-text>
      </v-col>
      <v-col cols="6">
        <v-card-text>
          <div class="text-end">
            <div class="pa-2">
              <v-btn
                color="#3C7FE3"
                rounded="xl"
                width="160"
                height="45"
                style="font-size: large; color: white"
                @click="navigateToSubscribe"
              >
                {{ button1 }}
              </v-btn>
            </div>

            <div class="pa-2">
              <v-btn
                color="#3C7FE3"
                rounded="xl"
                width="160"
                height="45"
                style="font-size: large; color: white"
                @click="dialog = true"
              >
                {{ button2 }}
              </v-btn>
            </div>

            <v-dialog v-model="dialog" max-width="250">
              <v-card class="text-center" style="border-radius: 15px">
                <v-card-text class="pt-7 pb-0"> 고객상담 02-123-4567 </v-card-text>
                <v-card-actions class="d-flex justify-center">
                  <v-btn color="primary" style="border-radius: 16px" @click="dialog = false"
                    >닫기</v-btn
                  >
                </v-card-actions>
              </v-card>
            </v-dialog>

            <div class="pa-2 mt-1">
              <v-btn
                rounded="xl"
                width="160"
                height="45"
                style="font-size: medium"
                @click.stop="toggleLike"
              >
                <svg-icon
                  type="mdi"
                  :path="isShow ? heartOutline : heart"
                  style="margin-right: 8px"
                  color="#1867C0"
                ></svg-icon>
                관심상품 등록</v-btn
              >
            </div>
          </div>
        </v-card-text>
      </v-col>
    </v-row>
  </v-sheet>
</template>

<script setup>
import { ref, defineProps, onBeforeMount } from "vue";
import SvgIcon from "@jamescoyle/vue-icon";
import { mdiPuzzleHeart, mdiPuzzleHeartOutline } from "@mdi/js";
import { getApi } from "@/api/modules";
import { useRouter, useRoute } from "vue-router";

const router = useRouter();
const route = useRoute();

const heart = ref(mdiPuzzleHeart);
const heartOutline = ref(mdiPuzzleHeartOutline);
const isShow = ref(true);
const likedData = ref([]);
const dialog = ref(false);

const props = defineProps([
  "name",
  "info",
  "interestRate",
  "returnRate2",
  "target",
  "period",
  "minDeposit",
  "maxDeposit",
  "fundPrice",
  "loanLimit",
  "type",
  "button1",
  "button2",
  "url",
]);

// 상품에 상관없이 불러올 수 있는 값
const name = props.name;
const info = props.info;
const type = props.type;

// "좋아요" 상태를 토글하는 메서드
const toggleLike = () => {
  isShow.value = !isShow.value; // "좋아요" 상태를 반전시킵니다.
};

// 관심상품 정보 가져오기
onBeforeMount(async () => {
  const data = await getApi({
    url: "/member/mypage/liked",
  });
  likedData.value = data;
  console.log(likedData);
});

const navigateToSubscribe = () => {
  router.push(`/subscribe/${props.url}/${route.params.id}`);
};
</script>

<style></style>
