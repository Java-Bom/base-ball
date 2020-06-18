package com.javabom.baseballgame.domain.domain.number;

import java.util.Objects;

public class OrderGameNumber {

    private final int order;
    private final GameNumber gameNumber;

    public OrderGameNumber(final int order, final GameNumber gameNumber) {
        this.order = order;
        this.gameNumber = gameNumber;
    }

    public static OrderGameNumber of(final int order, final GameNumber number) {
        return new OrderGameNumber(order, number);
    }

    public boolean equalsOfNumber(final OrderGameNumber orderGameNumber) {
        return this.gameNumber == orderGameNumber.gameNumber;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderGameNumber)) return false;
        final OrderGameNumber that = (OrderGameNumber) o;
        return order == that.order &&
                Objects.equals(gameNumber, that.gameNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, gameNumber);
    }
}
