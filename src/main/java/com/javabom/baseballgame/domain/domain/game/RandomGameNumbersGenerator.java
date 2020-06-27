package com.javabom.baseballgame.domain.domain.game;

import com.javabom.baseballgame.domain.domain.number.GameNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.javabom.baseballgame.domain.domain.number.GameNumber.MAX_NUMBER;
import static com.javabom.baseballgame.domain.domain.number.GameNumber.MIN_NUMBER;

public class RandomGameNumbersGenerator implements GameNumbersGenerator {
    private static final int LIMIT_SIZE = 3;
    private final List<GameNumber> gameNumbers = createGameNumbers();

    private List<GameNumber> createGameNumbers() {
        return IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .mapToObj(GameNumber::of)
                .collect(Collectors.toList());
    }

    @Override
    public List<GameNumber> generate() {
        Collections.shuffle(gameNumbers);
        return gameNumbers.stream()
                .limit(LIMIT_SIZE)
                .collect(Collectors.toList());
    }
}
