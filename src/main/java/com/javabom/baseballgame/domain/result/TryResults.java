package com.javabom.baseballgame.domain.result;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class TryResults {

    private final List<TryResult> results = new ArrayList<>();

    public void addResult(TryResult tryResult) {
        results.add(tryResult);
    }

    public TryResult peek() {
        if (results.isEmpty()) {
            throw new EmptyStackException();
        }

        return results.get(results.size()-1);
    }

    public int size() {
        return results.size();
    }

}
