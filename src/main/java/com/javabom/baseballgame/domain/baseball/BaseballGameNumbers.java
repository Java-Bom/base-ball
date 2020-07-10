package com.javabom.baseballgame.domain.baseball;

import com.javabom.baseballgame.domain.baseball.vo.Order;

import java.util.List;
import java.util.stream.IntStream;

public class BaseballGameNumbers {

    public final static int NUMBER_COUNT = 3;
    private final List<BaseballGameNumber> baseballGameNumbers;

    public BaseballGameNumbers(final List<BaseballGameNumber> baseballGameNumbers) {
        this.baseballGameNumbers = baseballGameNumbers;
        validBaseBallNumbers();
    }

    private void validBaseBallNumbers() {
        validNumberCount();
        validDuplicated();
    }

    private void validNumberCount() {
        if (baseballGameNumbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(
                    String.format("입력한 baseballGameNumber 개수 : %d - 3개의 baseballGameNumber를 입력하세요.",
                    baseballGameNumbers.size()));
        }
    }

    private void validDuplicated() {
        validDuplicatedOrder();
        validDuplicatedBallNumber();
    }

    private void validDuplicatedBallNumber() {
        long count = baseballGameNumbers.stream()
                .filter(this::hasDuplicatedBallNumber)
                .count();

        if (count > 0) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    private boolean hasDuplicatedBallNumber(final BaseballGameNumber gameNumber) {
        long count = baseballGameNumbers.stream()
                .filter(baseballGameNumber -> baseballGameNumber.isSameBallNumber(gameNumber))
                .count();

        return count > 1;
    }

    private void validDuplicatedOrder() {
        long count = IntStream.rangeClosed(Order.ORDER_START, Order.ORDER_END)
                .mapToObj(Order::valueOf)
                .filter(this::hasDuplicatedOrder)
                .count();

        if (count > 0) {
            throw new IllegalArgumentException("중복된 순서가 존재합니다.");
        }
    }

    private boolean hasDuplicatedOrder(final Order order) {
        long count = baseballGameNumbers.stream()
                .filter(baseballGameNumber -> baseballGameNumber.isOrder(order))
                .count();
        return count > 1;
    }

    public boolean isSameBaseBallNumber(final BaseballGameNumbers inputNumbers, final Order order) {
        return getBaseballGameNumber(order).equals(inputNumbers.getBaseballGameNumber(order));
    }

    public BaseballGameNumber getBaseballGameNumber(Order order) {
        return baseballGameNumbers.stream()
                .filter(baseballGameNumber -> baseballGameNumber.isOrder(order))
                .findFirst()
                .get();
    }

    public boolean containBaseballGameNumber(final BaseballGameNumber baseballGameNumber) {
        return this.baseballGameNumbers.contains(baseballGameNumber);
    }

    public boolean containSameBallNumber(final BaseballGameNumber otherGameNumber) {
        long count = baseballGameNumbers.stream()
                .filter(otherGameNumber::isSameBallNumber)
                .count();

        return count == 1;
    }
}
