package com.javabom.baseballgame.domain.domain.number;

import com.javabom.baseballgame.domain.domain.utils.OrderGameNumberConverter;

import java.util.List;
import java.util.stream.Collectors;

public class ClientGameNumbers {
    public static final int GAME_NUMBERS_COUNT = 3;

    private final List<OrderGameNumber> clientGameNumbers;

    public ClientGameNumbers(final List<String> strClientGameNumbers) {
        List<GameNumber> clientGameNumbers = createGameNumbers(strClientGameNumbers);

        checkCount(clientGameNumbers.size());
        checkDuplicate(clientGameNumbers);
        this.clientGameNumbers = OrderGameNumberConverter.convertTo(clientGameNumbers);
    }

    private static void checkCount(final int size) {
        if (size != GAME_NUMBERS_COUNT) {
            throw new IllegalArgumentException(String.format("%d, 숫자 게임에서 사용될 숫자의 갯수는 3개여야 합니다.", size));
        }
    }

    private static void checkDuplicate(final List<GameNumber> gameNumbers) {
        int size = getDeduplicationSize(gameNumbers);
        if (size != GAME_NUMBERS_COUNT) {
            throw new IllegalArgumentException(String.format("중복을 제외한 숫자 갯수: %d, 숫자에 중복이 있습니다.", size));
        }
    }

    private static int getDeduplicationSize(final List<GameNumber> gameNumbers) {
        return (int) gameNumbers.stream()
                .distinct()
                .count();
    }

    private List<GameNumber> createGameNumbers(final List<String> strClientGameNumbers) {
        return strClientGameNumbers.stream()
                .map(GameNumber::of)
                .collect(Collectors.toList());
    }

    public boolean contains(final OrderGameNumber winningNumber) {
        return clientGameNumbers.contains(winningNumber);
    }

    public boolean containsOnlyGameNumber(OrderGameNumber winningNumber) {
        return clientGameNumbers.stream()
                .anyMatch(winningNumber::equalsOnlyGameNumber);
    }
}
