<template>
    <div>
        <v-banner class="large-text logo-text" text="우리WONFIT 소득정보 수집 동의" :stacked="false"></v-banner>
        <div class="logo">
            <div class="d-flex align-center flex-column">
                <img src="@/assets/wonfit.png" style="width: 150px; margin-right: 5px" />
                <span class="logo-text logo-text" style="font-size: 20px; margin-top: 8px; color: steelblue;">WONFIT</span>
                <span class="logo-text logo-text" style="font-size: 12px; margin-top: 8px;">FIT YOUR ACCOUNT!</span>
                <span class="logo-text logo-text" style="font-size: 20px; margin-top: 30px;">우리WONFIT에서 나만의 맞춤형 금융상품 서비스를
                    알아보세요!</span>

                <v-checkbox class="checkbox logo-text" label="우리WONFIT 개인 신용정보 제공 동의 (필수)"
                    hide-details="false"></v-checkbox>
                <v-checkbox class="checkbox logo-text" label="우리WONFIT 개인정보 수집·이용 동의 (필수)"
                    hide-details="false"></v-checkbox>
                <v-checkbox class="checkbox logo-text" label="우리WONFIT 마케팅 수신 동의 (선택)"  hide-details="false" ></v-checkbox>

                <v-btn class="logo-text" variant="tonal">
                    은행 선택하기
                </v-btn>
            </div>
        </div>
    </div>
</template>

<script setup>

</script>

<style lang="scss" scoped>
.large-text {
    font-size: 20px;
    /* Adjust the font size as needed */
}

.logo {
    display: flex;
    justify-content: center;
    align-items: center;
    margin-top: 8px;
}

.flex-column {
    flex-direction: column;
}

.checkbox {
    margin-top: 1px;
    
    /* Adjust the margin as needed */
}

@font-face {
    font-family: "WooridaumB";
    src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2205@1.0/WooridaumB.woff2") format("woff2");
    font-weight: 700;
    font-style: normal;
}

.logo-text {
    font-size: 18px;
    font-weight: bold;
    font-family: "WooridaumB", sans-serif;
    /* 적용한 폰트 스타일 사용 */
}</style>
