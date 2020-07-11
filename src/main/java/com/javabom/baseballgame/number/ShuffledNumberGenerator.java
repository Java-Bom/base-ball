package com.javabom.baseballgame.number;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShuffledNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> generateRangeClosed(final int min, final int max) {
        List<Integer> randomNumbers = IntStream.rangeClosed(min, max)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(randomNumbers);

        return randomNumbers;
    }
}
