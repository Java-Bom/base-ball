package com.javabom.baseballgame.domain;

public class BaseballNumber {
    private final int value;

    private BaseballNumber(final int value) {
        this.value = value;
    }

    public static BaseballNumber of(final int number) {
        validateBaseballNumberRange(number);
        return BaseballNumberCache.CACHE[number];
    }

    private static void validateBaseballNumberRange(final int number) {
        if (number < BaseballNumberCache.MIN_NUMBER || number > BaseballNumberCache.MAX_NUMBER) {
            throw new IllegalArgumentException(String.format("야구 숫자는 0 ~ 9 사이입니다. 입력 값 : %d", number));
        }
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    private static class BaseballNumberCache {
        private static final BaseballNumber[] CACHE;
        private static final int MIN_NUMBER = 0;
        private static final int MAX_NUMBER = 9;

        private BaseballNumberCache() {
        }

        static {
            CACHE = new BaseballNumber[MAX_NUMBER + 1];
            for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
                CACHE[i] = new BaseballNumber(i);
            }
        }
    }
}
