package com.bestbetking.footypredictor.services.recommendation;

import com.bestbetking.footypredictor.model.prediction.Prediction;

import java.util.function.Predicate;

public class BetRecommendationRules {

    private static final Predicate<Prediction> HOME_WIN = (prediction) -> prediction.getHomeTeamScore() - prediction.getAwayTeamScore() > 2;
    private static final Predicate<Prediction> AWAY_WIN = (prediction) -> prediction.getAwayTeamScore() - prediction.getHomeTeamScore() > 2;
    private static final Predicate<Prediction> HOME_LAY = (prediction -> prediction.getAwayTeamScore() - prediction.getHomeTeamScore() > 1);
    private static final Predicate<Prediction> AWAY_LAY = (prediction -> prediction.getHomeTeamScore() - prediction.getAwayTeamScore() > 1);
    private static final Predicate<Prediction> OVER_1_HALF_GOALS = (prediction -> prediction.getHomeTeamScore() + prediction.getAwayTeamScore() > 3);
    private static final Predicate<Prediction> UNDER_4_HALF_GOALS = (prediction -> prediction.getHomeTeamScore() + prediction.getAwayTeamScore() < 3);
    private static final Predicate<Prediction> BOTH_TEAMS_TO_SCORE = (prediction -> prediction.getHomeTeamScore() > 2 && prediction.getAwayTeamScore() > 2);
    private static final Predicate<Prediction> HOME_TEAM_CLEAN_SHEET = (prediction -> prediction.getAwayTeamScore() < 0.45);
    private static final Predicate<Prediction> AWAY_TEAM_CLEAN_SHEET = (prediction -> prediction.getHomeTeamScore() < 0.45);
}
