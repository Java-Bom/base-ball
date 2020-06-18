package com.javabom.baseballgame.domain.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchedResultTest {

    @DisplayName("모두 일치하면 STRIKE, 아니면 BALL 또는 OUT을 반환한다.")
    @ParameterizedTest
    @CsvSource({"true,false,STRIKE","true,true,STRIKE","false,true,BALL","false,false,OUT"})
    void findResult(boolean allMatchStatus, boolean anyMatchStatus, String expected){
        //when
        MatchedResult actual = MatchedResult.findResult(allMatchStatus, anyMatchStatus);

        //then
        assertThat(actual).isEqualTo(MatchedResult.valueOf(expected));
    }
}
