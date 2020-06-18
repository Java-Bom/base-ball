package com.javabom.baseballgame.domain.domain.machine;

import com.javabom.baseballgame.domain.domain.number.GameNumber;

import java.util.Arrays;
import java.util.List;

public class FixedNumbersGenerator implements GameNumbersGenerator {

    private List<GameNumber> fixedNumbers = Arrays.asList(
            GameNumber.of("1"),
            GameNumber.of("2"),
            GameNumber.of("3"));

    @Override
    public List<GameNumber> generate() {
        return fixedNumbers;
    }
}
