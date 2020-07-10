package com.javabom.baseballgame.domain.baseball.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderTest {


    @ParameterizedTest
    @DisplayName("0~2이외의 순서 값이 들어오면 예외처리.")
    @ValueSource(ints = {-1,3})
    public void validOrderRange(int value) {
        assertThatThrownBy(() -> Order.valueOf(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("들어온 순서 : %d - %d~%d 사이의 순서만 허용됩니다.",
                        value, Order.ORDER_START, Order.ORDER_END));
    }
}