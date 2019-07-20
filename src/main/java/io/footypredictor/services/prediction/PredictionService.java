package io.footypredictor.services.prediction;

import io.footypredictor.model.prediction.Predictions;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface PredictionService {

    Predictions predict(final String leagueId) throws JsonProcessingException;
    Predictions retrievePredictions();

}
