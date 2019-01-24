package com.bestbetking.footypredictor.services.transformers;

import com.bestbetking.footypredictor.model.prediction.Prediction;
import com.bestbetking.footypredictor.model.prediction.Predictions;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

import static java.util.Arrays.asList;
import static java.util.Collections.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PredictionsTransformerTest {

    @Test
    public void sortPredictionsByDateAsc() {
        //Given
        Prediction p1 = new Prediction("PL", "Team 1", "Team 2", 1d, 1d, LocalDateTime.now());
        Prediction p2 = new Prediction("PL", "Team 3", "Team 4", 1d, 1d, LocalDateTime.now().minusDays(1));
        Prediction p3 = new Prediction("PL", "Team 5", "Team 6", 1d, 1d, LocalDateTime.now().plusDays(1));
        //When
        Predictions predictions = new Predictions(asList(p1, p2, p3));
        PredictionsTransformer.sortPredictionsByDateAsc(predictions);
        //Then
        assertThat(predictions.getPredictions().get(0), is(p2));
        assertThat(predictions.getPredictions().get(1), is(p1));
        assertThat(predictions.getPredictions().get(2), is(p3));
    }
}