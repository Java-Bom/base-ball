package com.javabom.baseballgame.number;

import java.util.List;

public class BaseBallNumbers {
    private static final int BASEBALL_NUMBER_SIZE = 3;
    private final List<BaseBallNumber> baseBallNumbers;

    private BaseBallNumbers(final List<BaseBallNumber> baseBallNumbers) {
        this.baseBallNumbers = baseBallNumbers;
    }

    public static BaseBallNumbers ofAuto(NumberGenerator numberGenerator) {
        List<BaseBallNumber> baseBallNumbers = BaseBallNumberGenerator.generateRandom(BASEBALL_NUMBER_SIZE, numberGenerator);

        validateSize(baseBallNumbers);

        return new BaseBallNumbers(baseBallNumbers);
    }

    public static BaseBallNumbers ofFixed(final List<Integer> numbers) {
        List<BaseBallNumber> baseBallNumbers = BaseBallNumberGenerator.generateFixed(numbers);

        validateSize(baseBallNumbers);

        return new BaseBallNumbers(baseBallNumbers);
    }

    private static void validateSize(final List<BaseBallNumber> numbers) {
        if (numbers.size() != BASEBALL_NUMBER_SIZE) {
            throw new IllegalArgumentException("야구 숫자 갯수는 3개 이어야합니다.");
        }
    }
}
