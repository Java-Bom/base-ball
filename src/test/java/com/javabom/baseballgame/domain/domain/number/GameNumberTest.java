package com.javabom.baseballgame.domain.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameNumberTest {

    @DisplayName("게임 숫자의 범위가 0-9가 아니면 IllegalArgumentException을 발생시킨다.")
    @Test
    void checkRange(){
        //given
        int gameNumber = -1;

        //then
        assertThatThrownBy(() -> GameNumber.of(gameNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%d, 숫자 게임에 사용되는 숫자는 0-9입니다.", gameNumber));
    }
}
