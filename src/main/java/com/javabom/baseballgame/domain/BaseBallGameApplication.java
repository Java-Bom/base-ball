package com.javabom.baseballgame.domain;

import com.javabom.baseballgame.domain.domain.game.RandomGameNumbersGenerator;
import com.javabom.baseballgame.domain.domain.game.BaseBallGame;
import com.javabom.baseballgame.domain.domain.result.MatchedResults;
import com.javabom.baseballgame.domain.view.OutputView;
import com.javabom.baseballgame.domain.view.InputView;

public class BaseBallGameApplication {

    public static void main(String[] args) {

        BaseBallGame baseBallGame = new BaseBallGame(new RandomGameNumbersGenerator());
        OutputView.printPickedWinningNumbers();

        int tryCount = 0;
        boolean solvedStatus = false;
        while (!solvedStatus) {
            MatchedResults matchedResults = baseBallGame.getMatchedResults(InputView.inputGameNumbers());

            tryCount++;
            solvedStatus = matchedResults.getSolvedStatus();
            OutputView.printResult(matchedResults);
        }
        OutputView.printTryCount(tryCount);
    }
}
