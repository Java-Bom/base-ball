package com.javabom.baseballgame.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String USER_INPUT = "사용자 입력 : ";

    public static List<Integer> getUserNumbers() {
        print(USER_INPUT);
        return Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void print(String string) {
        System.out.print(string);
    }
}
