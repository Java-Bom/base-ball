package com.javabom.baseballgame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class IndexedBaseballNumberTest {

    @DisplayName("equalsOnlyNumber 메소드는 인덱스가 달라도 숫자가 같으면 true 반환")
    @Test
    void equalsOnlyNumber() {
        // given
        IndexedBaseballNumber index0Number = new IndexedBaseballNumber(0, BaseballNumber.of(1));
        IndexedBaseballNumber index2Number = new IndexedBaseballNumber(2, BaseballNumber.of(1));

        // then
        assertThat(index0Number.equalsOnlyNumber(index2Number)).isTrue();
    }

    static List<Arguments> indexedNumberArguments() {
        return Arrays.asList(
                Arguments.of(new IndexedBaseballNumber(0, BaseballNumber.of(0)), true),
                Arguments.of(new IndexedBaseballNumber(0, BaseballNumber.of(1)), false),
                Arguments.of(new IndexedBaseballNumber(1, BaseballNumber.of(0)), false)
        );
    }

    @DisplayName("equals 사용시 인덱스와 숫자가 모두 맞아야만 true 반환")
    @ParameterizedTest
    @MethodSource("indexedNumberArguments")
    void equals(IndexedBaseballNumber indexedBaseballNumber, boolean expectedResult) {
        // given
        IndexedBaseballNumber answerIndexedBaseballNumber = new IndexedBaseballNumber(0, BaseballNumber.of(0));

        // when
        boolean actualResult = answerIndexedBaseballNumber.equals(indexedBaseballNumber);

        // then
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}