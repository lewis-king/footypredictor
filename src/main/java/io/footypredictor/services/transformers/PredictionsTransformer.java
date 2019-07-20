package io.footypredictor.services.transformers;

import io.footypredictor.model.odds.Event;
import io.footypredictor.model.prediction.Predictions;
import io.footypredictor.services.mapping.League;
import io.footypredictor.services.mapping.TeamNamesMapping;
import io.footypredictor.services.recommendation.BetRecommendationDecorator;

import java.util.Comparator;
import java.util.List;

public class PredictionsTransformer {

    public static Predictions enrichPredictions(final List<Event> events, final Predictions predictions) {
        predictions.getPredictions().stream().forEach(prediction -> {
            final Event associatedEvent = events.stream().filter(event -> event.getHomeTeam() != "" && event.getAwayTeam() != "").filter(event ->
                    TeamNamesMapping.getTeamNamesBySecondaryName(event.getHomeTeam()).getPrimaryName().equals(prediction.getHomeTeam()) && TeamNamesMapping.getTeamNamesBySecondaryName(event.getAwayTeam()).getPrimaryName().equals(prediction.getAwayTeam())).findFirst().get();
            prediction.setStartTime(associatedEvent.getStartTime());
            prediction.setLeague(League.getLeagueByThirdPartyKey(associatedEvent.getLeague()).getLeagueDisplayName());
            prediction.setRecommendedBets(BetRecommendationDecorator.deriveRecommendedBetTypes(prediction.getHomeTeamScore(), prediction.getAwayTeamScore()));
        });
        sortPredictionsByDateAsc(predictions);
        return predictions;
    }

    public static void sortPredictionsByDateAsc(final Predictions predictions) {
        predictions.getPredictions().sort(Comparator.comparing(prediction -> prediction.getStartTime()));
    }

}
