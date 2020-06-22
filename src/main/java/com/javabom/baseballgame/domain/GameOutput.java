package com.javabom.baseballgame.domain;

public enum GameOutput {
    STRIKE, BALL, OUT;

    public static GameOutput compare(final BaseballNumber number1, final BaseballNumber number2) {
        if (number1.equals(number2)) {
            return STRIKE;
        }
        if (number1.equalsNumber(number2)) {
            return BALL;
        }
        return OUT;
    }
}
