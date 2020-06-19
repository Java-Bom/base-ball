package com.javabom.baseballgame.domain.baseball;

import com.javabom.baseballgame.domain.baseball.vo.BallNumber;
import com.javabom.baseballgame.domain.baseball.vo.Order;

import java.util.Objects;

public class BaseballGameNumber {

    private final BallNumber ballNumber;
    private final Order order;

    public BaseballGameNumber(final int ballNumber, final int order) {
        this.ballNumber = BallNumber.valueOf(ballNumber);
        this.order = Order.valueOf(order);
    }

    public boolean isSameBallNumber(final BaseballGameNumber otherBallNumber) {
        return ballNumber.equals(otherBallNumber.ballNumber);
    }

    public boolean isOrder(final Order order) {
        return this.order.equals(order);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final BaseballGameNumber that = (BaseballGameNumber) o;
        return Objects.equals(ballNumber, that.ballNumber) &&
                Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumber, order);
    }

}
