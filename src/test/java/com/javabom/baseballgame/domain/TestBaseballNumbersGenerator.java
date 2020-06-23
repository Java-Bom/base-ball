package com.javabom.baseballgame.domain;

import java.util.HashSet;
import java.util.Set;

public class TestBaseballNumbersGenerator implements BaseballNumbersGenerator {

    @Override
    public BaseballNumbers generate() {
        Set<BaseballNumber> numbers = new HashSet<>();
        numbers.add(BaseballNumber.of(Order.valueOf(1), 1));
        numbers.add(BaseballNumber.of(Order.valueOf(2), 2));
        numbers.add(BaseballNumber.of(Order.valueOf(3), 3));
        return new BaseballNumbers(numbers);
    }
}
