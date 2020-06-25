package com.javabom.baseballgame.domain;

import java.util.List;

public class BaseballGameOutputs {
    private final List<GameOutput> outputs;

    public BaseballGameOutputs(final List<GameOutput> outputs) {
        this.outputs = outputs;
    }

    public boolean isAllStrike() {
        int count = Math.toIntExact(outputs.stream()
                .filter(output -> output == GameOutput.STRIKE)
                .count());
        return count == BaseballNumbers.COUNT;
    }

    public int countOf(final GameOutput output) {
        return Math.toIntExact(outputs.stream()
                .filter(output::equals)
                .count());
    }
}
