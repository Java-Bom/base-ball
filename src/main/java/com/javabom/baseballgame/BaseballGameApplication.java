package com.javabom.baseballgame;

import com.javabom.baseballgame.domain.BaseballGameMachine;
import com.javabom.baseballgame.domain.BaseballNumbersFactory;
import com.javabom.baseballgame.domain.GameResults;
import com.javabom.baseballgame.view.InputView;
import com.javabom.baseballgame.view.OutputView;

public class BaseballGameApplication {
    public static void main(String[] args) {
        BaseballGameMachine gameMachine = new BaseballGameMachine(new BaseballNumbersFactory());
        OutputView.printAnswerNumbersGenerated();

        while (!gameMachine.isSolved()) {
            GameResults gameResults = gameMachine.trySolve(InputView.getUserNumbers());
            OutputView.printGameResults(gameResults);
        }
        OutputView.printTryCount(gameMachine.getTryCount());
    }
}
