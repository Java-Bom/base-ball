package com.javabom.baseballgame.domain.domain.machine;

import com.javabom.baseballgame.domain.domain.number.ClientGameNumbers;
import com.javabom.baseballgame.domain.domain.number.GameNumber;
import com.javabom.baseballgame.domain.domain.number.OrderGameNumber;
import com.javabom.baseballgame.domain.domain.number.WinningGameNumbers;

import java.util.List;
import java.util.stream.Collectors;

public class GameNumberMachine {
    private final GameNumbersGenerator gameNumbersGenerator;

    public GameNumberMachine(final GameNumbersGenerator gameNumbersGenerator) {
        this.gameNumbersGenerator = gameNumbersGenerator;
    }

    public WinningGameNumbers getWinningGameNumbers() {
        List<GameNumber> winningGameNumbers = gameNumbersGenerator.generate();
        return new WinningGameNumbers(winningGameNumbers);
    }

    public ClientGameNumbers getClientGameNumbers(List<String> strClientGameNumber) {
        List<GameNumber> clientGameNumber = strClientGameNumber.stream()
                .map(GameNumber::of)
                .collect(Collectors.toList());

        return new ClientGameNumbers(clientGameNumber);
    }
}
