package com.javabom.baseballgame.domain.domain.valid;

import com.javabom.baseballgame.domain.domain.number.GameNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameNumbersValidatorTest {

    @DisplayName("게임에 사용될 숫자의 갯수가 3이 아니면 IllegalArgumentException을 발생시킨다.")
    @Test
    void checkCount() {
        //given
        int size = 2;

        //then
        assertThatThrownBy(() -> GameNumbersValidator.checkCount(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%d, 숫자 게임에서 사용될 숫자의 갯수는 3개여야 합니다.", size));
    }

    @DisplayName("게임에 사용될 숫자에 중복이 있을 경우 IllegalArgumentException을 발생시킨다.")
    @Test
    void checkDuplicate() {
        //given
        List<GameNumber> gameNumbers = Arrays.asList(
                GameNumber.of("1"),
                GameNumber.of("1"),
                GameNumber.of("2"));

        //then
        assertThatThrownBy(() -> GameNumbersValidator.checkDuplicate(gameNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("중복을 제외한 숫자 갯수: %d, 숫자에 중복이 있습니다.", 2));
    }
}