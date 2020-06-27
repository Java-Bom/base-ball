package com.javabom.baseballgame.domain.domain.utils;

import com.javabom.baseballgame.domain.domain.number.GameNumber;
import com.javabom.baseballgame.domain.domain.number.OrderGameNumber;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class OrderGameNumberConverter {

    public static List<OrderGameNumber> convertTo(List<GameNumber> gameNumbers) {
        final AtomicInteger idx = new AtomicInteger();

        return gameNumbers.stream()
                .map(gameNumber -> OrderGameNumber.of(idx.getAndIncrement(), gameNumber))
                .collect(Collectors.toList());
    }
}
