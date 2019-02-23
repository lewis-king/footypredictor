package com.bestbetking.footypredictor.data;

import com.bestbetking.footypredictor.model.prediction.Prediction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface PredictionRepository extends MongoRepository<Prediction, String>, PredictionRepositoryCustom {
}
