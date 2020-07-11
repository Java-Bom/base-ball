package com.javabom.baseballgame.domain.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ClientGameNumbersTest {

    @DisplayName("게임에 사용될 숫자의 갯수가 3이 아니면 IllegalArgumentException을 발생시킨다.")
    @Test
    void checkCount() {
        //given
        List<String> strClientGameNumber = Arrays.asList("1", "2");

        //then
        assertThatThrownBy(() -> new ClientGameNumbers(strClientGameNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%d, 숫자 게임에서 사용될 숫자의 갯수는 3개여야 합니다.", strClientGameNumber.size()));
    }

    @DisplayName("게임에 사용될 숫자에 중복이 있을 경우 IllegalArgumentException을 발생시킨다.")
    @Test
    void checkDuplicate() {
        //given
        List<String> strClientGameNumber = Arrays.asList("1", "2", "2");

        //then
        assertThatThrownBy(() -> new ClientGameNumbers(strClientGameNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("중복을 제외한 숫자 갯수: %d, 숫자에 중복이 있습니다.", 2));
    }

    @DisplayName("들어온 숫자의 순서와 숫자 둘 같으면 true, 하나라도 다르면 false를 반환한다.")
    @ParameterizedTest
    @CsvSource({"0,1,true", "1,1,false", "0,3,false"})
    void contains(int order, int number, boolean expected) {
        //given
        List<String> gameNumbers = Arrays.asList("1", "2", "3");
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
    void containsOnlyGameNumber(int order, int number, boolean expected) {
        //given
        List<String> gameNumbers = Arrays.asList("1", "3", "5");
        ClientGameNumbers clientGameNumbers = new ClientGameNumbers(gameNumbers);

        OrderGameNumber orderGameNumber = OrderGameNumber.of(order, GameNumber.of(number));

        //when
        boolean actual = clientGameNumbers.containsOnlyGameNumber(orderGameNumber);

        //then
        assertThat(actual).isEqualTo(expected);
    }
}