package com.javabom.baseballgame.domain;

import java.util.Objects;

public class Order {
    private static final int START_BOUND = 1;
    private static final int END_BOUND = 3;

    private final int value;

    private Order(final int value) {
        this.value = value;
    }

    public static Order valueOf(final int value) {
        if (value < START_BOUND || value > END_BOUND) {
            throw new IllegalArgumentException(String.format("Order는 1-3 사이여야한다. 현재: %d", value));
        }
        return OrderCache.cache[value];
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

    private static class OrderCache {
        static final Order[] cache;

        static {
            cache = new Order[END_BOUND + 1];

            for (int i = 1; i <= END_BOUND; i++) {
                cache[i] = new Order(i);
            }
        }

        private OrderCache() {
        }
    }


}
