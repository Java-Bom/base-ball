package com.javabom.baseballgame.domain.domain.number;

import com.javabom.baseballgame.domain.domain.utils.OrderGameNumberConverter;
import com.javabom.baseballgame.domain.domain.valid.GameNumbersValidator;

import java.util.List;

public class ClientGameNumbers {

    private final List<OrderGameNumber> clientGameNumbers;

    public ClientGameNumbers(final List<GameNumber> clientGameNumbers) {
        GameNumbersValidator.checkCount(clientGameNumbers.size());
        GameNumbersValidator.checkDuplicate(clientGameNumbers);
        this.clientGameNumbers = OrderGameNumberConverter.covert(clientGameNumbers);
    }

    public boolean contains(final OrderGameNumber winningNumber) {
        return clientGameNumbers.contains(winningNumber);
    }

    public boolean hasNumber(OrderGameNumber winningNumber) {
        return clientGameNumbers.stream()
                .anyMatch(winningNumber::equalsOfNumber);
    }

    public int size() {
        return clientGameNumbers.size();
    }
}
