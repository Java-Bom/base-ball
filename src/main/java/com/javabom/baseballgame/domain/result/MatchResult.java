package com.javabom.baseballgame.domain.result;

import com.javabom.baseballgame.domain.baseball.BaseballGameNumbers;
import com.javabom.baseballgame.domain.baseball.vo.Order;

import java.util.stream.IntStream;

public enum MatchResult {
    STRIKE {
        public int getMatchCount(final BaseballGameNumbers correctNumbers,
                                 final BaseballGameNumbers inputNumbers) {
            return (int) IntStream.rangeClosed(Order.ORDER_START, Order.ORDER_END)
                    .mapToObj(Order::valueOf)
                    .filter(order -> isStrike(correctNumbers, inputNumbers, order))
                    .count();
        }
    },
    BALL {
        public int getMatchCount(final BaseballGameNumbers correctNumbers,
                                 final BaseballGameNumbers inputNumbers) {
            return (int) IntStream.rangeClosed(Order.ORDER_START, Order.ORDER_END)
                    .mapToObj(Order::valueOf)
                    .filter(order -> isBall(correctNumbers, inputNumbers, order))
                    .count();
        }
    },
    OUT {
        public int getMatchCount(final BaseballGameNumbers correctNumbers,
                                 final BaseballGameNumbers inputNumbers) {
            return (int) IntStream.rangeClosed(Order.ORDER_START, Order.ORDER_END)
                    .mapToObj(Order::valueOf)
                    .filter(order -> isOut(correctNumbers, inputNumbers, order))
                    .count();
        }
    };

    private static boolean isStrike(final BaseballGameNumbers correctNumbers,
                                    final BaseballGameNumbers inputNumbers, final Order order) {
        return correctNumbers.containBaseballGameNumber(inputNumbers.getBaseballGameNumber(order));
    }

    private static boolean isBall(final BaseballGameNumbers correctNumbers,
                                  final BaseballGameNumbers inputNumbers, final Order order) {
        return !isStrike(correctNumbers, inputNumbers, order) &&
        correctNumbers.containSameBallNumber(inputNumbers.getBaseballGameNumber(order));
    }

    private static boolean isOut(final BaseballGameNumbers correctNumbers,
                                 final BaseballGameNumbers inputNumbers, final Order order) {
        return !isBall(correctNumbers, inputNumbers, order) &&
                !isStrike(correctNumbers, inputNumbers, order);
    }

    public abstract int getMatchCount(final BaseballGameNumbers correctNumbers, final BaseballGameNumbers inputNumbers);

}

