package com.javabom.baseballgame.domain.baseball.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallNumberTest {


    @DisplayName("0~9숫자 이외의 숫자가 들어올시 예외처리.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    public void validBallNumberRangeTest(int value) {
        assertThatThrownBy(() -> BallNumber.valueOf(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("입력한 숫자 : %d - %d~%d 사이의 숫자만 허용됩니다.",
                        value, BallNumber.NUMBER_START, BallNumber.NUMBER_END));
    }

    @DisplayName("0~9사이의 VO 객체가 생성되는지 확인.")
    @ParameterizedTest
    @ValueSource(ints = {0, 9})
    public void voRangeTest(int value) {
        assertThat(BallNumber.valueOf(value).getValue()).isEqualTo(value);
    }
}