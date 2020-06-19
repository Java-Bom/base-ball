package com.javabom.baseballgame.domain.baseball;

import com.javabom.baseballgame.domain.result.TryResult;
import com.javabom.baseballgame.domain.result.TryResults;

public class GameMachine {

    private final TryResults results = new TryResults();
    private final BaseballGameNumbers correctNumbers;
    private boolean isFinish;

    public GameMachine(final BaseballGameNumbers correctNumbers) {
        this.correctNumbers = correctNumbers;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void addInputNumbers(final BaseballGameNumbers inputNumbers) {
        TryResult tryResult = new TryResult(correctNumbers, inputNumbers);
        isFinish = tryResult.isAllStrike();
        results.addResult(tryResult);
    }

    public TryResult getLastTryResult() {
        return results.peek();
    }

    public int getTryCount() {
        return results.size();
    }
}
