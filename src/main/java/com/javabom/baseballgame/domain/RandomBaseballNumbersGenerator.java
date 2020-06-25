package com.javabom.baseballgame.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.javabom.baseballgame.domain.BaseballNumber.END_BOUND;
import static com.javabom.baseballgame.domain.BaseballNumber.START_BOUND;
import static com.javabom.baseballgame.domain.BaseballNumbers.COUNT;

public class RandomBaseballNumbersGenerator implements BaseballNumbersGenerator {

    @Override
    public BaseballNumbers generate() {
        List<BaseballNumber> randomNumbers = createRandomNumbers();

        Set<OrderedBaseballNumber> orderedBaseballNumbers = new HashSet<>();
        for (int order = 1; order <= COUNT; order++) {
            BaseballNumber baseballNumber = randomNumbers.get(order - 1);
            OrderedBaseballNumber orderedNumber = OrderedBaseballNumber.of(Order.valueOf(order), baseballNumber);
            orderedBaseballNumbers.add(orderedNumber);
        }
        return new BaseballNumbers(orderedBaseballNumbers);
    }

    private List<BaseballNumber> createRandomNumbers() {
        return ThreadLocalRandom.current().ints(START_BOUND, END_BOUND + 1)
                .mapToObj(BaseballNumber::of)
                .distinct()
                .limit(COUNT)
                .collect(Collectors.toList());
    }
}
