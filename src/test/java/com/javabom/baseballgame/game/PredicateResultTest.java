package com.javabom.baseballgame.game;

import com.javabom.baseballgame.rule.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PredicateResultTest {

    private static Stream<Arguments> provideCountsAndAnswer() {
        return Stream.of(
                Arguments.of(3, 0, 0, true),
                Arguments.of(1, 1, 1, false)
        );
    }

    @DisplayName("예측 결과의 Map에서 0개인 결과를 제외한 Map을 반환한다.")
    @Test
    void getResultExcludeZeroValue() {
        Map<Rule, Integer> results = new EnumMap<>(Rule.class);
        results.put(Rule.STRIKE, 1);
        results.put(Rule.BALL, 2);
        results.put(Rule.OUT, 0);
        PredicateResult predicateResult = new PredicateResult(1, results);

        Map<Rule, Integer> excludeResults = predicateResult.getResultExcludeZeroValue();

        assertThat(excludeResults).doesNotContainKey(Rule.OUT);
    }

    @DisplayName("예측에 성공했는지 여부를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideCountsAndAnswer")
    void isAnswer(int strikeCount, int ballCount, int outCount, boolean answer) {
        Map<Rule, Integer> results = new EnumMap<>(Rule.class);
        results.put(Rule.STRIKE, strikeCount);
        results.put(Rule.BALL, ballCount);
        results.put(Rule.OUT, outCount);
        PredicateResult predicateResult = new PredicateResult(1, results);

        assertThat(predicateResult.isAnswer()).isEqualTo(answer);
    }
}