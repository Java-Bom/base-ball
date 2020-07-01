package com.javabom.baseballgame.domain.domain.game;

import com.javabom.baseballgame.domain.domain.number.GameNumber;
import com.javabom.baseballgame.domain.domain.result.MatchedResult;
import com.javabom.baseballgame.domain.domain.result.MatchedResults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallGameTest {

    @DisplayName("사용자가 입력한 숫자와 비교하여 일치결과를 반환한다.")
    @Test
    void getMatchedResults() {
        //given
        GameNumbersGenerator gameNumbersGenerator = () -> Arrays.asList(GameNumber.of(1), GameNumber.of(2), GameNumber.of(3));
        BaseBallGame baseBallGame = new BaseBallGame(gameNumbersGenerator);

        //when
        MatchedResults matchedResults = baseBallGame.getMatchedResults(Arrays.asList("1", "2", "3"));

        //then
        assertThat(matchedResults.getMatchedCountOf(MatchedResult.STRIKE)).isEqualTo(3);
    }
}
