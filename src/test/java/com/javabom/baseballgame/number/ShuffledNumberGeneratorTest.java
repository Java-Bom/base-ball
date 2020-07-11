package com.javabom.baseballgame.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ShuffledNumberGeneratorTest {

    @DisplayName("인자로 받은 최솟값과 최댓값 사이의 숫자 리스트를 생성하고 순서를 바꿔서 반환한다.")
    @ParameterizedTest
    @CsvSource({"1, 4", "2, 7", "3, 4"})
    void generateRangeClosedShuffledList(int min, int max) {
        NumberGenerator shuffledNumberGenerator = new ShuffledNumberGenerator();
        List<Integer> shuffledNumbers = shuffledNumberGenerator.generateRangeClosed(min, max);

        assertThat(shuffledNumbers).contains(min, max);
    }
}