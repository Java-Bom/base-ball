package com.javabom.baseballgame.domain.baseball;

import com.javabom.baseballgame.domain.baseball.vo.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballGameNumbersTest {

    @Test
    @DisplayName("입력된 BaseballGameNumbers 값들의 개수가 3개가 아닌 경우 예외")
    public void validNumberCountTest() {
        List<BaseballGameNumber> baseballNumbers = getBaseballNumberList();

        assertThatThrownBy(() -> new BaseballGameNumbers(baseballNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("입력한 baseballGameNumber 개수 : %d - 3개의 baseballGameNumber를 입력하세요.",
                        baseballNumbers.size()));

        baseballNumbers.addAll(getBaseballNumberList());

        assertThatThrownBy(() -> new BaseballGameNumbers(baseballNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("입력한 baseballGameNumber 개수 : %d - 3개의 baseballGameNumber를 입력하세요.",
                        baseballNumbers.size()));
    }

    private List<BaseballGameNumber> getBaseballNumberList() {
        List<BaseballGameNumber> baseballGameNumberList = new ArrayList<>();
        baseballGameNumberList.add(new BaseballGameNumber(0, 0));
        baseballGameNumberList.add(new BaseballGameNumber(1, 1));
        return baseballGameNumberList;
    }

    @Test
    @DisplayName("입력된 BaseballGameNumber 값들에 중복된 숫자가 존재하는지 확인.")
    public void validDuplicatedNumberTest() {
        List<BaseballGameNumber> baseballNumbers = getBaseballNumberList();
        baseballNumbers.add(new BaseballGameNumber(0, 2));

        assertThatThrownBy(() -> new BaseballGameNumbers(baseballNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 숫자가 존재합니다.");
    }

    @Test
    @DisplayName("입력된 BaseballGameNumber 값들에 중복된 순서가 존재하는지 확인.")
    public void validDuplicatedOrderTest() {
        List<BaseballGameNumber> baseballNumbers = getBaseballNumberList();
        baseballNumbers.add(new BaseballGameNumber(2, 0));

        assertThatThrownBy(() -> new BaseballGameNumbers(baseballNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 순서가 존재합니다.");
    }

    private BaseballGameNumbers getBaseballNumbers() {
        List<BaseballGameNumber> baseballNumbers = getBaseballNumberList();
        baseballNumbers.add(new BaseballGameNumber(2, 2));
        return new BaseballGameNumbers(baseballNumbers);
    }

    @Test
    @DisplayName("입력된 Order을 가지는 BaseballGameNumber을 반환하는지 확인.")
    public void getBaseballGameNumberTest() {
        BaseballGameNumbers baseballNumbers = getBaseballNumbers();
        Order order = Order.valueOf(2);
        BaseballGameNumber baseballGameNumber = new BaseballGameNumber(2, order.getValue());

        assertThat(baseballNumbers.getBaseballGameNumber(order)).isEqualTo(baseballGameNumber);
    }

    @Test
    @DisplayName("입력된 BaseballGameNumber와 같은 BaseballGameNumber가 존재하는지 확인.")
    public void containBaseballGameNumberTest() {
        BaseballGameNumbers baseballNumbers = getBaseballNumbers();
        BaseballGameNumber sameBaseballGameNumber = new BaseballGameNumber(2, 2);
        BaseballGameNumber differentBaseBallGameNumber = new BaseballGameNumber(2, 0);


        assertThat(baseballNumbers.containBaseballGameNumber(sameBaseballGameNumber)).isTrue();
        assertThat(baseballNumbers.containBaseballGameNumber(differentBaseBallGameNumber)).isFalse();
    }

    @Test
    @DisplayName("입력된 BaseballGameNumber와 같은 BallNumber가 존재하는지 확인.")
    public void containSameBallNumber() {
        BaseballGameNumbers baseballNumbers = getBaseballNumbers();
        BaseballGameNumber sameBaseballGameNumber = new BaseballGameNumber(2, 2);
        BaseballGameNumber differentBaseBallGameNumber = new BaseballGameNumber(3, 0);


        assertThat(baseballNumbers.containSameBallNumber(sameBaseballGameNumber)).isTrue();
        assertThat(baseballNumbers.containSameBallNumber(differentBaseBallGameNumber)).isFalse();
    }


}