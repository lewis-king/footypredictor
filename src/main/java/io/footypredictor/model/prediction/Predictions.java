package io.footypredictor.model.prediction;

import java.util.List;

public class Predictions {

    private final List<Prediction> predictions;

    public Predictions(List<Prediction> predictions) {
        this.predictions = predictions;
    }

    public Predictions(){
        this.predictions = null;
    }

    public List<Prediction> getPredictions() {
        return predictions;
    }
}
