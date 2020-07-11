package com.javabom.baseballgame.number;

import com.javabom.baseballgame.rule.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class BaseBallNumbersTest {

    @DisplayName("입력한 숫자의 개수가 3개가 아니면 IllegalArgumentsException throw")
    @Test
    void validateFixedBaseBallNumbersSize() {
        List<Integer> wrongs = Arrays.asList(1, 2);
        assertThatThrownBy(() -> BaseBallNumbers.ofFixed(wrongs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("야구 숫자 갯수는 3개 이어야합니다.");
    }

    @DisplayName("인자로 받은 BaseBallNumbers와 비교해서 예측 결과의 Map을 반환한다.")
    @Test
    void predicateBalls() {
        BaseBallNumbers answerBalls = BaseBallNumbers.ofFixed(Arrays.asList(1, 2, 3));
        BaseBallNumbers myBalls = BaseBallNumbers.ofFixed(Arrays.asList(1, 3, 4));

        Map<Rule, Integer> predicateResult = answerBalls.predicateBalls(myBalls);

        assertAll(
                () -> assertThat(predicateResult).containsEntry(Rule.STRIKE, 1),
                () -> assertThat(predicateResult).containsEntry(Rule.BALL, 1),
                () -> assertThat(predicateResult).containsEntry(Rule.OUT, 1)
        );
    }
}