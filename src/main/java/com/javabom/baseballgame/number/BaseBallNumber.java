package com.javabom.baseballgame.number;

public class BaseBallNumber implements Comparable<BaseBallNumber> {
    private final BallNumber ballNumber;
    private final Position position;

    public BaseBallNumber(int ballNumber, int position) {
        this.ballNumber = BallNumber.valueOf(ballNumber);
        this.position = Position.valueOf(position);
    }

    @Override
    public int compareTo(final BaseBallNumber o) {
        return position.compareTo(o.position);
    }
}
