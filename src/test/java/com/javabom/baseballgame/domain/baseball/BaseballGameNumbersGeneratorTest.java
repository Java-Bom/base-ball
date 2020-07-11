package com.javabom.baseballgame.domain.baseball;

import com.javabom.baseballgame.domain.baseball.vo.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballGameNumbersGeneratorTest {

    @ParameterizedTest
    @DisplayName("입력한 숫자가 3개가 아닐 경우 예외.")
    @CsvSource(value = {"1,2,3,4", "1,2"})
    void generateNumbers(String input) {
        // TODO 테스트 코드도 비즈니스 로직에 맞게 작성. 행동 위주로, 너두 단위로 하머ㅕㄴ 안됨.
        List<Integer> numbers = Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        assertThatThrownBy(() -> BaseballGameNumbersGenerator.generateNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("입력한 숫자의 개수 : %d - 3개의 숫자 값을 입력하세요.", numbers.size()));
    }

    @Test
    @DisplayName("0~2의 순서를 가지는 랜덤한 BaseballGameNumbers객체를 생성하는지 확인.")
    public void generateRandomNumbers() {
        BaseballGameNumbers baseballGameNumbers = BaseballGameNumbersGenerator.generateRandomNumbers();
        Order orderFirst = Order.valueOf(0);
        Order orderSecond = Order.valueOf(1);
        Order orderThird = Order.valueOf(2);

        assertThat(baseballGameNumbers.getBaseballGameNumber(orderFirst).isOrder(orderFirst)).isTrue();
        assertThat(baseballGameNumbers.getBaseballGameNumber(orderSecond).isOrder(orderSecond)).isTrue();
        assertThat(baseballGameNumbers.getBaseballGameNumber(orderThird).isOrder(orderThird)).isTrue();
    }
}