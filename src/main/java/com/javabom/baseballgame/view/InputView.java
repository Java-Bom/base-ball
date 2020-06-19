package com.javabom.baseballgame.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static String DELIMITER = ",";

    public static void startMessage() {
        System.out.println("컴퓨터가 숫자를 뽑았습니다.");
    }

    public static List<Integer> askNumbers() {
        System.out.println();
        System.out.print("사용자 입력 : ");

        return Arrays.stream(SCANNER.nextLine().split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
