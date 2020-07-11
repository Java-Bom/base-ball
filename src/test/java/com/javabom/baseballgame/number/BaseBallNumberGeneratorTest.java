package com.javabom.baseballgame.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseBallNumberGeneratorTest {

    private static Stream<Arguments> provideIntegersAndBaseBallNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(3, 2), Arrays.asList(
                        new BaseBallNumber(3, 1),
                        new BaseBallNumber(2, 2)
                )),
                Arguments.of(Arrays.asList(6, 5, 7), Arrays.asList(
                        new BaseBallNumber(6, 1),
                        new BaseBallNumber(5, 2),
                        new BaseBallNumber(7, 3)
                ))
        );
    }

    @DisplayName("랜덤한 숫자 리스트를 입력한 크기만큼 BaseBallNumber 리스트로 변환하여 반환한다.")
    @ParameterizedTest
    @MethodSource("provideIntegersAndBaseBallNumbers")
    void createRandomBaseBallNumbers(List<Integer> numbers, List<BaseBallNumber> baseBallNumbers) {
        NumberGenerator testNumberGenerator = (min, max) -> numbers;

        List<BaseBallNumber> actualResult = BaseBallNumberGenerator.generateRandom(numbers.size(), testNumberGenerator);

        assertThat(actualResult).isEqualTo(baseBallNumbers);
    }

    @DisplayName("인자로 받은 숫자 리스트를 BaseBallNumber 리스트로 변환하여 반환한다. ")
    @ParameterizedTest
    @MethodSource("provideIntegersAndBaseBallNumbers")
    void createFixedBaseBallNumbers(List<Integer> numbers, List<BaseBallNumber> baseBallNumbers) {
        List<BaseBallNumber> actualResult = BaseBallNumberGenerator.generateFixed(numbers);

        assertThat(actualResult).isEqualTo(baseBallNumbers);
    }

    @DisplayName("인자로 받은 숫자 리스트에 중복이 존재하면 IllegalArgumentsException throw")
    @Test
    void validateDuplicateFixedBaseBallNumbers() {
        List<Integer> wrongs = Arrays.asList(1, 2, 2);
        assertThatThrownBy(() -> BaseBallNumberGenerator.generateFixed(wrongs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("야구 숫자는 중복될 수 없습니다. - " + wrongs);
    }

    @DisplayName("랜덤으로 생성한 숫자 리스트에 중복이 존재하면 IllegalArgumentsException throw")
    @Test
    void validateDuplicatedAutoBaseBallNumbers() {
        NumberGenerator numberGenerator = (min, max) -> Arrays.asList(1, 1, 1, 1, 2, 2, 2);

        assertThatThrownBy(() -> BaseBallNumberGenerator.generateRandom(3, numberGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("야구 숫자는 중복될 수 없습니다. - " + Arrays.asList(1, 1, 1));
    }
}