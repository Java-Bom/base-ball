package com.javabom.baseballgame.domain.result;

import com.javabom.baseballgame.domain.baseball.BaseballGameNumbers;
import com.javabom.baseballgame.domain.baseball.BaseballGameNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TryResultsTest {

    @Test
    @DisplayName("마지막으로 입력된 시도 결과 값을 가져오는지 확인.")
    void peek() {
        BaseballGameNumbers correctNumbers = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(1, 2, 3));
        BaseballGameNumbers allStrikeNumbers = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(1, 2, 3));
        BaseballGameNumbers allOutNumbers = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(4,5,6));

        TryResults tryResults = new TryResults();

        tryResults.addResult(new TryResult(correctNumbers, allStrikeNumbers));
        assertThat(tryResults.peek().getMatchResultCount(MatchResult.STRIKE)).isEqualTo(3);

        tryResults.addResult(new TryResult(correctNumbers, allOutNumbers));
        assertThat(tryResults.peek().getMatchResultCount(MatchResult.OUT)).isEqualTo(3);
    }

    @Test
    @DisplayName("입력된 시도 횟수의 크기만큼 가지고 있는지 확인.")
    void size() {
        BaseballGameNumbers correctNumbers = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(1, 2, 3));
        BaseballGameNumbers allStrikeNumbers = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(1, 2, 3));
        BaseballGameNumbers allOutNumbers = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(4,5,6));
        TryResults tryResults = new TryResults();

        tryResults.addResult(new TryResult(correctNumbers, allStrikeNumbers));
        tryResults.addResult(new TryResult(correctNumbers, allOutNumbers));

        assertThat(tryResults.size()).isEqualTo(2);
    }
}