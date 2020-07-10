package com.javabom.baseballgame.domain.baseball;

import com.javabom.baseballgame.domain.result.MatchResult;
import com.javabom.baseballgame.domain.result.TryResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class GameMachineTest {

    @Test
    @DisplayName("새로운 입력 값들이 들어올 시 여부 판단해주는지 확인.")
    void isFinishTest() {
        BaseballGameNumbers correctNumbers = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(1, 2, 3));
        GameMachine gameMachine = new GameMachine(correctNumbers);
        BaseballGameNumbers allStrikeNumbers = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(1, 2, 3));
        BaseballGameNumbers allOutNumbers = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(4, 5, 6));

        gameMachine.tryNextGame(allOutNumbers);
        assertThat(gameMachine.isFinish()).isFalse();

        gameMachine.tryNextGame(allStrikeNumbers);
        assertThat(gameMachine.isFinish()).isTrue();
    }

    @Test
    @DisplayName("마지막 시도한 결과를 반환 하는지 확인.")
    void getLastTryResult() {
        BaseballGameNumbers correctNumbers = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(1, 2, 3));
        GameMachine gameMachine = new GameMachine(correctNumbers);
        BaseballGameNumbers allStrike = BaseballGameNumbersGenerator.generateNumbers(Arrays.asList(1, 2, 3));

        gameMachine.tryNextGame(allStrike);
        TryResult lastTryResult = gameMachine.getLastTryResult();
        assertThat(lastTryResult.getMatchResultCount(MatchResult.STRIKE)).isEqualTo(3);
    }

    @Test
    @DisplayName("시도한 횟수를 반환하는지 확인.")
    void getTryCount() {
        GameMachine gameMachine = new GameMachine(BaseballGameNumbersGenerator.generateRandomNumbers());
        gameMachine.tryNextGame(BaseballGameNumbersGenerator.generateRandomNumbers());
        gameMachine.tryNextGame(BaseballGameNumbersGenerator.generateRandomNumbers());
        gameMachine.tryNextGame(BaseballGameNumbersGenerator.generateRandomNumbers());

        assertThat(gameMachine.getTryCount()).isEqualTo(3);
    }
}