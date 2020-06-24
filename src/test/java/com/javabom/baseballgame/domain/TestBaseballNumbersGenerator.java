package com.javabom.baseballgame.domain;

import java.util.HashSet;
import java.util.Set;

public class TestBaseballNumbersGenerator implements BaseballNumbersGenerator {

    @Override
    public BaseballNumbers generate() {
        Set<OrderedBaseballNumber> numbers = new HashSet<>();
        numbers.add(OrderedBaseballNumber.of(Order.valueOf(1), BaseballNumber.of(1)));
        numbers.add(OrderedBaseballNumber.of(Order.valueOf(2), BaseballNumber.of(2)));
        numbers.add(OrderedBaseballNumber.of(Order.valueOf(3), BaseballNumber.of(3)));
        return new BaseballNumbers(numbers);
    }
}
