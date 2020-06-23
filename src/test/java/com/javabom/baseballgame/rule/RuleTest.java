package com.javabom.baseballgame.rule;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RuleTest {

    @DisplayName("Rule 리스트를 Map으로 만든다.")
    @Test
    void toMap() {
        List<Rule> rules = Arrays.asList(Rule.STRIKE, Rule.STRIKE, Rule.BALL);

        Map<Rule, Integer> convertResult = Rule.toMap(rules);

        assertAll(
                () -> assertThat(convertResult).containsEntry(Rule.STRIKE, 2),
                () -> assertThat(convertResult).containsEntry(Rule.BALL, 1),
                () -> assertThat(convertResult).containsEntry(Rule.OUT, 0)
        );

    }
}