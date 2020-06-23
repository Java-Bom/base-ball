package com.javabom.baseballgame.view;

import com.javabom.baseballgame.game.PredicateResult;

import java.util.stream.Collectors;

public class OutputView {
    private static final String RESULT_DELIMITER = " ";

    public static void printAnswerBaseBallNumbers() {
        System.out.println("컴퓨터가 번호를 뽑았습니다.");
    }

    public static void printPredicateResult(PredicateResult predicateResult) {
        String resultString = predicateResult.getResultExcludeZeroValue()
                .entrySet().stream()
                .map(result -> String.format("%s%s", result.getValue(), result.getKey()))
                .collect(Collectors.joining(RESULT_DELIMITER));

        System.out.println(resultString);
    }

    public static void printLastTryNumber(int tryNumber) {
        System.out.println(String.format("최종 시도횟수 : %d회", tryNumber));
    }
}
