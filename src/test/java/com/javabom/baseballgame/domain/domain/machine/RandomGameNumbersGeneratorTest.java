package com.javabom.baseballgame.domain.domain.machine;

import com.javabom.baseballgame.domain.domain.number.GameNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGameNumbersGeneratorTest {

    @DisplayName("랜덤으로 게임 숫자를 뽑아 반환한다.")
    @Test
    void generate() {
        //given
        RandomGameNumbersGenerator randomGameNumbersGenerator = new RandomGameNumbersGenerator();
        List<GameNumber> orderGameNumbers = randomGameNumbersGenerator.generate();

        //then
        assertThat(orderGameNumbers.size()).isEqualTo(3);
    }
}
