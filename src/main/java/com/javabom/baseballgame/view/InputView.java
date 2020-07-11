package com.javabom.baseballgame.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static List<Integer> inputUserTryNumbers() {
        System.out.print("사용자 입력 : ");
        String[] splits = SCANNER.nextLine().split(DELIMITER);

        return Arrays.stream(splits)
                .map(number -> Integer.valueOf(number.trim()))
                .collect(Collectors.toList());
    }
}
