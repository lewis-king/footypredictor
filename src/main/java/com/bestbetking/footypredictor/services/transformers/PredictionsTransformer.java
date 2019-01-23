package com.bestbetking.footypredictor.services.transformers;

import com.bestbetking.footypredictor.model.odds.Event;
import com.bestbetking.footypredictor.model.prediction.Predictions;
import com.bestbetking.footypredictor.services.mapping.League;
import com.bestbetking.footypredictor.services.mapping.TeamNamesMapping;

import java.util.Comparator;
import java.util.List;

public class PredictionsTransformer {

    public static Predictions enrichPredictions(final List<Event> events, final Predictions predictions) {
        predictions.getPredictions().stream().forEach(prediction -> {
            final Event associatedEvent = events.stream().filter(event ->
                    TeamNamesMapping.getTeamNamesBySecondaryName(event.getHomeTeam()).getPrimaryName().equals(prediction.getHomeTeam()) && TeamNamesMapping.getTeamNamesBySecondaryName(event.getAwayTeam()).getPrimaryName().equals(prediction.getAwayTeam())).findFirst().get();
            prediction.setStartTime(associatedEvent.getStartTime());
            prediction.setLeague(League.getLeagueByThirdPartyKey(associatedEvent.getLeague()).getLeagueDisplayName());
        });
        sortPredictionsByDateAsc(predictions);
        return predictions;
    }

    public static void sortPredictionsByDateAsc(final Predictions predictions) {
        predictions.getPredictions().sort(Comparator.comparing(prediction -> prediction.getStartTime()));
    }

}
