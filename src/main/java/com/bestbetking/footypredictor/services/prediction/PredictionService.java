package com.bestbetking.footypredictor.services.prediction;

import com.bestbetking.footypredictor.model.prediction.Prediction;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface PredictionService {

    List<Prediction> predict(final String leagueId) throws JsonProcessingException;

}
