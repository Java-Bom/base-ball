package com.javabom.baseballgame.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallNumberTest {

    @DisplayName("BaseBallNumber 는 가지고 있는 숫자가 아닌 숫자의 위치 순서로 정렬된다.")
    @Test
    void compareWithBaseBallNumberPosition() {
        BaseBallNumber baseBallNumber1 = new BaseBallNumber(3, 2);
        BaseBallNumber baseBallNumber2 = new BaseBallNumber(2, 3);

        assertThat(baseBallNumber1.compareTo(baseBallNumber2)).isEqualTo(-1);
    }
}