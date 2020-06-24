package com.javabom.baseballgame.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomBaseballNumbersGenerator implements BaseballNumbersGenerator {
    private static final int COUNT = 3;
    private static final int START_BOUND = 0;
    private static final int END_BOUND = 9;

    private static final List<Integer> numbers;

    static {
        numbers = IntStream.rangeClosed(START_BOUND, END_BOUND).boxed()
                .collect(Collectors.toList());
    }

    @Override
    public BaseballNumbers generate() {
        Collections.shuffle(numbers);
        Set<OrderedBaseballNumber> orderedBaseballNumbers = new HashSet<>();
        for (int order = 1; order <= COUNT; order++) {
            BaseballNumber baseballNumber = BaseballNumber.of(numbers.get(order));
            OrderedBaseballNumber orderedNumber = OrderedBaseballNumber.of(Order.valueOf(order), baseballNumber);
            orderedBaseballNumbers.add(orderedNumber);
        }
        return new BaseballNumbers(orderedBaseballNumbers);
    }
}
