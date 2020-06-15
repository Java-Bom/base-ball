package com.javabom.baseballgame.domain;

import java.util.List;
import java.util.Objects;

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

    public boolean isSolved() {
        return results.stream()
                .allMatch(result -> result == GameResult.STRIKE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResults that = (GameResults) o;
        return this.results.containsAll(that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
