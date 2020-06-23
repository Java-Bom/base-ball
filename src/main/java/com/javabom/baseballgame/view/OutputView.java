package com.javabom.baseballgame.view;

import com.javabom.baseballgame.domain.BaseballGameOutputs;

import static com.javabom.baseballgame.domain.GameOutput.*;

public class OutputView {

    public static void printSystemSettingMessage() {
        System.out.println("컴퓨터가 숫자를 뽑았습니다.");
    }

    public static boolean printGameOutputs(BaseballGameOutputs outputs) {
        boolean isPresentStrike = outputs.countOf(STRIKE) > 0;
        boolean isPresentBall = outputs.countOf(BALL) > 0;
        boolean isPresentOut = outputs.countOf(OUT) > 0;

        if (isPresentStrike) {
            System.out.printf("STRIKE %d\t", outputs.countOf(STRIKE));
        }
        if (isPresentBall) {
            System.out.printf("BALL %d\t", outputs.countOf(BALL));
        }
        if (isPresentOut) {
            System.out.printf("OUT %d\t", outputs.countOf(OUT));
        }

        return isPresentStrike;
    }
}
