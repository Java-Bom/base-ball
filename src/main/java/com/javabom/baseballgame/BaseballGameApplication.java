package com.javabom.baseballgame;

import com.javabom.baseballgame.domain.BaseballGame;
import com.javabom.baseballgame.domain.BaseballNumbers;
import com.javabom.baseballgame.domain.RandomBaseballNumbersGenerator;
import com.javabom.baseballgame.view.InputView;
import com.javabom.baseballgame.view.OutputView;

public class BaseballGameApplication {

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(new RandomBaseballNumbersGenerator());
        OutputView.printSystemSettingMessage();

        boolean isRemaining = true;
        int tryCount = 0;
        while (isRemaining) {
            BaseballNumbers userNumbers = InputView.askUserNumbers();
            isRemaining = OutputView.printGameOutputs(baseballGame.calculate(userNumbers));
            tryCount += 1;
        }

        OutputView.printOf(tryCount);
    }
}
