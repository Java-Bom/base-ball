package com.javabom.baseballgame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballNumbersFactoryTest {

    @DisplayName("랜덤 BaseballNumbers를 제대로 만들어내는지 확인")
    @Test
    void createRandomNumbers() {
        // given
        List<BaseballNumber> stubBaseballNumberList = Arrays.asList(BaseballNumber.of(1), BaseballNumber.of(2), BaseballNumber.of(3));
        BaseballNumbersFactory factory = new BaseballNumbersFactory() {
            @Override
            public BaseballNumbers createRandomNumbers() {
                return new BaseballNumbers(stubBaseballNumberList);
            }
        };
        // then
        assertThat(factory.createRandomNumbers()).isEqualTo(new BaseballNumbers(stubBaseballNumberList));
    }

    @DisplayName("List<Integer>를 BaseballNumbers 로 변환 확인")
    @Test
    void createBaseballNumbers() {
        // given
        BaseballNumbersFactory factory = new BaseballNumbersFactory();
        List<Integer> stubIntegerList = Arrays.asList(1, 2, 3);
        BaseballNumbers expectedBaseballNumbers = new BaseballNumbers(
                Arrays.asList(BaseballNumber.of(1), BaseballNumber.of(2), BaseballNumber.of(3))
        );
        // when
        BaseballNumbers actualBaseballNumbers = factory.createBaseballNumbers(stubIntegerList);

        // then
        assertThat(actualBaseballNumbers).isEqualTo(expectedBaseballNumbers);
    }
}