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

    public void tryNextGame(final BaseballGameNumbers inputNumbers) {
        results.addResult(new TryResult(correctNumbers, inputNumbers));

        if (results.peek().isAllStrike()) {
            isFinish = true;
        }
    }

    public TryResult getLastTryResult() {
        return results.peek();
    }

    public int getTryCount() {
        return results.size();
    }
}
