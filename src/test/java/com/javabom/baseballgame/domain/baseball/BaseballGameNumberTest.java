package com.javabom.baseballgame.domain.baseball;

import com.javabom.baseballgame.domain.baseball.vo.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameNumberTest {

    @Test
    @DisplayName("입력된 BaseballGameNumber와 BallNumber가 같은지 확인.")
    void isSameBallNumberTest() {
        BaseballGameNumber baseballGameNumber = new BaseballGameNumber(0, 0);
        BaseballGameNumber sameNumber = new BaseballGameNumber(0, 1);
        BaseballGameNumber otherNumber = new BaseballGameNumber(1, 1);
        assertThat(baseballGameNumber.isSameBallNumber(sameNumber)).isTrue();
        assertThat(baseballGameNumber.isSameBallNumber(otherNumber)).isFalse();
    }

    @Test
    @DisplayName("BaseballGameNumber의 Order값 확인.")
    void isOrderTest() {
        BaseballGameNumber baseballGameNumber = new BaseballGameNumber(0, 0);
        assertThat(baseballGameNumber.isOrder(Order.valueOf(0))).isTrue();
        assertThat(baseballGameNumber.isOrder(Order.valueOf(1))).isFalse();
    }

}