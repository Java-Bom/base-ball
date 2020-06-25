package com.javabom.baseballgame.domain;

import java.util.Objects;

public class IndexedBaseballNumber {
    private final int MIN_INDEX = 0;
    private final int MAX_INDEX = 2;

    private final int index;
    private final BaseballNumber value;

    public IndexedBaseballNumber(final int index, final BaseballNumber value) {
        this.index = index;
        this.value = value;
        validateIndexRange();
    }

    private void validateIndexRange() {
        if (index < MIN_INDEX || index > MAX_INDEX) {
            throw new IllegalArgumentException(
                    String.format("IndexedBaseballNumber의 index는 0~2 입니다. 입력값 : %d", index));
        }
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
