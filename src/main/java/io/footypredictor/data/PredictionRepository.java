package io.footypredictor.data;

import io.footypredictor.model.prediction.Prediction;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PredictionRepository extends MongoRepository<Prediction, String>, PredictionRepositoryCustom {
}
