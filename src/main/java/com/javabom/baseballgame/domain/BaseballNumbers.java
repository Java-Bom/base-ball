package com.javabom.baseballgame.domain;

import java.util.*;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class BaseballNumbers {
    public static final int PICK_NUMBERS_SIZE = 3;
    private final List<IndexedBaseballNumber> values;

    public BaseballNumbers(final List<BaseballNumber> values) {
        this.values = convertToIndexed(values);
        validateNumbersSize();
        validateDuplicatedNumbers();
    }

    private List<IndexedBaseballNumber> convertToIndexed(final List<BaseballNumber> numbers) {
        List<IndexedBaseballNumber> convertedNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            convertedNumbers.add(new IndexedBaseballNumber(i, numbers.get(i)));
        }
        return convertedNumbers;
    }
    // 인덱스를 주는 시점은 이곳에서 주는 것 보다 더 밖으로 빼는게 맞는걸까요?
    // 아예 생성자에서 IndexedBaseballNumber의 List를 받는게 맞는걸까요.
    // 제 생각에는 이 생성자를 거침으로써 숫자들의 순서의 의미가 생긴다고 생각하여 이곳에서 인덱스를 부여해주었습니다.

    private void validateNumbersSize() {
        if (values.size() != PICK_NUMBERS_SIZE) {
            throw new IllegalArgumentException(String.format("야구 숫자의 개수는 반드시 3개입니다. 입력 개수 : %d", values.size()));
        }
    }

    private void validateDuplicatedNumbers() {
        int distinctNumberSize = new HashSet<>(values).size();
        if (distinctNumberSize != PICK_NUMBERS_SIZE) {
            throw new IllegalArgumentException(String.format("야구 숫자는 중복될 수 없습니다. 입력 값 : %s", values.toString()));
        }
    }

    public GameResults compare(BaseballNumbers numbers) {
        return numbers.values.stream()
                .map(this::compare)
                .collect(collectingAndThen(toList(), GameResults::new));
    }

    private GameResult compare(IndexedBaseballNumber number) {
        if (this.values.contains(number)) {
            return GameResult.STRIKE;
        }
        if (equalOnlyNumber(number)) {
            return GameResult.BALL;
        }
        return GameResult.OUT;
    }

    private boolean equalOnlyNumber(IndexedBaseballNumber number) {
        return this.values.stream()
                .anyMatch(indexedNumber -> indexedNumber.equalsOnlyNumber(number));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballNumbers that = (BaseballNumbers) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
