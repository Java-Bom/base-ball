package com.javabom.baseballgame.domain.domain.number;

import com.javabom.baseballgame.domain.domain.utils.OrderGameNumberConverter;
import com.javabom.baseballgame.domain.domain.result.MatchedResults;
import com.javabom.baseballgame.domain.domain.result.MatchedResult;
import com.javabom.baseballgame.domain.domain.valid.GameNumbersValidator;

import java.util.ArrayList;
import java.util.List;

public class WinningGameNumbers {
    private final List<OrderGameNumber> winningGameNumbers;

    public WinningGameNumbers(final List<GameNumber> winningGameNumbers) {
        GameNumbersValidator.checkCount(winningGameNumbers.size());
        GameNumbersValidator.checkDuplicate(winningGameNumbers);
        this.winningGameNumbers = OrderGameNumberConverter.covert(winningGameNumbers);
    }

    public MatchedResults getMatchedResults(final ClientGameNumbers clientGameNumbers) {
        List<MatchedResult> matchedResults = new ArrayList<>();
        for (OrderGameNumber winningGameNumber : winningGameNumbers) {
            boolean allMatchStatus = clientGameNumbers.contains(winningGameNumber);
            boolean anyMatchStatus = clientGameNumbers.hasNumber(winningGameNumber);
            matchedResults.add(MatchedResult.findResult(allMatchStatus, anyMatchStatus));
        }

        return new MatchedResults(matchedResults);
    }

    public int size() {
        return winningGameNumbers.size();
    }

    public boolean contains(final OrderGameNumber orderGameNumber) {
        return winningGameNumbers.contains(orderGameNumber);
    }
}
