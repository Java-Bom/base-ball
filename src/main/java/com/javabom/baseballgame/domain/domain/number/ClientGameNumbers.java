package com.javabom.baseballgame.domain.domain.number;

import com.javabom.baseballgame.domain.domain.utils.OrderGameNumberConverter;
import com.javabom.baseballgame.domain.domain.valid.GameNumbersValidator;

import java.util.List;
import java.util.stream.Collectors;

public class ClientGameNumbers {

    private final List<OrderGameNumber> clientGameNumbers;

    public ClientGameNumbers(final List<String> strClientGameNumbers) {
        List<GameNumber> clientGameNumbers = createGameNumbers(strClientGameNumbers);

        GameNumbersValidator.checkCount(clientGameNumbers.size());
        GameNumbersValidator.checkDuplicate(clientGameNumbers);
        this.clientGameNumbers = OrderGameNumberConverter.convertTo(clientGameNumbers);
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
