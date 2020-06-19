package com.javabom.baseballgame;

import com.javabom.baseballgame.domain.baseball.BaseballGameNumbersGenerator;
import com.javabom.baseballgame.domain.baseball.GameMachine;
import com.javabom.baseballgame.view.InputView;
import com.javabom.baseballgame.view.OutputView;

public class BaseballGameApplication {

    public static void main(String[] args) {
        InputView.startMessage();
        GameMachine gameMachine = new GameMachine(BaseballGameNumbersGenerator.generateRandomNumbers());

        while (!gameMachine.isFinish()) {
            gameMachine.addInputNumbers(BaseballGameNumbersGenerator.generateNumbers(InputView.askNumbers()));
            OutputView.printResult(gameMachine.getLastTryResult());
        }

        OutputView.printTryCount(gameMachine.getTryCount());
    }
}
