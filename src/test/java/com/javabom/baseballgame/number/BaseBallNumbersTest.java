package com.javabom.baseballgame.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseBallNumbersTest {

    @DisplayName("입력한 숫자의 개수가 3개가 아니면 IllegalArgumentsException throw")
    @Test
    void validateFixedBaseBallNumbersSize() {
        List<Integer> wrongs = Arrays.asList(1, 2);
        assertThatThrownBy(() -> BaseBallNumbers.ofFixed(wrongs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("야구 숫자 갯수는 3개 이어야합니다.");
    }
}