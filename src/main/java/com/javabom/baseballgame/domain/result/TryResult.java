package com.javabom.baseballgame.domain.result;

import com.javabom.baseballgame.domain.baseball.BaseballGameNumbers;

import java.util.HashMap;
import java.util.Map;

public class TryResult {

    private final Map<MatchResult, Integer> result = new HashMap<>();

    public TryResult(final BaseballGameNumbers correctNumbers, final BaseballGameNumbers baseballGameNumbers) {
        for (MatchResult matchResult : MatchResult.values()) {
            result.put(matchResult, matchResult.getMatchCount(correctNumbers, baseballGameNumbers));
        }
    }

    public boolean isAllStrike() {
        if (result.isEmpty()) {
            return false;
        }

        return result.get(MatchResult.STRIKE) == BaseballGameNumbers.NUMBER_COUNT;
    }

    public int getMatchResultCount(MatchResult matchResult) {
        return result.get(matchResult);
    }

}
