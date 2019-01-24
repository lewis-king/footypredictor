package com.bestbetking.footypredictor.services.recommendation;

import com.bestbetking.footypredictor.model.prediction.BetType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;

import static java.util.Arrays.asList;

public class BetRecommendationRules {
    public static final BiPredicate<Double, Double> HOME_WIN = (homeTeamScore, awayTeamScore) -> homeTeamScore - awayTeamScore > 2;
    public static final BiPredicate<Double, Double> AWAY_WIN = (homeTeamScore, awayTeamScore) -> awayTeamScore - homeTeamScore > 2;
    public static final BiPredicate<Double, Double> HOME_LAY = (homeTeamScore, awayTeamScore) -> awayTeamScore - homeTeamScore > 1 && awayTeamScore - homeTeamScore <= 2;
    public static final BiPredicate<Double, Double> AWAY_LAY = (homeTeamScore, awayTeamScore) -> homeTeamScore - awayTeamScore > 1 && homeTeamScore - awayTeamScore <= 2;
    public static final BiPredicate<Double, Double> OVER_1_HALF_GOALS = (homeTeamScore, awayTeamScore) -> homeTeamScore + awayTeamScore > 3;
    public static final BiPredicate<Double, Double> UNDER_4_HALF_GOALS = (homeTeamScore, awayTeamScore) -> homeTeamScore + awayTeamScore < 3;
    public static final BiPredicate<Double, Double> BOTH_TEAMS_TO_SCORE = (homeTeamScore, awayTeamScore) -> homeTeamScore > 2 && awayTeamScore > 2;
    public static final BiPredicate<Double, Double> HOME_TEAM_CLEAN_SHEET = (homeTeamScore, awayTeamScore) -> awayTeamScore < 0.45;
    public static final BiPredicate<Double, Double> AWAY_TEAM_CLEAN_SHEET = (homeTeamScore, awayTeamScore) -> homeTeamScore < 0.45;

    public static final List<BiPredicate<Double, Double>> BET_RECOMMENDATION_RULES =
            asList(HOME_WIN, AWAY_WIN, HOME_LAY, AWAY_LAY, OVER_1_HALF_GOALS, UNDER_4_HALF_GOALS,
                    BOTH_TEAMS_TO_SCORE, HOME_TEAM_CLEAN_SHEET, AWAY_TEAM_CLEAN_SHEET);

    public static final Map<BiPredicate<Double, Double>, BetType> PREDICATE_BET_TYPE_MAP = new HashMap<>();
    static {
        PREDICATE_BET_TYPE_MAP.put(HOME_WIN, BetType.HOME_WIN);
        PREDICATE_BET_TYPE_MAP.put(AWAY_WIN, BetType.AWAY_WIN);
        PREDICATE_BET_TYPE_MAP.put(HOME_LAY, BetType.HOME_LAY);
        PREDICATE_BET_TYPE_MAP.put(AWAY_LAY, BetType.AWAY_LAY);
        PREDICATE_BET_TYPE_MAP.put(OVER_1_HALF_GOALS, BetType.OVER_1_HALF_GOALS);
        PREDICATE_BET_TYPE_MAP.put(UNDER_4_HALF_GOALS, BetType.UNDER_4_HALF_GOALS);
        PREDICATE_BET_TYPE_MAP.put(BOTH_TEAMS_TO_SCORE, BetType.BOTH_TEAMS_TO_SCORE);
        PREDICATE_BET_TYPE_MAP.put(HOME_TEAM_CLEAN_SHEET, BetType.HOME_CLEAN_SHEET);
        PREDICATE_BET_TYPE_MAP.put(AWAY_TEAM_CLEAN_SHEET, BetType.AWAY_CLEAN_SHEET);
    }

}
