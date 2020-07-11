package com.javabom.baseballgame.domain.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PICKED_CLIENT = "사용자 입력 : ";

    private static final String DELIMITER = ",";

    public static List<String> inputGameNumbers() {
        System.out.print(PICKED_CLIENT);
        return Arrays.asList(SCANNER.nextLine().split(DELIMITER));
    }
}
