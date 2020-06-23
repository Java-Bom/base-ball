package com.javabom.baseballgame.domain;

import java.util.Collections;
import java.util.Set;

import static com.javabom.baseballgame.domain.GameOutput.*;

public class BaseballNumbers {
    private static final int COUNT = 3;
    private final Set<BaseballNumber> values;

    public BaseballNumbers(final Set<BaseballNumber> values) {
        this.values = values;
        if (values.size() != COUNT) {
            throw new IllegalArgumentException(
                    String.format("야구게임은 %d개의 숫자로 이루어져야합니다. 현재: %d 개", COUNT, values.size())
            );
        }
    }

    public GameOutput calculate(final BaseballNumber number) {
        return values.stream()
                .filter(baseballNumber -> baseballNumber.equalsNumber(number))
                .findFirst()
                .map(baseballNumber -> baseballNumber.equals(number) ? STRIKE : BALL)
                .orElse(OUT);

    }

    public Set<BaseballNumber> getValues() {
        return Collections.unmodifiableSet(values);
    }
}
