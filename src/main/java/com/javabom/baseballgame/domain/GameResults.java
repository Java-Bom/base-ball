package com.javabom.baseballgame.domain;

import java.util.List;

public class GameResults {
    private final List<GameResult> results;

    public GameResults(final List<GameResult> results) {
        this.results = results;
    }

    public int sizeOf(final GameResult specificResult) {
        return (int) results.stream()
                .filter(result -> result == specificResult)
                .count();
    }
}
