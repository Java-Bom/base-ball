package com.javabom.baseballgame.domain;

import java.util.Objects;

public class Order {
    private final int value;

    public Order(final int value) {
        this.value = value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Order order = (Order) o;
        return value == order.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
