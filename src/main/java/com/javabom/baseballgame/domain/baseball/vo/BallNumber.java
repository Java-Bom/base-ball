package com.javabom.baseballgame.domain.baseball.vo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BallNumber {

    private final int value;
    public static final int NUMBER_START = 0;
    public static final int NUMBER_END = 9;

    private BallNumber(final int value) {
        this.value = value;
    }

    public static BallNumber valueOf(int number) {
        validNumber(number);
        return BallNumberCache.getNumber(number);
    }

    private static void validNumber(final int number) {
        if (number < NUMBER_START || number > NUMBER_END) {
            throw new IllegalArgumentException(String.format("입력한 숫자 : %d - %d~%d 사이의 숫자만 허용됩니다.",
                    number, NUMBER_START, NUMBER_END));
        }
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final BallNumber ballNumber = (BallNumber) o;
        return value == ballNumber.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private static class BallNumberCache {
        private static final Map<Integer, BallNumber> CACHE;

        static {
            CACHE = new HashMap<>();

            for (int number = NUMBER_START; number <= NUMBER_END; number++) {
                CACHE.put(number, new BallNumber(number));
            }
        }

        public static BallNumber getNumber(int number) {
            return CACHE.get(number);
        }
    }
}
