package com.javabom.baseballgame.domain;

import com.javabom.baseballgame.domain.domain.machine.RandomGameNumbersGenerator;
import com.javabom.baseballgame.domain.domain.machine.GameNumberMachine;
import com.javabom.baseballgame.domain.domain.number.ClientGameNumbers;
import com.javabom.baseballgame.domain.domain.number.WinningGameNumbers;
import com.javabom.baseballgame.domain.domain.result.MatchedResults;
import com.javabom.baseballgame.domain.view.OutputView;
import com.javabom.baseballgame.domain.view.InputView;

public class BaseBallGameApplication {

    public static void main(String[] args) {

        GameNumberMachine gameNumberMachine = new GameNumberMachine(new RandomGameNumbersGenerator());
        WinningGameNumbers winningGameNumbers = gameNumberMachine.getWinningGameNumbers();
        OutputView.printPickedWinningNumbers();

        int tryCount = 0;
        boolean solved = false;
        while (!solved) {
            ClientGameNumbers clientGameNumbers = gameNumberMachine.getClientGameNumbers(InputView.inputGameNumbers());

            MatchedResults matchedResults = winningGameNumbers.getMatchedResults(clientGameNumbers);

            OutputView.printResult(matchedResults);

            solved = matchedResults.getSolvedStatus();
            tryCount++;
        }
        OutputView.printTryCount(tryCount);
    }
}
