package com.javabom.baseballgame.domain.domain.number;

import com.javabom.baseballgame.domain.domain.result.MatchedResult;
import com.javabom.baseballgame.domain.domain.result.MatchedResults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningGameNumbersTest {

    @DisplayName("게임에 사용될 숫자의 갯수가 3이 아니면 IllegalArgumentException을 발생시킨다.")
    @Test
    void checkCount() {
        //given
        List<GameNumber> gameNumbers = Arrays.asList(
                GameNumber.of(1),
                GameNumber.of(3));
        //then
        assertThatThrownBy(() -> new WinningGameNumbers(gameNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%d, 숫자 게임에서 사용될 숫자의 갯수는 3개여야 합니다.", gameNumbers.size()));
    }

    @DisplayName("게임에 사용될 숫자에 중복이 있을 경우 IllegalArgumentException을 발생시킨다.")
    @Test
    void checkDuplicate() {
        //given
        List<GameNumber> gameNumbers = Arrays.asList(
                GameNumber.of(1),
                GameNumber.of(1),
                GameNumber.of(2));

        //then
        assertThatThrownBy(() -> new WinningGameNumbers(gameNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("중복을 제외한 숫자 갯수: %d, 숫자에 중복이 있습니다.", 2));
    }

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
