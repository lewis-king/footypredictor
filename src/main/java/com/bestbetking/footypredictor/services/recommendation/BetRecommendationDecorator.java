package com.bestbetking.footypredictor.services.recommendation;

import com.bestbetking.footypredictor.model.prediction.BetType;

import java.util.ArrayList;
import java.util.List;

import static com.bestbetking.footypredictor.services.recommendation.BetRecommendationRules.*;

public class BetRecommendationDecorator {

    public static List<BetType> buildRecommendedBetTypes(Double homeTeamScore, Double awayTeamScore) {
            List<BetType> recommendedBets = new ArrayList<>();
            BET_RECOMMENDATION_RULES.forEach(predicate -> {
                if (predicate.test(homeTeamScore, awayTeamScore)) {
                    recommendedBets.add(PREDICATE_BET_TYPE_MAP.get(predicate));
                }
            });
            return recommendedBets;
    }
}
