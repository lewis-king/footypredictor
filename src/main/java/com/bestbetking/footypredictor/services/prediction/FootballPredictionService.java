package com.bestbetking.footypredictor.services.prediction;

import com.bestbetking.footypredictor.configuration.PredictionMLConfig;
import com.bestbetking.footypredictor.data.PredictionRepository;
import com.bestbetking.footypredictor.model.odds.Event;
import com.bestbetking.footypredictor.model.odds.OddsPayload;
import com.bestbetking.footypredictor.model.prediction.Match;
import com.bestbetking.footypredictor.model.prediction.Predictions;
import com.bestbetking.footypredictor.services.odds.OddsRetriever;
import com.bestbetking.footypredictor.services.odds.stub.DummyFootballOddsRetriever;
import com.bestbetking.footypredictor.services.transformers.MatchesTransformer;
import com.bestbetking.footypredictor.services.transformers.PredictionsTransformer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FootballPredictionService implements PredictionService {

    private final RestTemplate restTemplate;
    private final OddsRetriever oddsRetriever;
    private final PredictionRepository predictionRepository;
    private final PredictionMLConfig predictionMLConfig;

    @Autowired
    public FootballPredictionService(RestTemplate restTemplate, OddsRetriever oddsRetriever, PredictionRepository predictionRepository, PredictionMLConfig predictionMLConfig) {
        this.restTemplate = restTemplate;
        this.oddsRetriever = oddsRetriever;
        this.predictionRepository = predictionRepository;
        this.predictionMLConfig = predictionMLConfig;
    }

    @Override
    public Predictions predict(String leagueId) throws JsonProcessingException {

        final List<OddsPayload> oddsPayloads = oddsRetriever.retrieveOdds();
        List<Match> matches = MatchesTransformer.constructMatches(oddsPayloads);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestPayload = new ObjectMapper().writeValueAsString(matches);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestPayload, headers);
        final ResponseEntity<Predictions> predictionsResponse = restTemplate.exchange(predictionMLConfig.getApi(), HttpMethod.POST, requestEntity, Predictions.class, (Object) null);
        List<Event> events = oddsPayloads.stream().map(oddsPayload -> oddsPayload.getEvents())
                .flatMap(e -> e.stream()).collect(Collectors.toList());
        final Predictions predictions = PredictionsTransformer.enrichPredictions(events, predictionsResponse.getBody());

        predictionRepository.saveAll(predictions.getPredictions());

        return predictions;
    }
}
