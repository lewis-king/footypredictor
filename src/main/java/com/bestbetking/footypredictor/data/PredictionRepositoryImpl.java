package com.bestbetking.footypredictor.data;

import com.bestbetking.footypredictor.model.prediction.Prediction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PredictionRepositoryImpl implements PredictionRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public PredictionRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Prediction> retrieveLatestPredictions() {
        final Query query = new Query();
        final List<Criteria> criteria = new ArrayList<>();
        criteria.add(Criteria.where("startTime").gte(LocalDateTime.now()));
        query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
        return mongoTemplate.find(query, Prediction.class);
    }
}
