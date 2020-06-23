package com.javabom.baseballgame.domain;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class BaseballGame {
    private final BaseballNumbers systemNumbers;

    public BaseballGame(final BaseballNumbersGenerator numbersGenerator) {
        this.systemNumbers = numbersGenerator.generate();
    }


    public BaseballGameOutputs calculate(final BaseballNumbers numbers) {
        return numbers.getValues().stream()
                .map(systemNumbers::calculate)
                .collect(Collectors.collectingAndThen(toList(), BaseballGameOutputs::new));
    }
}
