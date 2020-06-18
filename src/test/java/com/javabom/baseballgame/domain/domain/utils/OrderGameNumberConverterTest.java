package com.javabom.baseballgame.domain.domain.utils;

import com.javabom.baseballgame.domain.domain.number.GameNumber;
import com.javabom.baseballgame.domain.domain.number.OrderGameNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderGameNumberConverterTest {

    @DisplayName("순서가 있는 게임 숫자를 반환한다.")
    @Test
    void covert() {
        //given
        List<GameNumber> gameNumbers = Arrays.asList(
                GameNumber.of(1),
                GameNumber.of(2),
                GameNumber.of(3));

        //when
        List<OrderGameNumber> orderGameNumbers = OrderGameNumberConverter.covert(gameNumbers);

        //then
        assertThat(orderGameNumbers.size()).isEqualTo(gameNumbers.size());
    }
}