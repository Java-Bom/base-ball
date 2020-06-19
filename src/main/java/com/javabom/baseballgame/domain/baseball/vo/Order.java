package com.javabom.baseballgame.domain.baseball.vo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Order {

    private final int value;
    public final static int ORDER_START = 0;
    public final static int ORDER_END = 2;

    private Order(final int value) {
        this.value = value;
    }

    public static Order valueOf(int order) {
        validOrder(order);
        return OrderCache.getOrder(order);
    }

    private static void validOrder(int order) {
        if (order < ORDER_START || order > ORDER_END) {
            throw new IllegalArgumentException(String.format("들어온 순서 : %d - %d~%d 사이의 순서만 허용됩니다.",
                    order, ORDER_START, ORDER_END));
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Order order = (Order) o;
        return getValue() == order.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    private static class OrderCache {
        private static final Map<Integer, Order> CACHE;

        static {
            CACHE = new HashMap<>();

            for (int order = ORDER_START; order <= ORDER_END; order++) {
                CACHE.put(order, new Order(order));
            }
        }

        private static Order getOrder(int order) {
            return CACHE.get(order);

        }
    }

}
