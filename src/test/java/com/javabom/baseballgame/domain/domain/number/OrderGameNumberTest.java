package com.javabom.baseballgame.domain.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderGameNumberTest {

    @DisplayName("순서와 상관없이 숫자가 같으면 true, 숫자가 다르면 false를 반환한다.")
    @ParameterizedTest
    @CsvSource({"1,1,true", "0,1,true", "1,2,false", "0,2,false"})
    void equalsOfNumber(int order, int number, boolean expected) {
        //given
        OrderGameNumber orderGameNumber = OrderGameNumber.of(0, GameNumber.of(1));
        OrderGameNumber inputGameNumber = OrderGameNumber.of(order, GameNumber.of(number));

        //when
        boolean actual = orderGameNumber.equalsOfNumber(inputGameNumber);

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
