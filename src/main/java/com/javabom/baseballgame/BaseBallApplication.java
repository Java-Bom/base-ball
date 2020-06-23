package com.javabom.baseballgame;

import com.javabom.baseballgame.game.BaseBallGame;
import com.javabom.baseballgame.game.PredicateResult;
import com.javabom.baseballgame.number.ShuffledNumberGenerator;
import com.javabom.baseballgame.view.InputView;
import com.javabom.baseballgame.view.OutputView;

public class BaseBallApplication {
    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame(new ShuffledNumberGenerator());

        OutputView.printAnswerBaseBallNumbers();

        int tryNumber = 1;

        while (true) {
            PredicateResult predicateResult = baseBallGame.tryToPredicate(InputView.inputUserTryNumbers(), tryNumber++);
            OutputView.printPredicateResult(predicateResult);

            if (predicateResult.isAnswer()) {
                OutputView.printLastTryNumber(predicateResult.getTryNumber());
                break;
            }
        }
    }
}
