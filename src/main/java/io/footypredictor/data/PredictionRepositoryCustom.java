package io.footypredictor.data;

import io.footypredictor.model.prediction.Prediction;

import java.util.List;

public interface PredictionRepositoryCustom {

    List<Prediction> retrieveLatestPredictions();

}
