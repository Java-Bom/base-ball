package com.javabom.baseballgame.number;

import java.util.ArrayList;
import java.util.List;

import static com.javabom.baseballgame.number.BallNumber.BALL_NUMBER_MAX;
import static com.javabom.baseballgame.number.BallNumber.BALL_NUMBER_MIN;

public class BaseBallNumberGenerator {

    public static List<BaseBallNumber> generateRandom(final int size, NumberGenerator numberGenerator) {
        List<Integer> shuffledNumbers = numberGenerator.generateRangeClosed(BALL_NUMBER_MIN, BALL_NUMBER_MAX);

        return convertTo(shuffledNumbers.subList(0, size));
    }

    public static List<BaseBallNumber> generateFixed(final List<Integer> numbers) {
        return convertTo(numbers);
    }

    private static List<BaseBallNumber> convertTo(final List<Integer> numbers) {
        List<BaseBallNumber> baseBallNumbers = new ArrayList<>();

        for (int index = 0; index < numbers.size(); index++) {
            baseBallNumbers.add(new BaseBallNumber(numbers.get(index), index + 1));
        }

        return baseBallNumbers;
    }
}
