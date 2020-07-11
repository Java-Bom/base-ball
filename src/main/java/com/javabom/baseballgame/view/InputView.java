package com.javabom.baseballgame.view;

import com.javabom.baseballgame.domain.BaseballNumber;
import com.javabom.baseballgame.domain.BaseballNumbers;
import com.javabom.baseballgame.domain.Order;
import com.javabom.baseballgame.domain.OrderedBaseballNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toSet;

public class InputView {
    private static final String DELIMITER = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static BaseballNumbers askUserNumbers() {
        System.out.print("사용자 입력 : \t");
        List<Integer> inputNumbers = Arrays.stream(SCANNER.next().split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return IntStream.rangeClosed(1, 3)
                .mapToObj(order -> OrderedBaseballNumber.of(
                        Order.valueOf(order), BaseballNumber.of(inputNumbers.get(order - 1)))
                )
                .collect(collectingAndThen(toSet(), BaseballNumbers::new));
    }
}
