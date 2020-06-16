package com.javabom.baseballgame.number;

import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

public class Position implements Comparable<Position> {
    private static final int POSITION_MIN = 1;
    private static final int POSITION_MAX = 3;

    private final int position;

    private Position(final int position) {
        this.position = position;
    }

    public static Position valueOf(final int position) {
        validatePositionBound(position);
        return PositionCache.getPosition(position);
    }

    private static void validatePositionBound(final int position) {
        if (position < POSITION_MIN || position > POSITION_MAX) {
            throw new IllegalArgumentException("숫자의 위치는 1 ~ 3 사이의 값이어야 합니다. - " + position);
        }
    }

    @Override
    public int compareTo(final Position o) {
        return Integer.compare(this.position, o.position);
    }

    private static class PositionCache {
        private static final Map<Integer, Position> cache;

        static {
            cache = IntStream.rangeClosed(POSITION_MIN, POSITION_MAX)
                    .boxed()
                    .collect(toMap(position -> position, Position::new));
        }

        private static Position getPosition(final int position) {
            return cache.get(position);
        }
    }
}
