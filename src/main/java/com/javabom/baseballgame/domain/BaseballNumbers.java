package com.javabom.baseballgame.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.javabom.baseballgame.domain.GameOutput.*;
import static java.util.stream.Collectors.toList;

public class BaseballNumbers {
    public static final int COUNT = 3;
    private final Set<OrderedBaseballNumber> values;

    public BaseballNumbers(final Set<OrderedBaseballNumber> values) {
        this.values = values;
        if (this.values.size() != COUNT) {
            throw new IllegalArgumentException(
                    String.format("야구게임은 %d개의 숫자로 이루어져야합니다. 현재: %d 개", COUNT, values.size())
            );
        }
        if (isDuplicate(values)) {
            throw new IllegalArgumentException("숫자와 순서는 중복될 수 없습니다");
        }
    }

    public static BaseballNumbers of(final List<BaseballNumber> randomNumbers) {
        Set<OrderedBaseballNumber> orderedBaseballNumbers = new HashSet<>();
        for (int order = 1; order <= COUNT; order++) {
            BaseballNumber baseballNumber = randomNumbers.get(order - 1);
            OrderedBaseballNumber orderedNumber = OrderedBaseballNumber.of(Order.valueOf(order), baseballNumber);
            orderedBaseballNumbers.add(orderedNumber);
        }
        return new BaseballNumbers(orderedBaseballNumbers);
    }

    private boolean isDuplicate(final Set<OrderedBaseballNumber> values) {
        int uniqueNumber = Math.toIntExact(values.stream()
                .map(OrderedBaseballNumber::getNumber)
                .distinct()
                .count());

        int uniqueOrder = Math.toIntExact(values.stream()
                .map(OrderedBaseballNumber::getOrder)
                .distinct()
                .count());

        return uniqueNumber < COUNT || uniqueOrder < COUNT;
    }

    public BaseballGameOutputs calculate(final BaseballNumbers baseballNumbers) {
        return baseballNumbers.values.stream()
                .map(this::calculate)
                .collect(Collectors.collectingAndThen(toList(), BaseballGameOutputs::new));

    }

    private GameOutput calculate(final OrderedBaseballNumber number) {
        return values.stream()
                .filter(baseballNumber -> baseballNumber.equalsNumber(number))
                .findFirst()
                .map(baseballNumber -> baseballNumber.equals(number) ? STRIKE : BALL)
                .orElse(OUT);

    }

    public Set<OrderedBaseballNumber> getValues() {
        return Collections.unmodifiableSet(values);
    }
}
