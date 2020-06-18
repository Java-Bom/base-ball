package com.javabom.baseballgame.domain.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MatchedResultsTest {

    @DisplayName("게임 결과의 갯수가 3개가 아니면 IllegalArgumentException을 발생시킨다.")
    @Test
    void checkCount() {
        //given
        List<MatchedResult> matchedResults = Arrays.asList(
                MatchedResult.STRIKE,
                MatchedResult.OUT);

        //then
        assertThatThrownBy(() -> new MatchedResults(matchedResults))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%d, 게임 결과는 총 3개가 들어와야 합니다.", 2));
    }

    @DisplayName("STRIKE가 3개면 true, 아니면 false를 반환한다.")
    @ParameterizedTest
    @CsvSource({"STRIKE, STRIKE, STRIKE,true", "STRIKE, STRIKE, BALL,false"})
    void getSolvedStatus(String firstResult, String secondResult, String thirdResult, boolean expected) {
        //given
        List<MatchedResult> matchedResultList = Arrays.asList(
                MatchedResult.valueOf(firstResult),
                MatchedResult.valueOf(secondResult),
                MatchedResult.valueOf(thirdResult));

        MatchedResults matchedResults = new MatchedResults(matchedResultList);

        //when
        boolean actual = matchedResults.getSolvedStatus();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("게임 결과의 갯수를 반환해준다.")
    @Test
    void getMatchedCountOf() {
        //given
        List<MatchedResult> matchedResultList = Arrays.asList(
                MatchedResult.STRIKE,
                MatchedResult.BALL,
                MatchedResult.BALL);

        MatchedResults matchedResults = new MatchedResults(matchedResultList);

        //when
        int actualOfStrike = matchedResults.getMatchedCountOf(MatchedResult.STRIKE);
        int actualOfBall = matchedResults.getMatchedCountOf(MatchedResult.BALL);
        int actualOfOut = matchedResults.getMatchedCountOf(MatchedResult.OUT);

        //then
        assertThat(actualOfStrike).isEqualTo(1);
        assertThat(actualOfBall).isEqualTo(2);
        assertThat(actualOfOut).isEqualTo(0);
    }
}