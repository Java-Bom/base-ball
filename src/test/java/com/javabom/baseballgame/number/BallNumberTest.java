package com.javabom.baseballgame.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallNumberTest {

    @DisplayName("야구 숫자는 0 ~ 9 이외의 숫자로 생성 하려하면 IllegalArgumentException Throw")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, 10, 11})
    void validateCreateBallNumber(int number) {
        assertThatThrownBy(() -> BallNumber.valueOf(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("야구 숫자는 0 ~ 9 사이의 값이어야 합니다. - " + number);
    }

    @DisplayName("숫자야구 게임의 숫자들은 미리 만들어진 숫자들을 캐싱하여 사용한다.")
    @Test
    void cachingBallNumbers() {
        int number = 1;
        BallNumber expectedResult = BallNumber.valueOf(number);
        assertThat(expectedResult).isSameAs(BallNumber.valueOf(1));
    }
}