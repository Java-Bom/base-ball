package com.javabom.baseballgame.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.javabom.baseballgame.domain.BaseballNumbers.NUMBERS_PICK_SIZE;

public class RandomBaseballNumbersGenerator {
    private final List<BaseballNumber> numbers;

    public RandomBaseballNumbersGenerator() {
        this.numbers = IntStream.rangeClosed(BaseballNumber.MIN_NUMBER, BaseballNumber.MAX_NUMBER)
                .mapToObj(BaseballNumber::of)
                .collect(Collectors.toList());
    }

    public BaseballNumbers create() {
        Collections.shuffle(numbers);
        List<BaseballNumber> pickedNumbers = numbers.subList(0, NUMBERS_PICK_SIZE);
        return new BaseballNumbers(Collections.unmodifiableList(pickedNumbers));
    }
}
