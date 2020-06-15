package com.javabom.baseballgame.domain;

import java.util.Objects;

public class IndexedBaseballNumber {
    private final int index;
    private final BaseballNumber value;

    public IndexedBaseballNumber(int index, BaseballNumber value) {
        this.index = index;
        this.value = value;
    }

    public boolean equalsOnlyNumber(IndexedBaseballNumber number) {
        return this.value.equals(number.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndexedBaseballNumber that = (IndexedBaseballNumber) o;
        return index == that.index &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, value);
    }
}
