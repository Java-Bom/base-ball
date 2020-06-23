package com.javabom.baseballgame.rule;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public enum Rule {
    STRIKE(true),
    BALL(true),
    OUT(false);

    private final boolean match;

    Rule(final boolean match) {
        this.match = match;
    }

    public static Map<Rule, Integer> toMap(List<Rule> predicateResults) {
        Map<Rule, Integer> toMap = new EnumMap<>(Rule.class);

        for (Rule rule : values()) {
            int count = (int) predicateResults.stream()
                    .filter(result -> result.equals(rule))
                    .count();
            toMap.put(rule, count);
        }

        return toMap;
    }

    public boolean isMatch() {
        return match;
    }
}
