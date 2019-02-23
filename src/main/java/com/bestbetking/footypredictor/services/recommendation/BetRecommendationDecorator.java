package com.bestbetking.footypredictor.services.recommendation;

import com.bestbetking.footypredictor.model.prediction.BetType;
import com.bestbetking.footypredictor.model.prediction.Prediction;
import com.bestbetking.footypredictor.model.prediction.Predictions;

import java.util.ArrayList;
import java.util.List;

import static com.bestbetking.footypredictor.services.recommendation.BetRecommendationRules.*;

public class BetRecommendationDecorator {

    public static List<BetType> deriveRecommendedBetTypes(Double homeTeamScore, Double awayTeamScore) {
        List<BetType> recommendedBets = addRecommendedBets(homeTeamScore, awayTeamScore);
        return recommendedBets;
    }

    public static List<Prediction> deriveRecommendedBetTypes(List<Prediction> predictions) {
        predictions.forEach(prediction -> {
            prediction.setRecommendedBets(addRecommendedBets(prediction.getHomeTeamScore(), prediction.getAwayTeamScore()));
        });
        return predictions;
    }

    private static List<BetType> addRecommendedBets(Double homeTeamScore, Double awayTeamScore) {
        List<BetType> recommendedBets = new ArrayList<>();
        BET_RECOMMENDATION_RULES.forEach(predicate -> {
            if (predicate.test(homeTeamScore, awayTeamScore)) {
                recommendedBets.add(PREDICATE_BET_TYPE_MAP.get(predicate));
            }
        });
        return recommendedBets;
    }
}
