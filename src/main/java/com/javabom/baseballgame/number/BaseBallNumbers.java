package com.javabom.baseballgame.number;

import com.javabom.baseballgame.rule.Rule;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BaseBallNumbers {
    private static final int BASEBALL_NUMBER_SIZE = 3;
    private final List<BaseBallNumber> baseBallNumbers;

    private BaseBallNumbers(final List<BaseBallNumber> baseBallNumbers) {
        Collections.sort(baseBallNumbers);
        this.baseBallNumbers = baseBallNumbers;
    }

    public static BaseBallNumbers ofAuto(NumberGenerator numberGenerator) {
        List<BaseBallNumber> baseBallNumbers = BaseBallNumberGenerator.generateRandom(BASEBALL_NUMBER_SIZE, numberGenerator);

        validateSize(baseBallNumbers);

        return new BaseBallNumbers(baseBallNumbers);
    }

    public static BaseBallNumbers ofFixed(final List<Integer> numbers) {
        List<BaseBallNumber> baseBallNumbers = BaseBallNumberGenerator.generateFixed(numbers);

        validateSize(baseBallNumbers);

        return new BaseBallNumbers(baseBallNumbers);
    }

    //TODO: 0인 결과도 Map 으로 만들어 둬야하는지...?
    public Map<Rule, Integer> predicateBalls(BaseBallNumbers userTryBalls) {

//        Map<Rule, Integer> predicateResults = new EnumMap<>(Rule.class);

//        return userTryBalls.baseBallNumbers.stream()
//                .map(this::matchBalls)
//                .collect(toMap(Function.identity(), rule -> 1, Math::addExact, () -> new EnumMap<>(Rule.class)));

        List<Rule> predicateResults = userTryBalls.baseBallNumbers.stream()
                .map(this::matchBalls)
                .collect(Collectors.toList());

        return Rule.toMap(predicateResults);
    }

    private Rule matchBalls(BaseBallNumber userTryBall) {
        return baseBallNumbers.stream()
                .map(baseBallNumber -> baseBallNumber.match(userTryBall))
                .filter(Rule::isMatch)
                .findFirst()
                .orElse(Rule.OUT);
    }

    private static void validateSize(final List<BaseBallNumber> numbers) {
        if (numbers.size() != BASEBALL_NUMBER_SIZE) {
            throw new IllegalArgumentException("야구 숫자 갯수는 3개 이어야합니다.");
        }
    }
}
