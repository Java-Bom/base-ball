package com.javabom.baseballgame.domain.domain.valid;

import com.javabom.baseballgame.domain.domain.number.GameNumber;

import java.util.List;

public class GameNumbersValidator {

    public static final int SIZE = 3;

    public static void checkCount(final int size) {
        if (size != SIZE) {
            throw new IllegalArgumentException(String.format("%d, 숫자 게임에서 사용될 숫자의 갯수는 3개여야 합니다.", size));
        }
    }

    public static void checkDuplicate(final List<GameNumber> gameNumbers) {
        int size = getDeduplicationSize(gameNumbers);
        if (size != SIZE) {
            throw new IllegalArgumentException(String.format("중복을 제외한 숫자 갯수: %d, 숫자에 중복이 있습니다.", size));
        }
    }

    private static int getDeduplicationSize(final List<GameNumber> gameNumbers) {
        return (int) gameNumbers.stream()
                .distinct()
                .count();
    }
}
