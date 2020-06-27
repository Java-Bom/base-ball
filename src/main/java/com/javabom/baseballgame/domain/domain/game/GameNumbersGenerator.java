package com.javabom.baseballgame.domain.domain.game;

import com.javabom.baseballgame.domain.domain.number.GameNumber;

import java.util.List;

public interface GameNumbersGenerator {
    List<GameNumber> generate();
}
