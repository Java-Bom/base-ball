package com.javabom.baseballgame.domain.result;

import java.util.EmptyStackException;
import java.util.Stack;

public class TryResults {

    private final Stack<TryResult> results = new Stack<>();

    public void addResult(TryResult tryResult) {
        results.add(tryResult);
    }

    public TryResult peek() {
        if (results.isEmpty()) {
            throw new EmptyStackException();
        }

        return results.peek();
    }

    public int size() {
        return results.size();
    }

}
