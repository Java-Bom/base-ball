package com.javabom.baseballgame.domain.domain.result;

public enum MatchedResult {
    STRIKE, BALL, OUT;

    public static MatchedResult findResult(final boolean allMatchStatus, final boolean anyMatchStatus) {
        if (allMatchStatus) {
            return STRIKE;
        }
        return findAny(anyMatchStatus);
    }

    private static MatchedResult findAny(final boolean anyMatchStatus) {
        if (anyMatchStatus) {
            return BALL;
        }
        return OUT;
    }
}
