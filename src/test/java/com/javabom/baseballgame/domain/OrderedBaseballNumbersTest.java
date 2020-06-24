package com.javabom.baseballgame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class OrderedBaseballNumbersTest {

    @DisplayName("주어진 BaseballNumber와 비교한 결과를 반환한다")
    @CsvSource({"1,1,STRIKE", "1,2,BALL", "4,1,OUT"})
    @ParameterizedTest
    void number(int number, int order, GameOutput output) {
        //given
        Set<OrderedBaseballNumber> numbers = new HashSet<>();
        numbers.add(OrderedBaseballNumber.of(Order.valueOf(1), BaseballNumber.of(1)));
        numbers.add(OrderedBaseballNumber.of(Order.valueOf(2), BaseballNumber.of(2)));
        numbers.add(OrderedBaseballNumber.of(Order.valueOf(3), BaseballNumber.of(3)));
        BaseballNumbers baseballNumbers = new BaseballNumbers(numbers);

        //when
        OrderedBaseballNumber orderedBaseballNumber = OrderedBaseballNumber.of(
                Order.valueOf(order), BaseballNumber.of(number)
        );
        GameOutput result = baseballNumbers.calculate(orderedBaseballNumber);

        //then
        assertThat(result).isEqualTo(output);
    }
}