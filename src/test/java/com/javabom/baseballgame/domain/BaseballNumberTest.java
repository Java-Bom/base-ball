package com.javabom.baseballgame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberTest {

    @DisplayName("야구 숫자는 0~9 이외를 넣으면 Exception")
    @ParameterizedTest()
    @ValueSource(ints = {-1, 10})
    void validateBaseballNumberRange(int number) {
        // then
        assertThatThrownBy(() -> BaseballNumber.of(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("야구 숫자는 0 ~ 9 사이입니다. 입력 값 : %d", number));
    }
}