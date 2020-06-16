package com.javabom.baseballgame.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @DisplayName("숫자의 위치를 1 ~ 3 이외의 숫자로 지정하려하면 IllegalArgumentException Throw")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 0, -1})
    void validatePositionBound(int position) {
        assertThatThrownBy(() -> Position.valueOf(position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자의 위치는 1 ~ 3 사이의 값이어야 합니다. - " + position);
    }

    @DisplayName("숫자야구 게임의 숫자의 위치 미리 만들어진 위치들을 캐싱하여 사용한다.")
    @Test
    void cachingPositions() {
        int position = 1;
        Position expectedResult = Position.valueOf(position);
        assertThat(expectedResult).isSameAs(Position.valueOf(1));
    }
}
