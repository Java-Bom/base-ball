package com.javabom.baseballgame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultsTest {

    static List<Arguments> gameResults_AndExpectedSolved() {
        return Arrays.asList(
                Arguments.of(new GameResults(Arrays.asList(GameResult.STRIKE, GameResult.STRIKE, GameResult.STRIKE)), true),
                Arguments.of(new GameResults(Arrays.asList(GameResult.STRIKE, GameResult.STRIKE, GameResult.OUT)), false),
                Arguments.of(new GameResults(Arrays.asList(GameResult.STRIKE, GameResult.BALL, GameResult.OUT)), false)
        );
    }

    @DisplayName("3Strike 이면 야구 게임 성공, 이외엔 실패.")
    @ParameterizedTest
    @MethodSource("gameResults_AndExpectedSolved")
    void isSolved(GameResults gameResults, boolean expectedResult) {
        // then
        assertThat(gameResults.isSolved()).isEqualTo(expectedResult);
    }

    @DisplayName("게임 결과내에 특정 결과 개수를 제대로 뱉는지 확인")
    @Test
    void sizeOf() {
        // given
        GameResults gameResults = new GameResults(
                Arrays.asList(GameResult.STRIKE, GameResult.STRIKE, GameResult.OUT)
        );

        // then
        assertThat(gameResults.sizeOf(GameResult.STRIKE)).isEqualTo(2);
        assertThat(gameResults.sizeOf(GameResult.OUT)).isEqualTo(1);
    }
}