package com.javabom.baseballgame.domain.domain.game;

import com.javabom.baseballgame.domain.domain.number.ClientGameNumbers;
import com.javabom.baseballgame.domain.domain.number.GameNumber;
import com.javabom.baseballgame.domain.domain.number.WinningGameNumbers;
import com.javabom.baseballgame.domain.domain.result.MatchedResults;

import java.util.List;

public class BaseBallGame {
    private final WinningGameNumbers winningGameNumbers;

    public BaseBallGame(final GameNumbersGenerator gameNumbersGenerator) {
        List<GameNumber> gameNumbers = gameNumbersGenerator.generate();
        this.winningGameNumbers = new WinningGameNumbers(gameNumbers);
    }

    public MatchedResults getMatchedResults(List<String> strClientGameNumber) {
        return winningGameNumbers.getMatchedResults(new ClientGameNumbers(strClientGameNumber));
    }
}
