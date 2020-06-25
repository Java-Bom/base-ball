package com.javabom.baseballgame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberTest {

    @DisplayName("숫자가 0이하 또는 9초과일 시 익셉션")
    @ValueSource(ints = {-1, 10})
    @ParameterizedTest
    void exception(int value) {
        assertThatThrownBy(() -> BaseballNumber.of(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("야구공 숫자는 0과 9사이고 캐시에서 꺼낸다")
    @ValueSource(ints = {0, 5, 9})
    @ParameterizedTest
    void success(int value) {
        //when
        BaseballNumber baseballNumber = BaseballNumber.of(value);

        //then
        assertThat(baseballNumber).isSameAs(BaseballNumber.of(value));
    }
}