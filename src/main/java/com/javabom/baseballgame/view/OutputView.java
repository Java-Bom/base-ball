package com.javabom.baseballgame.view;

import com.javabom.baseballgame.domain.result.MatchResult;
import com.javabom.baseballgame.domain.result.TryResult;

public class OutputView {

    public static void printResult(TryResult matches) {
        int strikeCount = matches.getMatchResultCount(MatchResult.STRIKE);
        int ballCount = matches.getMatchResultCount(MatchResult.BALL);
        int outCount = matches.getMatchResultCount(MatchResult.OUT);

        if (strikeCount != 0) {
            System.out.print(String.format("%dSTRIKE ", strikeCount));
        }

        if (ballCount != 0) {
            System.out.print(String.format("%dBALL ", ballCount));
        }

        if (outCount != 0) {
            System.out.print(String.format("%dOUT ", outCount));
        }

        System.out.println();

    }

    public static void printTryCount(int tryCount) {
        System.out.println(String.format("최종 시도 횟수 : %d회", tryCount));
    }
}
