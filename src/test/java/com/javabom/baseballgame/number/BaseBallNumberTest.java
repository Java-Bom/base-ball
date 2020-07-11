package com.javabom.baseballgame.number;

import com.javabom.baseballgame.rule.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallNumberTest {

    @DisplayName("BaseBallNumber 는 가지고 있는 숫자가 아닌 숫자의 위치 순서로 정렬된다.")
    @Test
    void compareWithBaseBallNumberPosition() {
        BaseBallNumber baseBallNumber1 = new BaseBallNumber(3, 2);
        BaseBallNumber baseBallNumber2 = new BaseBallNumber(2, 3);

        assertThat(baseBallNumber1.compareTo(baseBallNumber2)).isEqualTo(-1);
    }

    private static Stream<Arguments> provideBaseBallNumberAndRule() {
        return Stream.of(Arguments.of(new BaseBallNumber(1, 1), Rule.STRIKE),
                Arguments.of(new BaseBallNumber(1, 2), Rule.BALL),
                Arguments.of(new BaseBallNumber(2, 1), Rule.OUT),
                Arguments.of(new BaseBallNumber(2, 2), Rule.OUT));
    }

    @DisplayName("다른 BaseBallNumber와 비교하여 맞는 Rule을 반환한다.")
    @ParameterizedTest
    @MethodSource("provideBaseBallNumberAndRule")
    void match(BaseBallNumber target, Rule expectedResult) {
        BaseBallNumber baseBallNumber = new BaseBallNumber(1, 1);

        Rule actualResult = baseBallNumber.match(target);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}