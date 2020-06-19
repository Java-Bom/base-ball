package com.javabom.baseballgame.domain.result;

import com.javabom.baseballgame.domain.baseball.BaseballGameNumbers;
import com.javabom.baseballgame.domain.baseball.BaseballGameNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class MatchResultTest {

    @Test
    @DisplayName("정답 번호들과 입력된 번호의 결과의 STRIKE 개수를 잘 반환하는지 확인.")
    void getStrikeMatchCount() {
        BaseballGameNumbers correctNumber = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(1, 2, 3));
        BaseballGameNumbers allStrike = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(1, 2, 3));
        BaseballGameNumbers twoStrike = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(1, 2, 4));
        BaseballGameNumbers oneStrike = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(1, 4, 5));
        BaseballGameNumbers zeroStrike = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(4, 5, 6));

        assertThat(MatchResult.STRIKE.getMatchCount(correctNumber, allStrike)).isEqualTo(3);
        assertThat(MatchResult.STRIKE.getMatchCount(correctNumber, twoStrike)).isEqualTo(2);
        assertThat(MatchResult.STRIKE.getMatchCount(correctNumber, oneStrike)).isEqualTo(1);
        assertThat(MatchResult.STRIKE.getMatchCount(correctNumber, zeroStrike)).isEqualTo(0);
    }

    @Test
    @DisplayName("정답 번호들과 입력된 번호의 결과의 BALL 개수를 잘 반환하는지 확인.")
    void getBallMatchCount() {
        BaseballGameNumbers correctNumber = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(1, 2, 3));
        BaseballGameNumbers allBall = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(3, 1, 2));
        BaseballGameNumbers twoBall = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(2, 1, 4));
        BaseballGameNumbers oneBall = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(4, 1, 5));
        BaseballGameNumbers zeroBall = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(4, 5, 6));

        assertThat(MatchResult.BALL.getMatchCount(correctNumber, allBall)).isEqualTo(3);
        assertThat(MatchResult.BALL.getMatchCount(correctNumber, twoBall)).isEqualTo(2);
        assertThat(MatchResult.BALL.getMatchCount(correctNumber, oneBall)).isEqualTo(1);
        assertThat(MatchResult.BALL.getMatchCount(correctNumber, zeroBall)).isEqualTo(0);
    }

    @Test
    @DisplayName("정답 번호들과 입력된 번호의 결과의 OUT 개수를 잘 반환하는지 확인.")
    void getOutMatchCount() {
        BaseballGameNumbers correctNumber = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(1, 2, 3));
        BaseballGameNumbers zeroOut = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(3, 1, 2));
        BaseballGameNumbers oneOut = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(2, 1, 4));
        BaseballGameNumbers twoOut = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(4, 1, 5));
        BaseballGameNumbers allOut = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(4, 5, 6));

        assertThat(MatchResult.OUT.getMatchCount(correctNumber, allOut)).isEqualTo(3);
        assertThat(MatchResult.OUT.getMatchCount(correctNumber, twoOut)).isEqualTo(2);
        assertThat(MatchResult.OUT.getMatchCount(correctNumber, oneOut)).isEqualTo(1);
        assertThat(MatchResult.OUT.getMatchCount(correctNumber, zeroOut)).isEqualTo(0);
    }
}