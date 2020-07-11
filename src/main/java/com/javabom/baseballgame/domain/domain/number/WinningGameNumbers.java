package com.javabom.baseballgame.domain.domain.number;

import com.javabom.baseballgame.domain.domain.result.MatchedResults;
import com.javabom.baseballgame.domain.domain.result.MatchedResult;
import com.javabom.baseballgame.domain.domain.utils.OrderGameNumberConverter;

import java.util.ArrayList;
import java.util.List;

import static com.javabom.baseballgame.domain.domain.number.ClientGameNumbers.GAME_NUMBERS_COUNT;

public class WinningGameNumbers {

    private final List<OrderGameNumber> winningGameNumbers;

    public WinningGameNumbers(final List<GameNumber> winningGameNumbers) {
        checkCount(winningGameNumbers.size());
        checkDuplicate(winningGameNumbers);
        this.winningGameNumbers = OrderGameNumberConverter.convertTo(winningGameNumbers);
    }

    private static void checkCount(final int size) {
        if (size != GAME_NUMBERS_COUNT) {
            throw new IllegalArgumentException(String.format("%d, 숫자 게임에서 사용될 숫자의 갯수는 3개여야 합니다.", size));
        }
    }

    private static void checkDuplicate(final List<GameNumber> gameNumbers) {
        int size = getDeduplicationSize(gameNumbers);
        if (size != GAME_NUMBERS_COUNT) {
            throw new IllegalArgumentException(String.format("중복을 제외한 숫자 갯수: %d, 숫자에 중복이 있습니다.", size));
        }
    }

    private static int getDeduplicationSize(final List<GameNumber> gameNumbers) {
        return (int) gameNumbers.stream()
                .distinct()
                .count();
    }

    public MatchedResults getMatchedResults(final ClientGameNumbers clientGameNumbers) {
        List<MatchedResult> matchedResults = new ArrayList<>();
        for (OrderGameNumber winningGameNumber : winningGameNumbers) {
            boolean allMatchStatus = clientGameNumbers.contains(winningGameNumber);
            boolean anyMatchStatus = clientGameNumbers.containsOnlyGameNumber(winningGameNumber);
            matchedResults.add(MatchedResult.findResult(allMatchStatus, anyMatchStatus));
        }

        return new MatchedResults(matchedResults);
    }
}
