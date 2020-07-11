package com.javabom.baseballgame.domain.result;

import com.javabom.baseballgame.domain.baseball.BaseballGameNumbers;
import com.javabom.baseballgame.domain.baseball.BaseballGameNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TryResultTest {

    @Test
    @DisplayName("시도결과가 전부 STRIKE인지 여부 판단.")
    void isAllStrike() {
        BaseballGameNumbers correctNumbers = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(1, 2, 3));
        BaseballGameNumbers allStrikeNumbers = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(1, 2, 3));
        BaseballGameNumbers twoStrikeNumbers = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(1, 2, 4));

        TryResult allStrikeResult = new TryResult(correctNumbers, allStrikeNumbers);
        TryResult twoStrikeResult = new TryResult(correctNumbers, twoStrikeNumbers);

        assertThat(allStrikeResult.isAllStrike()).isTrue();
        assertThat(twoStrikeResult.isAllStrike()).isFalse();
    }

    @Test
    @DisplayName("시도 결과의 STRIKE, BALL, OUT의 개수를 반환하는지 확인.")
    void getMatchResultCount() {
        BaseballGameNumbers correctNumbers = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(1, 2, 3));
        BaseballGameNumbers inputNumbers = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(1, 3, 5));

        TryResult tryResult = new TryResult(correctNumbers, inputNumbers);

        assertThat(tryResult.getMatchResultCount(MatchResult.STRIKE)).isEqualTo(1);
        assertThat(tryResult.getMatchResultCount(MatchResult.BALL)).isEqualTo(1);
        assertThat(tryResult.getMatchResultCount(MatchResult.OUT)).isEqualTo(1);

    }
}