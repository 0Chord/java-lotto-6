package lotto.domain;

import static lotto.utils.ValueUnit.ONE;
import static lotto.utils.ValueUnit.PERCENT_CALCULATION;
import static lotto.utils.ValueUnit.ZERO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.utils.StringUnit;
import lotto.utils.ValueUnit;
import lotto.vo.Place;
import lotto.vo.Result;
import lotto.vo.Reward;

public final class Statistics {

    private final List<Result> results;
    private final List<Integer> ranks;
    private final Reward reward;

    private final Place place;

    public Statistics(List<Result> results) {
        this.results = results;
        this.ranks = getRank();
        this.reward = new Reward();
        this.place = new Place();
    }


    public List<String> rankStatistics() {
        List<String> printResult = new ArrayList<>();
        ValueUnit fifthPlace = ValueUnit.FIFTH_PLACE;
        ValueUnit firstPlace = ValueUnit.FIRST_PLACE;
        StringUnit unit = StringUnit.UNIT;
        for (int rank = fifthPlace.getValue(); rank < firstPlace.getValue(); rank++) {
            String lottoMessage = getPlaceMessage(rank);
            printResult.add(lottoMessage + ranks.get(rank) + unit.getValue());
        }
        return printResult;
    }

    public BigDecimal calcRateOfReturn(int money) {
        List<Integer> rewards = reward.getPrize();
        ValueUnit fifthPlace = ValueUnit.FIFTH_PLACE;
        ValueUnit firstPlace = ValueUnit.FIRST_PLACE;
        int totalReturn = ZERO.getValue();
        for (int rank = fifthPlace.getValue(); rank < firstPlace.getValue(); rank++) {
            totalReturn += rewards.get(rank) * ranks.get(rank);
        }
        return BigDecimal.valueOf(((double) totalReturn / money) * PERCENT_CALCULATION.getValue());
    }

    private String getPlaceMessage(int index) {
        return place.getMessage(index);
    }

    private List<Integer> getRank() {
        Integer zero = ZERO.getValue();
        List<Integer> ranks = Arrays.asList(zero, zero, zero, zero, zero, zero);
        results.stream()
                .map(Result::getRank)
                .forEach(rank -> ranks.set(rank, ranks.get(rank) + ONE.getValue()));
        return ranks;
    }
}
