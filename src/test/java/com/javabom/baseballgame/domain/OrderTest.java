package com.javabom.baseballgame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {

    @DisplayName("Order 캐싱 테스트")
    @ValueSource(ints = {1, 2, 3})
    @ParameterizedTest
    void orderCache(int value) {
        assertThat(Order.valueOf(value)).isSameAs(Order.valueOf(value));
    }
}