package com.bestbetking.footypredictor.services.prediction;

import com.bestbetking.footypredictor.model.prediction.Predictions;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface PredictionService {

    Predictions predict(final String leagueId) throws JsonProcessingException;

}
