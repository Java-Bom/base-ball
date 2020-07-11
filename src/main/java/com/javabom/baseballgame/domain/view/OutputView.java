package com.javabom.baseballgame.domain.view;

import com.javabom.baseballgame.domain.domain.result.MatchedResult;
import com.javabom.baseballgame.domain.domain.result.MatchedResults;

public class OutputView {

    private static final String PICKED_WINNING_NUMBER = "컴퓨터가 숫자를 뽑았습니다.";

    public static void printPickedWinningNumbers() {
        System.out.println(PICKED_WINNING_NUMBER);
    }

    public static void printResult(MatchedResults matchedResults) {
        for (MatchedResult matchedResult : MatchedResult.values()) {
            if (matchedResults.getMatchedCountOf(matchedResult) != 0) {
                int matchedCount = matchedResults.getMatchedCountOf(matchedResult);
                System.out.print(String.format("%d%s ", matchedCount, matchedResult));
            }
        }
        System.out.println();
    }

    public static void printTryCount(final int tryCount) {
        System.out.println(String.format("최종 시도횟수 : %d회", tryCount));
    }
}
