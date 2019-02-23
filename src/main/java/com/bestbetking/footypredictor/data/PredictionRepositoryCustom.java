package com.bestbetking.footypredictor.data;

import com.bestbetking.footypredictor.model.prediction.Prediction;

import java.util.List;

public interface PredictionRepositoryCustom {

    List<Prediction> retrieveLatestPredictions();

}
