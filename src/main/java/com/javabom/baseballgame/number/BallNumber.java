package com.javabom.baseballgame.number;

import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

public class BallNumber {
    public static final int BALL_NUMBER_MIN = 0;
    public static final int BALL_NUMBER_MAX = 9;
    private final int number;

    private BallNumber(final int number) {
        this.number = number;
    }

    public static BallNumber valueOf(final int number) {
        validateBallNumberBound(number);
        return BallNumberCache.getBallNumber(number);
    }

    private static void validateBallNumberBound(final int number) {
        if (number < BALL_NUMBER_MIN || number > BALL_NUMBER_MAX) {
            throw new IllegalArgumentException("야구 숫자는 0 ~ 9 사이의 값이어야 합니다. - " + number);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof BallNumber)) return false;
        BallNumber that = (BallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    private static class BallNumberCache {
        private final static Map<Integer, BallNumber> cache;

        static {
            cache = IntStream.rangeClosed(BALL_NUMBER_MIN, BALL_NUMBER_MAX)
                    .boxed()
                    .collect(toMap(number -> number, BallNumber::new));
        }

        private static BallNumber getBallNumber(final int number) {
            return cache.get(number);
        }
    }
}
