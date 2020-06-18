package com.javabom.baseballgame.domain.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ClientGameNumbersTest {

    @DisplayName("들어온 숫자의 순서와 숫자 둘 같으면 true, 하나라도 다르면 false를 반환한다.")
    @ParameterizedTest
    @CsvSource({"0,1,true", "1,1,false", "0,3,false"})
    void contains(int order, int number, boolean expected) {
        //given
        List<GameNumber> gameNumbers = Arrays.asList(
                GameNumber.of(1),
                GameNumber.of(3),
                GameNumber.of(5));
        ClientGameNumbers clientGameNumbers = new ClientGameNumbers(gameNumbers);

        OrderGameNumber orderGameNumber = OrderGameNumber.of(order, GameNumber.of(number));

        //when
        boolean actual = clientGameNumbers.contains(orderGameNumber);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("들어온 숫자의 순서에 상관없이 숫자만 같은게 하나라도 있으면 true, 하나도 없으면 false를 반환한다.")
    @ParameterizedTest
    @CsvSource({"1,1,true", "0,1,true", "0,2,false"})
    void hasNumber(int order, int number, boolean expected) {
        //given
        List<GameNumber> gameNumbers = Arrays.asList(
                GameNumber.of(1),
                GameNumber.of(3),
                GameNumber.of(5));
        ClientGameNumbers clientGameNumbers = new ClientGameNumbers(gameNumbers);

        OrderGameNumber orderGameNumber = OrderGameNumber.of(order, GameNumber.of(number));

        //when
        boolean actual = clientGameNumbers.hasNumber(orderGameNumber);

        //then
        assertThat(actual).isEqualTo(expected);
    }
}