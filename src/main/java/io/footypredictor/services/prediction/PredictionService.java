package io.footypredictor.services.prediction;

import io.footypredictor.model.prediction.Match;
import io.footypredictor.model.prediction.Predictions;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface PredictionService {

    Predictions predict(final String leagueId) throws JsonProcessingException;
    Predictions predict(List<Match> matches);
    Predictions retrievePredictions();

}
