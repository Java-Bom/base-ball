package com.javabom.baseballgame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class BaseballNumbersTest {

    @DisplayName("순서가 중복되면 Exception")
    @Test
    void duplicateTest() {
        Set<OrderedBaseballNumber> systemNumbers = new HashSet<>();
        systemNumbers.add(createOrderBaseballNumber(1, 1));
        systemNumbers.add(createOrderBaseballNumber(1, 3));
        systemNumbers.add(createOrderBaseballNumber(3, 4));

        assertThatThrownBy(() -> new BaseballNumbers(systemNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 중복되면 Exception")
    @Test
    void numduplicateTest() {
        Set<OrderedBaseballNumber> systemNumbers = new HashSet<>();
        systemNumbers.add(createOrderBaseballNumber(1, 1));
        systemNumbers.add(createOrderBaseballNumber(2, 1));
        systemNumbers.add(createOrderBaseballNumber(3, 4));

        assertThatThrownBy(() -> new BaseballNumbers(systemNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주어진 BaseballNumber와 비교한 결과를 반환한다")
    @Test
    void number() {
        //given
        BaseballNumbers baseballNumbers = createSystemNumbers();
        BaseballNumbers userBaseballNumbers = createUserNumbers();

        //when
        BaseballGameOutputs outputs = baseballNumbers.calculate(userBaseballNumbers);

        //then
        assertAll(
                () -> assertThat(outputs.countOf(GameOutput.STRIKE)).isEqualTo(1),
                () -> assertThat(outputs.countOf(GameOutput.BALL)).isEqualTo(1),
                () -> assertThat(outputs.countOf(GameOutput.OUT)).isEqualTo(1)
        );
    }

    private BaseballNumbers createSystemNumbers() {
        Set<OrderedBaseballNumber> systemNumbers = new HashSet<>();
        systemNumbers.add(createOrderBaseballNumber(1, 1));
        systemNumbers.add(createOrderBaseballNumber(2, 2));
        systemNumbers.add(createOrderBaseballNumber(3, 3));
        BaseballNumbers baseballNumbers = new BaseballNumbers(systemNumbers);
        return baseballNumbers;
    }

    private BaseballNumbers createUserNumbers() {
        Set<OrderedBaseballNumber> systemNumbers = new HashSet<>();
        systemNumbers.add(createOrderBaseballNumber(1, 1));
        systemNumbers.add(createOrderBaseballNumber(2, 3));
        systemNumbers.add(createOrderBaseballNumber(3, 4));
        BaseballNumbers baseballNumbers = new BaseballNumbers(systemNumbers);
        return baseballNumbers;
    }


    private OrderedBaseballNumber createOrderBaseballNumber(final int i, final int i2) {
        return OrderedBaseballNumber.of(Order.valueOf(i), BaseballNumber.of(i2));
    }
}