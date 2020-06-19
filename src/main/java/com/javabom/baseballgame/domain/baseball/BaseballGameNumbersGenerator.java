package com.javabom.baseballgame.domain.baseball;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.javabom.baseballgame.domain.baseball.vo.BallNumber.NUMBER_END;
import static com.javabom.baseballgame.domain.baseball.vo.BallNumber.NUMBER_START;

public class BaseballGameNumbersGenerator {

    private static final List<Integer> ballNumbers;

    static  {
        ballNumbers = IntStream.rangeClosed(NUMBER_START, NUMBER_END)
                .boxed()
                .collect(Collectors.toList());
    }

    public static BaseballGameNumbers generateRandomNumbers() {
        Collections.shuffle(ballNumbers);
        List<BaseballGameNumber> baseballGameNumbers = IntStream.range(0, BaseballGameNumbers.NUMBER_COUNT)
                .mapToObj(order -> new BaseballGameNumber(ballNumbers.get(order), order))
                .collect(Collectors.toList());
        return new BaseballGameNumbers(baseballGameNumbers);
    }

    public static BaseballGameNumbers generateNumbers(List<Integer> inputNumbers) {
        validBallNumbersCount(inputNumbers);
        List<BaseballGameNumber> baseballGameNumbers = IntStream.range(0, BaseballGameNumbers.NUMBER_COUNT)
                .mapToObj(order -> new BaseballGameNumber(inputNumbers.get(order), order))
                .collect(Collectors.toList());
        return new BaseballGameNumbers(baseballGameNumbers);
    }

    private static void validBallNumbersCount(final List<Integer> inputNumbers) {
        if (inputNumbers.size() != BaseballGameNumbers.NUMBER_COUNT) {
            throw new IllegalArgumentException(
                    String.format("입력한 숫자의 개수 : %d - 3개의 숫자 값을 입력하세요.", inputNumbers.size()));
        }
    }
}
