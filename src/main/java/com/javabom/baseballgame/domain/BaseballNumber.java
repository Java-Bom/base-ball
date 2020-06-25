package com.javabom.baseballgame.domain;

public class BaseballNumber {
    public static final int START_BOUND = 0;
    public static final int END_BOUND = 9;

    private final int number;

    private BaseballNumber(final int number) {
        this.number = number;
    }

    public static BaseballNumber of(final int number) {
        if (number < START_BOUND || number > END_BOUND) {
            throw new IllegalArgumentException(String.format("야구공 숫자범위는 0-9 사이여야한다. 현재 %d", number));
        }
        return BaseballNumberCache.cache[number];
    }

    private static class BaseballNumberCache {
        static final BaseballNumber[] cache;

        static {
            cache = new BaseballNumber[END_BOUND + 1];

            for (int i = 0; i <= END_BOUND; i++) {
                cache[i] = new BaseballNumber(i);
            }
        }

        private BaseballNumberCache() {
        }
    }
}
