package com.javabom.baseballgame.domain;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.javabom.baseballgame.domain.BaseballNumber.END_BOUND;
import static com.javabom.baseballgame.domain.BaseballNumber.START_BOUND;
import static com.javabom.baseballgame.domain.BaseballNumbers.COUNT;

public class RandomBaseballNumbersGenerator implements BaseballNumbersGenerator {

    @Override
    public BaseballNumbers generate() {
        return BaseballNumbers.of(createRandomNumbers());
    }

    private List<BaseballNumber> createRandomNumbers() {
        return ThreadLocalRandom.current().ints(START_BOUND, END_BOUND + 1)
                .mapToObj(BaseballNumber::of)
                .distinct()
                .limit(COUNT)
                .collect(Collectors.toList());
    }
}
