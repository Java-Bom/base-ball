package com.javabom.baseballgame.game;

import com.javabom.baseballgame.number.BaseBallNumbers;
import com.javabom.baseballgame.number.NumberGenerator;

import java.util.List;

public class BaseBallGame {
    private final BaseBallNumbers answerBalls;

    public BaseBallGame(NumberGenerator numberGenerator) {
        this.answerBalls = BaseBallNumbers.ofAuto(numberGenerator);
    }

    public PredicateResult tryToPredicate(List<Integer> userBalls, int tryNumber) {
        return new PredicateResult(tryNumber, this.answerBalls.predicateBalls(BaseBallNumbers.ofFixed(userBalls)));
    }
}
