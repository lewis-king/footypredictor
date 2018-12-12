package com.bestbetking.footypredictor.controllers;

import com.bestbetking.footypredictor.model.prediction.Prediction;
import com.bestbetking.footypredictor.model.prediction.Predictions;
import com.bestbetking.footypredictor.services.prediction.PredictionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "predictions")
public class PredictionController {

    @Autowired
    private final PredictionService predictionService;

    public PredictionController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }

    @RequestMapping(value = "/{leagueId}", method = RequestMethod.GET)
    public List<Prediction> getPredictions(@PathVariable("leagueId") String leagueId) {

        return Arrays.asList(new Prediction("Premier League", "Crystal Palace", "Man United", 5d, 0d, LocalDateTime.now()));
    }

    @RequestMapping(value = "/generatePredictions/{leagueId}/{pwd}", method = RequestMethod.POST)
    public Predictions generatePredictions(@PathVariable("leagueId") String leagueId,
                                           @PathVariable("pwd") String pwd) throws IllegalAccessException, JsonProcessingException {
        //Temporary check to ensure not any Tom, Dick, or Harry can invoke this resource.
        //In future will add proper authorization
        if (!"lking".equals(pwd)) {
            throw new IllegalAccessException();
        }
        Predictions predictions = predictionService.predict(leagueId);
        return predictions;
    }

    @RequestMapping(method={RequestMethod.GET})
    public String index() {
        return "index";
    }

}
