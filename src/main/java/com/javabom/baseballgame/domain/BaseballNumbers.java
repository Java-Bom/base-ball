package com.javabom.baseballgame.domain;

import java.util.List;

public class BaseballNumbers {
    private static final int NUMBERS_PICK_SIZE = 3;
    private final List<BaseballNumber> numbers;

    public BaseballNumbers(final List<BaseballNumber> numbers) {
        this.numbers = numbers;
        validateNumbersSize();
    }

    private void validateNumbersSize() {
        if (numbers.size() != NUMBERS_PICK_SIZE) {
            throw new IllegalArgumentException(String.format("야구 숫자의 개수는 반드시 3개입니다. 입력 값 : %d", numbers.size()));
        }
    }

    // 비교하는 로직 작성할 것
}
