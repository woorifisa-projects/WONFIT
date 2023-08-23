<template>
  <div
    class="d-flex flex-column align-center justify-center"
    style="margin-top: 50px; font-size: 1.5em"
  >
    {{ currentQuestion }}
  </div>
  <div
    class="d-flex flex-column align-center justify-center"
    style="margin-top: 50px"
  >
    <v-checkbox
      v-for="(answer, index) in answers"
      :key="index"
      :label="answer"
      style="font-size: 1.2em"
      @click="selectAnswer(index)"
    ></v-checkbox>
  </div>
  <div class="d-flex flex-column align-center justify-center">
    <div class="d-flex justify-between align-center" style="margin-top: 20px">
      <v-btn
        v-if="currentQuestionIndex > 0"
        variant="tonal"
        class="d-flex justify-center align-center"
        style="
          padding: 20px;
          font-size: 1.1em;
          border-radius: 10px;
          background-color: #82b1ff;
          color: white;
          margin: 5px;
        "
        @click="previousQuestion"
      >
        이전
      </v-btn>
      <v-btn
        variant="tonal"
        class="d-flex justify-center align-center"
        style="
          padding: 20px;
          font-size: 1.1em;
          border-radius: 10px;
          background-color: #82b1ff;
          color: white;
          margin: 5px;
        "
        @click="nextQuestion"
      >
        {{ isLastQuestion ? "결과 보기" : "다음" }}
      </v-btn>
    </div>
  </div>
</template>

<script setup>
const questions = [
  "1. 만약 로또에 당첨된다면 주변 사람들에게 말하나요?",
  "2. 투자경험이 있나요?",
  "3. 한달 월급을 제외하고 남는 돈이 얼마인가요?",
  "4. 연봉 수준이 어떻게 되나요?",
  "5. 쇼핑을 자주 하나요",
];

const answers = [
  "말한다",
  "말하지 않는다",
  "고민해본다",
  // 나머지 선택지 추가
];

let currentQuestionIndex = 0;
let selectedAnswers = [];

let currentQuestion = questions[currentQuestionIndex];

function selectAnswer(answerIndex) {
  selectedAnswers[currentQuestionIndex] = answerIndex;
}

function nextQuestion() {
  if (currentQuestionIndex < questions.length - 1) {
    currentQuestionIndex++;
    currentQuestion = questions[currentQuestionIndex];
  }
}

function previousQuestion() {
  if (currentQuestionIndex > 0) {
    currentQuestionIndex--;
    currentQuestion = questions[currentQuestionIndex];
  }
}

let isLastQuestion = currentQuestionIndex === questions.length - 1;
</script>

<style lang="scss" scoped>
/* Add your styles here */
</style>
