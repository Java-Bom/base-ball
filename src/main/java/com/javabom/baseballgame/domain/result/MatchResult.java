package com.javabom.baseballgame.domain.result;

import com.javabom.baseballgame.domain.baseball.BaseballGameNumbers;
import com.javabom.baseballgame.domain.baseball.vo.Order;

import java.util.stream.IntStream;

public enum MatchResult {

    STRIKE {
        @Override
        public int getMatchCount(final BaseballGameNumbers correctNumbers, final BaseballGameNumbers inputNumbers) {
            return getMatchCountByMathResultType(correctNumbers, inputNumbers, this);
        }
    },
    BALL{
        @Override
        public int getMatchCount(final BaseballGameNumbers correctNumbers, final BaseballGameNumbers inputNumbers) {
            return getMatchCountByMathResultType(correctNumbers, inputNumbers, this);
        }
    },
    OUT{
        @Override
        public int getMatchCount(final BaseballGameNumbers correctNumbers, final BaseballGameNumbers inputNumbers) {
            return getMatchCountByMathResultType(correctNumbers, inputNumbers, this);
        }
    };

    public abstract int getMatchCount(final BaseballGameNumbers correctNumbers, final BaseballGameNumbers inputNumbers);

    private static int getMatchCountByMathResultType(final BaseballGameNumbers correctNumbers,
                                                     final BaseballGameNumbers inputNumbers,
                                                     final MatchResult matchResult) {
        return (int) IntStream.rangeClosed(Order.ORDER_START, Order.ORDER_END)
                .mapToObj(Order::valueOf)
                .map(order -> findMatchResult(correctNumbers, inputNumbers, order))
                .filter(result -> result.equals(matchResult))
                .count();
    }

    private static MatchResult findMatchResult(final BaseballGameNumbers correctNumbers,
                                                  final BaseballGameNumbers inputNumbers,
                                                  final Order order) {
        if (correctNumbers.isSameBaseBallNumber(inputNumbers, order)) {
            return MatchResult.STRIKE;
        }

        if (correctNumbers.containSameBallNumber(inputNumbers.getBaseballGameNumber(order))) {
            return MatchResult.BALL;
        }

        return MatchResult.OUT;
    }

}

