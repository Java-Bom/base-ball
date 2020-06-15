package com.javabom.baseballgame.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.javabom.baseballgame.domain.BaseballNumbers.NUMBERS_PICK_SIZE;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class BaseballNumbersFactory {
    private final List<BaseballNumber> numbers;

    public BaseballNumbersFactory() {
        this.numbers = IntStream.rangeClosed(BaseballNumber.MIN_NUMBER, BaseballNumber.MAX_NUMBER)
                .mapToObj(BaseballNumber::of)
                .collect(Collectors.toList());
    }

    public BaseballNumbers createRandomNumbers() {
        Collections.shuffle(numbers);
        List<BaseballNumber> pickedNumbers = numbers.subList(0, NUMBERS_PICK_SIZE);
        return new BaseballNumbers(Collections.unmodifiableList(pickedNumbers));
    }

    public BaseballNumbers createBaseballNumbers(List<Integer> inputNumbers) {
        return inputNumbers.stream()
                .map(BaseballNumber::of)
                .collect(collectingAndThen(toList(), BaseballNumbers::new));
    }
}
