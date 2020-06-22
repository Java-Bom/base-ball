package com.javabom.baseballgame.domain;

import java.util.Objects;

public class BaseballNumber {
    private final Order order;
    private final int value;

    public BaseballNumber(final Order order, final int value) {
        this.order = order;
        this.value = value;
    }

    public boolean equalsNumber(final BaseballNumber number) {
        return this.value == number.value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final BaseballNumber that = (BaseballNumber) o;
        return value == that.value &&
                Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, value);
    }

}
