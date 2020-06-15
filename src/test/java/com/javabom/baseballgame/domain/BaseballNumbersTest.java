package com.javabom.baseballgame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumbersTest {

    static List<Arguments> overSizedBaseballNumbers() {
        return Arrays.asList(
                Arguments.of(Arrays.asList(BaseballNumber.of(1), BaseballNumber.of(2))),
                Arguments.of(Arrays.asList(BaseballNumber.of(1), BaseballNumber.of(2), BaseballNumber.of(3), BaseballNumber.of(4)))
        );
    }

    @DisplayName("야구게임 숫자는 3개만 존재가능.")
    @MethodSource("overSizedBaseballNumbers")
    @ParameterizedTest
    void validateNumbersSize(List<BaseballNumber> baseballNumbers) {
        // then
        assertThatThrownBy(() -> new BaseballNumbers(baseballNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("야구 숫자의 개수는 반드시 3개입니다. 입력 개수 : %d", baseballNumbers.size()));
    }

    @DisplayName("숫자가 3개 이하인 경우 중복되면, 중복 될 수 없다는 Exception 발생.")
    @Test
    void validateDuplicatedNumbers() {
        // given
        List<BaseballNumber> baseballNumbers = Arrays.asList(BaseballNumber.of(1), BaseballNumber.of(2), BaseballNumber.of(2));
        // then
        assertThatThrownBy(() -> new BaseballNumbers(baseballNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("야구 숫자는 중복될 수 없습니다. 입력 값 : %s", baseballNumbers.toString()));
    }

    @DisplayName("숫자가 3개 초과인 경우 중복되면, 개수가 맞지 않은 Exception 발생.")
    @Test
    void validateDuplicatedOverFourNumbers() {
        // given
        List<BaseballNumber> baseballNumbers = Arrays.asList(BaseballNumber.of(1), BaseballNumber.of(2), BaseballNumber.of(3), BaseballNumber.of(3));
        // then
        assertThatThrownBy(() -> new BaseballNumbers(baseballNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("야구 숫자의 개수는 반드시 3개입니다. 입력 개수 : %d", baseballNumbers.size()));
    }


    static List<Arguments> pickedBaseballNumbers_AndThatGameResults() {
        return Arrays.asList(
                Arguments.of(
                        Arrays.asList(BaseballNumber.of(1), BaseballNumber.of(2), BaseballNumber.of(3)),
                        Arrays.asList(GameResult.STRIKE, GameResult.STRIKE, GameResult.STRIKE)
                ),
                Arguments.of(
                        Arrays.asList(BaseballNumber.of(1), BaseballNumber.of(2), BaseballNumber.of(4)),
                        Arrays.asList(GameResult.STRIKE, GameResult.STRIKE, GameResult.OUT)
                ),
                Arguments.of(
                        Arrays.asList(BaseballNumber.of(2), BaseballNumber.of(5), BaseballNumber.of(1)),
                        Arrays.asList(GameResult.BALL, GameResult.OUT, GameResult.BALL)
                )
        );
    }

    @DisplayName("숫자 비교후 예상 결과가 나오는지 확인")
    @ParameterizedTest()
    @MethodSource("pickedBaseballNumbers_AndThatGameResults")
    void compare(List<BaseballNumber> baseballNumbers, List<GameResult> gameResults) {
        // given
        BaseballNumbers answerBaseballNumbers = new BaseballNumbers(Arrays.asList(
                BaseballNumber.of(1),
                BaseballNumber.of(2),
                BaseballNumber.of(3)
        ));
        BaseballNumbers pickedBaseballNumbers = new BaseballNumbers(baseballNumbers);
        GameResults expectedGameResults = new GameResults(gameResults);

        // when
        GameResults actualGameResults = answerBaseballNumbers.compare(pickedBaseballNumbers);

        // then
        assertThat(actualGameResults).isEqualTo(expectedGameResults);
    }
    // 어떤 경우 까지 모두 테스트해야할지 모르겠습니다. 거의 모든 경우를 테스트하려면 경우의수가 너무 많아
    // argument에 해당하는 코드가 너무 길어져 가독성이 떨어질 것으로 예상되는데,
    // 그냥 제가 테스트하기 어려운 구조여서 그런걸까요??
    // 이쪽부분 조언 부탁드립니다.
}
