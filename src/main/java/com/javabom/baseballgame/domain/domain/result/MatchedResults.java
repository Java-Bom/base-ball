package com.javabom.baseballgame.domain.domain.result;

import com.javabom.baseballgame.domain.domain.valid.GameNumbersValidator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchedResults {
    private final Map<MatchedResult, Integer> matchedResults;

    public MatchedResults(final List<MatchedResult> matchedResultList) {
        checkCount(matchedResultList.size());
        this.matchedResults = collect(matchedResultList);
    }

    private void checkCount(final int size) {
        if (size != GameNumbersValidator.SIZE) {
            throw new IllegalArgumentException(String.format("%d, 게임 결과는 총 3개가 들어와야 합니다.", size));
        }
    }

    private Map<MatchedResult, Integer> collect(List<MatchedResult> matchedResultList) {
        Map<MatchedResult, Integer> matchedResults = new HashMap<>();
        for (MatchedResult matchedResult : matchedResultList) {
            matchedResults.put(matchedResult, findMatchedCount(matchedResults.get(matchedResult)));
        }
        return matchedResults;
    }

    private Integer findMatchedCount(final Integer currentMatchedCount) {
        if (currentMatchedCount == null) {
            return 1;
        }
        return currentMatchedCount + 1;
    }

    public boolean getSolvedStatus() {
        int matchedCount = getMatchedCountOf(MatchedResult.STRIKE);
        return matchedCount == GameNumbersValidator.SIZE;
    }

    public int getMatchedCountOf(MatchedResult matchedResult) {
        if (matchedResults.get(matchedResult) == null) {
            return 0;
        }
        return matchedResults.get(matchedResult);
    }

    public int size() {
        return matchedResults.size();
    }
}
