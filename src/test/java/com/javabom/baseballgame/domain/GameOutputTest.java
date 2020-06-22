package com.javabom.baseballgame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class GameOutputTest {

    @DisplayName("숫자와 순서가 같으면 STRIKE, 숫자만 같으면 BALL, 그 외엔 OUT을 반환한다 ")
    @CsvSource({"1,1, STRIKE", "1,2, BALL", "4,3, OUT"})
    @ParameterizedTest
    void output(int number, int orderValue, GameOutput output) {
        //given
        Order order = Order.valueOf(orderValue);
        BaseballNumber userNumber = BaseballNumber.of(order, number);
        BaseballNumber gameNumber = BaseballNumber.of(Order.valueOf(1), 1);

        //when //then
        assertThat(GameOutput.compare(userNumber, gameNumber)).isEqualTo(output);
    }

}