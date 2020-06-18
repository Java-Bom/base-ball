package com.javabom.baseballgame.domain.domain.machine;

import com.javabom.baseballgame.domain.domain.number.GameNumber;
import com.javabom.baseballgame.domain.domain.number.OrderGameNumber;

import java.util.List;

public interface GameNumbersGenerator {
    List<GameNumber> generate();
}
