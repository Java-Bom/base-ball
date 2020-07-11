package com.javabom.baseballgame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameMachineTest {

    @DisplayName("시도 회수가 제대로 올라가는지 확인")
    @Test
    void getTryCount() {
        // given
        BaseballGameMachine machine = new BaseballGameMachine(new BaseballNumbersFactory());

        // when
        machine.trySolve(Arrays.asList(1, 2, 3));

        // then
        assertThat(machine.getTryCount()).isEqualTo(1);
    }

    @DisplayName("컴퓨터가 낸 숫자를 모두 맞추면 isSolved가 true 되는지 확인")
    @Test
    void isSolved() {
        // given
        BaseballNumbersFactory factory = new BaseballNumbersFactory() {
            @Override
            public BaseballNumbers createRandomNumbers() {
                return new BaseballNumbers(
                        Arrays.asList(BaseballNumber.of(1), BaseballNumber.of(2), BaseballNumber.of(3))
                );
            }
        };
        BaseballGameMachine machine = new BaseballGameMachine(factory);

        // when
        machine.trySolve(Arrays.asList(1, 2, 3));

        // then
        assertThat(machine.isSolved()).isTrue();
    }
}