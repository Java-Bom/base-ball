package com.javabom.baseballgame.domain;

import java.util.Objects;

public class OrderedBaseballNumber {
    private final Order order;
    private final BaseballNumber number;

    private OrderedBaseballNumber(final Order order, final BaseballNumber number) {
        this.order = order;
        this.number = number;
    }

    public static OrderedBaseballNumber of(final Order order, final BaseballNumber number) {
        return new OrderedBaseballNumber(order, number);
    }

    public boolean equalsNumber(final OrderedBaseballNumber orderedNumber) {
        return this.number == orderedNumber.number;
    }

    public Order getOrder() {
        return order;
    }

    public BaseballNumber getNumber() {
        return number;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final OrderedBaseballNumber that = (OrderedBaseballNumber) o;
        return number == that.number &&
                Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, number);
    }

}
