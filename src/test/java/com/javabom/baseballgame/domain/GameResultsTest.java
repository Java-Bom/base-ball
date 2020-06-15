package com.javabom.baseballgame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultsTest {

    // EnumList로 strike 3개 들어있을때, 그리고 3개가 아닐때를 실험하고싶은데,
    // EnumList를 파라미터로 주는 방법은 없나요?
    @DisplayName("3Strike 이면 야구 게임 성공. true 반환")
    @Test
    void isSolved() {
        // given
        GameResults gameResults = new GameResults(
                Arrays.asList(GameResult.STRIKE, GameResult.STRIKE, GameResult.STRIKE)
        );

        // then
        assertThat(gameResults.isSolved()).isTrue();
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