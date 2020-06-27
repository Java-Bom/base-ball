package com.javabom.baseballgame.domain.domain.result;

import com.javabom.baseballgame.domain.domain.valid.GameNumbersValidator;

import java.util.EnumMap;
import java.util.List;

public class MatchedResults {
    private final EnumMap<MatchedResult, Integer> matchedResults;

    public MatchedResults(final List<MatchedResult> matchedResultList) {
        checkCount(matchedResultList.size());
        this.matchedResults = createMatchedResults(matchedResultList);
    }

    private void checkCount(final int size) {
        if (size != GameNumbersValidator.SIZE) {
            throw new IllegalArgumentException(String.format("%d, 게임 결과는 총 3개가 들어와야 합니다.", size));
        }
    }

    private EnumMap<MatchedResult, Integer> createMatchedResults(List<MatchedResult> matchedResultList) {
        EnumMap<MatchedResult, Integer> matchedResults = new EnumMap<>(MatchedResult.class);
        for (MatchedResult matchedResult : matchedResultList) {
            matchedResults.put(matchedResult, matchedResults.getOrDefault(matchedResult, 0) + 1);
        }
        return matchedResults;
    }

    public boolean getSolvedStatus() {
        return getMatchedCountOf(MatchedResult.STRIKE) == GameNumbersValidator.SIZE;
    }

    public int getMatchedCountOf(MatchedResult matchedResult) {
        return matchedResults.getOrDefault(matchedResult, 0);
    }
}
