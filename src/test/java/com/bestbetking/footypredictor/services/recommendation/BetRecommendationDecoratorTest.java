package com.bestbetking.footypredictor.services.recommendation;

import com.bestbetking.footypredictor.model.prediction.BetType;
import org.junit.Test;

import java.util.List;

import static com.bestbetking.footypredictor.model.prediction.BetType.*;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.*;

public class BetRecommendationDecoratorTest {

    @Test
    public void buildRecommendedBetTypes_HomeWin() {
        Double homeTeamScore = 3.3;
        Double awayTeamScore = 0.4;

        List<BetType> actual = BetRecommendationDecorator.deriveRecommendedBetTypes(homeTeamScore, awayTeamScore);

        assertThat(actual, hasItem(HOME_WIN));
    }

    @Test
    public void buildRecommendedBetTypes_AwayWin() {
        Double homeTeamScore = 2.1;
        Double awayTeamScore = 4.2;

        List<BetType> actual = BetRecommendationDecorator.deriveRecommendedBetTypes(homeTeamScore, awayTeamScore);

        assertThat(actual, hasItem(AWAY_WIN));
    }

    @Test
    public void buildRecommendedBetTypes_HomeLay() {
        Double homeTeamScore = 1.4;
        Double awayTeamScore = 3.3;

        List<BetType> actual = BetRecommendationDecorator.deriveRecommendedBetTypes(homeTeamScore, awayTeamScore);

        assertThat(actual, hasItem(HOME_LAY));
    }

    @Test
    public void buildRecommendedBetTypes_AwayLay() {
        Double homeTeamScore = 3.3;
        Double awayTeamScore = 1.4;

        List<BetType> actual = BetRecommendationDecorator.deriveRecommendedBetTypes(homeTeamScore, awayTeamScore);

        assertThat(actual, hasItem(AWAY_LAY));
    }

    @Test
    public void buildRecommendedBetTypes_Over1HalfGoals() {
        Double homeTeamScore = 1.55;
        Double awayTeamScore = 1.5;

        List<BetType> actual = BetRecommendationDecorator.deriveRecommendedBetTypes(homeTeamScore, awayTeamScore);

        assertThat(actual, hasItem(OVER_1_HALF_GOALS));
    }

    @Test
    public void buildRecommendedBetTypes_Under4HalfGoals() {
        Double homeTeamScore = 1.33;
        Double awayTeamScore = 1.27;

        List<BetType> actual = BetRecommendationDecorator.deriveRecommendedBetTypes(homeTeamScore, awayTeamScore);

        assertThat(actual, hasItem(UNDER_4_HALF_GOALS));
    }

    @Test
    public void buildRecommendedBetTypes_BothTeamsToScore() {
        Double homeTeamScore = 2.33;
        Double awayTeamScore = 2.27;

        List<BetType> actual = BetRecommendationDecorator.deriveRecommendedBetTypes(homeTeamScore, awayTeamScore);

        assertThat(actual, hasItem(BOTH_TEAMS_TO_SCORE));
    }

    @Test
    public void buildRecommendedBetTypes_HomeCleanSheet() {
        Double homeTeamScore = 1.33;
        Double awayTeamScore = 0.27;

        List<BetType> actual = BetRecommendationDecorator.deriveRecommendedBetTypes(homeTeamScore, awayTeamScore);

        assertThat(actual, hasItem(HOME_CLEAN_SHEET));
    }

    @Test
    public void buildRecommendedBetTypes_AwayCleanSheet() {
        Double homeTeamScore = 0.33;
        Double awayTeamScore = 1.27;

        List<BetType> actual = BetRecommendationDecorator.deriveRecommendedBetTypes(homeTeamScore, awayTeamScore);

        assertThat(actual, hasItem(AWAY_CLEAN_SHEET));
    }

    @Test
    public void buildRecommendedBetTypes_AwayTeamLayOverGoals() {
        Double homeTeamScore = 2.3;
        Double awayTeamScore = 1.27;

        List<BetType> actual = BetRecommendationDecorator.deriveRecommendedBetTypes(homeTeamScore, awayTeamScore);

        assertThat(actual, containsInAnyOrder(OVER_1_HALF_GOALS, AWAY_LAY));
    }

    @Test
    public void buildRecommendedBetTypes_HomeTeamWinOverGoals() {
        Double homeTeamScore = 3.3;
        Double awayTeamScore = 1.27;

        List<BetType> actual = BetRecommendationDecorator.deriveRecommendedBetTypes(homeTeamScore, awayTeamScore);

        assertThat(actual, containsInAnyOrder(OVER_1_HALF_GOALS, HOME_WIN));
    }
}