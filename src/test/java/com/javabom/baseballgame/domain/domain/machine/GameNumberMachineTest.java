package com.javabom.baseballgame.domain.domain.machine;

import com.javabom.baseballgame.domain.domain.number.ClientGameNumbers;
import com.javabom.baseballgame.domain.domain.number.GameNumber;
import com.javabom.baseballgame.domain.domain.number.OrderGameNumber;
import com.javabom.baseballgame.domain.domain.number.WinningGameNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameNumberMachineTest {

    @DisplayName("랜덤으로 뽑은 정답 숫자를 반환한다.")
    @Test
    void getWinningGameNumbers() {
        //given
        GameNumberMachine gameNumberMachine = new GameNumberMachine(new FixedNumbersGenerator());

        //when
        WinningGameNumbers winningGameNumbers = gameNumberMachine.getWinningGameNumbers();

        //then
        assertThat(winningGameNumbers.size()).isEqualTo(3);
        assertTrue(winningGameNumbers.contains(OrderGameNumber.of(0, GameNumber.of("1"))));
        assertTrue(winningGameNumbers.contains(OrderGameNumber.of(1, GameNumber.of("2"))));
        assertTrue(winningGameNumbers.contains(OrderGameNumber.of(2, GameNumber.of("3"))));
    }

    @DisplayName("사용자가 예측한 숫자를 반환한다.")
    @Test
    void getClientGameNumbers() {
        //given
        List<String> inputGameNumbers = Arrays.asList("1", "2", "3");
        GameNumberMachine gameNumberMachine = new GameNumberMachine(new RandomGameNumbersGenerator());

        //when
        ClientGameNumbers clientGameNumbers = gameNumberMachine.getClientGameNumbers(inputGameNumbers);

        //then
        assertThat(clientGameNumbers.size()).isEqualTo(3);
        assertTrue(clientGameNumbers.contains(OrderGameNumber.of(0, GameNumber.of("1"))));
        assertTrue(clientGameNumbers.contains(OrderGameNumber.of(1, GameNumber.of("2"))));
        assertTrue(clientGameNumbers.contains(OrderGameNumber.of(2, GameNumber.of("3"))));
    }
}
