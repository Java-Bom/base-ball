package com.javabom.baseballgame.number;

import com.javabom.baseballgame.rule.Rule;

import java.util.Objects;

public class BaseBallNumber implements Comparable<BaseBallNumber> {
    private final BallNumber ballNumber;
    private final Position position;

    public BaseBallNumber(int ballNumber, int position) {
        this.ballNumber = BallNumber.valueOf(ballNumber);
        this.position = Position.valueOf(position);
    }

    public Rule match(BaseBallNumber baseBallNumber) {
        if (this.equals(baseBallNumber)) {
            return Rule.STRIKE;
        }

        if (this.ballNumber.equals(baseBallNumber.ballNumber)) {
            return Rule.BALL;
        }

        return Rule.OUT;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseBallNumber)) return false;
        BaseBallNumber that = (BaseBallNumber) o;
        return ballNumber.equals(that.ballNumber) &&
                position.equals(that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumber, position);
    }

    @Override
    public int compareTo(final BaseBallNumber o) {
        return position.compareTo(o.position);
    }
}
