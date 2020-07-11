package com.javabom.baseballgame.domain;

public class BaseballGame {
    private final BaseballNumbers systemNumbers;

    public BaseballGame(final BaseballNumbersGenerator numbersGenerator) {
        this.systemNumbers = numbersGenerator.generate();
    }

    public BaseballGameOutputs calculate(final BaseballNumbers numbers) {
        return systemNumbers.calculate(numbers);
    }
}
