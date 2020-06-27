package com.javabom.baseballgame.domain.domain.number;

import com.javabom.baseballgame.domain.domain.result.MatchedResult;
import com.javabom.baseballgame.domain.domain.result.MatchedResults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningGameNumbersTest {

    @DisplayName("사용자가 입력한 숫자와 정답 숫자를 비교해서 결과를 반환한다.")
    @Test
    void getMatchedResults() {
        //given
        List<GameNumber> gameNumbers = Arrays.asList(
                GameNumber.of(1),
                GameNumber.of(2),
                GameNumber.of(3));
        WinningGameNumbers winningGameNumbers = new WinningGameNumbers(gameNumbers);

        List<String> preClientGameNumbers = Arrays.asList("1", "3", "5");
        ClientGameNumbers clientGameNumbers = new ClientGameNumbers(preClientGameNumbers);

        //when
        MatchedResults matchedResults = winningGameNumbers.getMatchedResults(clientGameNumbers);

        //then
        assertThat(matchedResults.getMatchedCountOf(MatchedResult.STRIKE)).isEqualTo(1);
        assertThat(matchedResults.getMatchedCountOf(MatchedResult.BALL)).isEqualTo(1);
        assertThat(matchedResults.getMatchedCountOf(MatchedResult.OUT)).isEqualTo(1);
    }
}
