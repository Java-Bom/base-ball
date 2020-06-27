package com.javabom.baseballgame.domain.domain.number;

import java.util.*;

public class GameNumber {
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;

    private final int gameNumber;

    private GameNumber(final int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public static GameNumber of(final int number) {
        checkRange(number);
        return GameNumberCache.CACHE.get(number);
    }

    public static GameNumber of(final String number) {
        return GameNumber.of(Integer.parseInt(number));
    }

    private static void checkRange(int gameNumber) {
        if (isNotRange(gameNumber)) {
            throw new IllegalArgumentException(String.format("%d, 숫자 게임에 사용되는 숫자는 0-9입니다.", gameNumber));
        }
    }

    private static boolean isNotRange(int gameNumber) {
        return !isRange(gameNumber);
    }

    private static boolean isRange(int gameNumber) {
        return gameNumber >= MIN_NUMBER && gameNumber <= MAX_NUMBER;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof GameNumber)) return false;
        final GameNumber that = (GameNumber) o;
        return gameNumber == that.gameNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameNumber);
    }

    private static class GameNumberCache {
        static final Map<Integer, GameNumber> CACHE;

        static {
            CACHE = new HashMap<>();

            for (int number = MIN_NUMBER; number <= MAX_NUMBER; number++) {
                CACHE.put(number, new GameNumber(number));
            }
        }
    }
}
