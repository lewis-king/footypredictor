package com.bestbetking.footypredictor.services.prediction;

import com.bestbetking.footypredictor.configuration.AppConfig;
import com.bestbetking.footypredictor.configuration.PredictionMLConfig;
import com.bestbetking.footypredictor.model.odds.OddsPayload;
import com.bestbetking.footypredictor.model.prediction.Match;
import com.bestbetking.footypredictor.model.prediction.Prediction;
import com.bestbetking.footypredictor.services.odds.OddsRetriever;
import com.bestbetking.footypredictor.services.transformers.MatchesTransformer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class FootballPredictionService implements PredictionService {

    @Autowired
    private final RestTemplate restTemplate;
    @Autowired
    private final OddsRetriever oddsRetriever;
    @Autowired
    private final PredictionMLConfig predictionMLConfig;

    public FootballPredictionService(RestTemplate restTemplate, OddsRetriever oddsRetriever, PredictionMLConfig predictionMLConfig) {
        this.restTemplate = restTemplate;
        this.oddsRetriever = oddsRetriever;
        this.predictionMLConfig = predictionMLConfig;
    }

    @Override
    public List<Prediction> predict(String leagueId) throws JsonProcessingException {

        final OddsPayload oddsPayload = oddsRetriever.retrieveOdds();
        List<Match> matches = MatchesTransformer.constructMatches(oddsPayload);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestPayload = new ObjectMapper().writeValueAsString(matches);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestPayload, headers);
        //Do I need to return array and then create List or can I just return a straight List!?
        final ResponseEntity<Prediction[]> predictions = restTemplate.exchange(predictionMLConfig.getUrl(), HttpMethod.POST, requestEntity, Prediction[].class, (Object) null);
        final List<Prediction> predictionList = Arrays.asList(predictions.getBody());
        return predictionList;
    }
}
