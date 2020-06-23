package com.javabom.baseballgame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BaseballGameTest {

    @DisplayName("사용자의 BaseballNumbers와 시스템 넘버를 비교하여 결과를 반환한다")
    @Test
    void baseball() {
        //given
        BaseballGame game = new BaseballGame(new TestBaseballNumbersGenerator());
        BaseballNumbers userNumbers = create(1, 3, 4);

        //when
        BaseballGameOutputs output = game.calculatOutput(userNumbers);

        //then
        assertAll(
                () -> assertThat(output.countOf(GameOutput.STRIKE)).isEqualTo(1),
                () -> assertThat(output.countOf(GameOutput.BALL)).isEqualTo(1),
                () -> assertThat(output.countOf(GameOutput.OUT)).isEqualTo(1)
        );

    }

    private BaseballNumbers create(int num1, int num2, int num3) {
        Set<BaseballNumber> numbers = new HashSet<>();
        numbers.add(BaseballNumber.of(Order.valueOf(1), num1));
        numbers.add(BaseballNumber.of(Order.valueOf(2), num2));
        numbers.add(BaseballNumber.of(Order.valueOf(3), num3));
        return new BaseballNumbers(numbers);
    }
}