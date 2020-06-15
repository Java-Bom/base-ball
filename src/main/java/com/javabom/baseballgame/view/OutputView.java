package com.javabom.baseballgame.view;

import com.javabom.baseballgame.domain.GameResult;
import com.javabom.baseballgame.domain.GameResults;

import java.util.Arrays;
import java.util.stream.Collectors;

public class OutputView {
    private static final String ANSWER_NUMBERS_GENERATED = "컴퓨터가 숫자를 뽑았습니다.";
    private static final String TRY_COUNT = "최종 시도횟수 : %d회";

    public static void printAnswerNumbersGenerated() {
        println(ANSWER_NUMBERS_GENERATED);
    }

    public static void printGameResults(GameResults results) {
        String resultString = Arrays.stream(GameResult.values())
                .map(result -> stringOfGameResult(results, result))
                .filter(string -> !string.isEmpty())
                .collect(Collectors.joining(" "));
        println(resultString);
    }

    private static String stringOfGameResult(GameResults results, GameResult specificResult) {
        if (results.sizeOf(specificResult) == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(results.sizeOf(specificResult))
                .append(specificResult.name());
        return stringBuilder.toString();
    }

    public static void printTryCount(int tryCount) {
        println(String.format(TRY_COUNT, tryCount));
    }

    private static void println(String string) {
        System.out.println(string);
    }
}
