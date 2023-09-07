<template>
  <div id="main" style="font-family: 'WooridaumB';">
    <div class="quiz__wrap">
      <div class="quiz">
        <h1>맞춤 예금 테스트</h1>
        <h2 class="quiz__question">{{ quizInfo[quizCount].answerAsk }}</h2>
        <p v-if="warningMessage" style="color: red;">답을 골라주세요</p>
        <div class="quiz__view"></div>
        <div class="quiz__answer">


          <label v-for="(choice, index) in quizInfo[quizCount].answerChoice" :key="'choice' + index"
            :class="{ selected: selectedAnswer === choice }" class="choice">
            <input type="radio" v-model='selectedAnswer' :value='choice'>
            {{ choice.text }}
          </label>


          <button v-if="showResult" @click.prevent='navigateToRecommendPage'>{{ resultMessage }}</button>

          <!-- 다음 문제 버튼 -->
          <button @click.prevent='nextQuestion' v-if='!showResult'>다음 문제 ≫</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import VueCookies from 'vue-cookies';

export default {
  data() {
    return {
      quizInfo: [
        {
          answerNum: "1",
          answerAsk: "Q1.붕어빵 먹을 때 가장 먼저 먹는 부위는?",
          answerChoice: [
            { text: "1. 머리! 머리가 정석 아님?", score: 1 },
            { text: "2. 몸통! 중간을 덥썩 먹어야지", score: 2 },
            { text: "3. 꼬리! 바삭한 꼬리부터~", score: 3 }
          ],
        },
        {
          answerNum: "2",
          answerAsk: "Q2.투자에 대한 지식수준이 어느 정도냐는 질문을 받았습니다 당신의 대답은?",
          answerChoice: [
            { text: "1. 높은 수준. 나는 투자할 수 있는 금융상품 차이들도 알고 주식 고수지!", score: 3 },
            { text: "2. 낮은 수준. 주식이랑 채권은 뭐가 뭔진 알겠는데..나머진 모르겠네", score: 2 },
            { text: "3. 경험이 없는 수준. 투자가 뭐지..? 해본 적 없는데 (하하)", score: 1 }
          ],
        },
        {
          answerNum: "3",
          answerAsk: "Q3.내 연간 소득은 어느 정도 냐면~",
          answerChoice: [
            { text: "1. 3천만원 이하", score: 1 },
            { text: "2. 5천만원 이하", score: 2 },
            { text: "3. 5천만원 이상", score: 3 }
          ],
        },
        {
          answerNum: "4",
          answerAsk: "Q4.얏호~ 급여 들어왔다! 근데 내 급여는 말이야",
          answerChoice: [
            { text: "1. 일정한 수입이 발생중이고 미래에 지금이랑 비슷하거나 더 벌거야!", score: 3 },
            { text: "2. 지금은 꾸준히 들어오고 있는데 나중에 줄거나 불안해질거 같아..", score: 2 },
            { text: "3. 지금은 용돈이나 연금이야~", score: 1 }
          ],
        },
        {
          answerNum: "5",
          answerAsk: "Q5.새로 의자를 사야하는데 오래 앉아있어야 하는 직업인 당신! 어떤 의자를 살거냐면..",
          answerChoice: [
            { text: "1. 꼼꼼하게 조사해서 가성비가 좋은게 좋지 역시", score: 2 },
            { text: "2. 그냥 비싼게 최고야 예산만큼 비싼거 사자!", score: 3 },
            { text: "3. 주변 사람들이 이게 최고라는데?추천 받은 의자", score: 1 }
          ],
        },
        {
          answerNum: "6",
          answerAsk: "Q6.친구들 만날 때 돈도 못 쓰고.. 적금이 드디어 만기다! 근데 이자가.. 작고 귀엽다. 이자를 보니 이런 생각이 드네",
          answerChoice: [
            { text: "1. 에휴..다음 적금은 괜찮으려나 다음 적금이나 들자", score: 1 },
            { text: "2. 오 그래도 모은돈은 좀 되는데..? 적금 말고 투자나 해봐?", score: 3 },
            { text: "3. 일단 이자로 핸드폰 바꿔야지", score: 2 }
          ],
        },
        {
          answerNum: "7",
          answerAsk: "Q7.친구랑 여행을 가려고 했는데 계획도 오케이 예약도 오케이 근데 다른 여행지도 재밌어 보이는데 이걸 어쩌지?",
          answerChoice: [
            { text: "1. 위약금은 물 수 없지 그냥 가자", score: 1 },
            { text: "2. 일단 친구한테 물어볼까?", score: 2 },
            { text: "3. 재밌어 보이는데로 가야지 위약금 정도야", score: 3 }
          ],
        },
        {
          answerNum: "8",
          answerAsk: "Q8.헤드헌터에게 세가지 제안이 왔다 어디 회사로 가야할까",
          answerChoice: [
            { text: "1. 성과도 좋고 탄탄한 회사", score: 1 },
            { text: "2. 잘 맞고 배울 수 있을 것 같은 회사", score: 3 },
            { text: "3. 워라밸이 좋은 후기가 좋은 회사", score: 2 }
          ],
        },
        {
          answerNum: "9",
          answerAsk: "Q9.투자를 하게 되면 원하는 수익과 감내할 수 있는 손실 수준은?",
          answerChoice: [
            { text: "1. 원하는 수준의 수익을 기대 못 한다면 20%미만 정도야..", score: 2 },
            { text: "2. 일정한 수준의 수익을 기대할 수 있다면 10%미만 까지는 손실 감수 할 수 있음", score: 3 },
            { text: "3. 무슨 일이 있어도 투자 원금은 보전되어야 함(엄근진)", score: 1 }
          ],
        },
        {
          answerNum: "10",
          answerAsk: "Q10. 더 와닿는 말은?",
          answerChoice: [
            { text: "1. 공포에 사서 환희에 팔아라", score: 3 },
            { text: "2. 잃지 않는 승부를 하라", score: 1 },
            { text: "3. 밀짚모자는 겨울에 사라", score: 2 }
          ],
        },
      ],
      quizCount: 0,
      correctAnswersCount: 0,
      selectedAnswer: '',
      showResult: false,
      warningMessage: false,
    };
  },

  computed: {
    resultMessage() {
      return `결과 보러 가기`;
    }
  },

  methods: {
    async navigateToRecommendPage() {
      // correctAnswersCount 값을 쿠키에 저장
      this.$cookies.set('Score', this.correctAnswersCount);
      // 서버에 POST 요청을 보냅니다.
      await axios.post('http://localhost:8080/member/recommend/product', {
        productType: "deposit",
        score: this.correctAnswersCount,
      }, {
        withCredentials: true,
      })
        .then(response => {
          console.log(response.data);
          this.$router.push({ name: "Recommend" });
        })
        .catch(error => {
          console.error(error);
        });
    },

    nextQuestion() {
      if (this.selectedAnswer === '') {
        this.warningMessage = true;
      } else {
        this.warningMessage = false;

        // 선택된 답변의 점수를 합산
        this.correctAnswersCount += Number(this.selectedAnswer.score);

        // 합산된 점수를 콘솔에 출력
        console.log("현재까지의 점수: ", this.correctAnswersCount);

        if (this.quizCount === this.quizInfo.length - 1) {
          // 마지막 문제일 경우 결과 표시
          this.showResult = true;
        } else {
          // 다음 문제로 이동
          this.quizCount++;
          this.selectedAnswer = '';
        }
      }
    },

    checkOnlyOne() {
      if (this.selectedAnswer.length > 1) {
        this.selectedAnswer.shift();
      }
    },
  },
};
</script>

<style scoped>
/* 스타일 내용 */
@font-face {
  font-family: "WooridaumB";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2205@1.0/WooridaumB.woff2") format("woff2");
  font-weight: 700;
  font-style: normal;
}

.choice:hover {
  background-color: #94afe1;

}

.choice.selected {
  background-color: #6098FF;
}

.choice input[type=radio] {
  position: absolute;
  left: -9999px;
}

.choice label span::before {
  content: '';
  width: 30px;
  height: 30px;
  margin-right: 15px;
  border-radius: 50%;
  background-color: #fff;
  box-shadow:
    inset -2px -2px rgba(0, 0, 0, .4),
    inset -3px -3px rgba(255, 255, 255, .7);
  transition: .5s ease-in-out;
}

.choice input[type=radio]:checked+label span::before {
  box-shadow:
    inset -2px -2px rgba(0, 0, 0, .4),
    inset -3px -3px rgba(255, 255, 255, .7),
    inset 10em10em #671010;
  /* 체크된 상태에서의 색상 */
  transition: .5s ease-in-out;
}

.quiz__answer {
  display: flex;
  flex-direction: column;
  align-items: flex-end;
}

.choice {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}

.choice {
  display: flex;
  flex-direction: column;
}

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

.quiz__wrap {
  display: flex;
  align-items: flex-start;
  justify-content: center;
  margin-top: 50px;
  margin-bottom: 150px;
  flex-wrap: wrap;
}

.quiz {
  max-width: 500px;
  width: 100%;
  background-color: #fff;
  margin: 10px;
}

.quiz__question {
  padding: 20px;
  font-family: "MabinogiClassic";
  font-weight: normal;
  line-height: 1.4;
}

.quiz__question .number {
  color: #F7AA2B;
}

.quiz__question .ask {
  display: inline;
}

.quiz__answer {
  padding: 10px;
  background-color: #f5f5f5;
}


.choice {
  margin: 5px 0;
}

.choice label {
  display: flex;
  align-items: center;
}

.choice label input {
  margin-right: 10px;
}

.choice label input:checked+span::before {
  box-shadow: inset 0px 0px 0px 10px #f8b74e;
}

.choice {
  width: 100%;
  text-align: center;
}
</style>
