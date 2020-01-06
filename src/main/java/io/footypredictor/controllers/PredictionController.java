package io.footypredictor.controllers;

import io.footypredictor.model.prediction.Match;
import io.footypredictor.model.prediction.Predictions;
import io.footypredictor.services.prediction.PredictionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "predictions")
public class PredictionController {

    @Autowired
    private final PredictionService predictionService;
    @Autowired
    private Environment env;

    public PredictionController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }

    @RequestMapping(value = "/generatePredictions/{leagueId}/{pwd}", method = RequestMethod.POST)
    public Predictions generatePredictions(@PathVariable("leagueId") String leagueId,
                                           @PathVariable("pwd") String pwd) throws IllegalAccessException, JsonProcessingException {
        //Temporary check to ensure not any Tom, Dick, or Harry can invoke this resource.
        //Will add a proper auth filter in the future, but this will do for now.
        if (!env.getProperty("footypredictor.admin.password").equals(pwd)) {
            throw new IllegalAccessException();
        }
        Predictions predictions = predictionService.predict(leagueId);
        return predictions;
    }

    @RequestMapping(value = "/generatePredictionsGivenFixtures", method = RequestMethod.POST)
    public Predictions generatePredictions(@RequestBody List<Match> matches) {
        return predictionService.predict(matches);
    }

    @RequestMapping(value = "/latest", method = RequestMethod.GET)
    public Predictions retrieveLatestPredictions() {
        return predictionService.retrievePredictions();
    }



}
