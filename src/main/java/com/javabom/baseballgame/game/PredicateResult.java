package com.javabom.baseballgame.game;

import com.javabom.baseballgame.rule.Rule;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class PredicateResult {
    private static final int STRIKE_COUNT = 3;

    private final int tryNumber;
    private final Map<Rule, Integer> predicateResults;

    public PredicateResult(final int tryNumber, final Map<Rule, Integer> predicateResults) {
        this.tryNumber = tryNumber;
        this.predicateResults = predicateResults;
    }

    public Map<Rule, Integer> getResultExcludeZeroValue() {
        return predicateResults.entrySet().stream()
                .filter(predicateResult -> predicateResult.getValue() != 0)
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public int getTryNumber() {
        return tryNumber;
    }

    public boolean isAnswer() {
        return predicateResults.get(Rule.STRIKE) == STRIKE_COUNT;
    }
}
