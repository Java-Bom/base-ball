package com.javabom.baseballgame.domain;

import java.util.List;

public class BaseballGameMachine {
    private int tryCount = 0;
    private boolean isSolved = false;
    private final BaseballNumbers answerNumbers;
    private final BaseballNumbersFactory numbersFactory;

    public BaseballGameMachine(BaseballNumbersFactory numbersFactory) {
        this.numbersFactory = numbersFactory;
        this.answerNumbers = numbersFactory.createRandomNumbers();
    }

    public GameResults trySolve(List<Integer> inputNumbers) {
        BaseballNumbers numbers = numbersFactory.createBaseballNumbers(inputNumbers);
        GameResults results = answerNumbers.compare(numbers);
        if (results.isSolved()) {
            isSolved = true;
        }
        tryCount++;
        return results;
    }

    public int getTryCount() {
        return tryCount;
    }

    public boolean isSolved() {
        return isSolved;
    }
}
