package io.footypredictor.services.prediction;

import io.footypredictor.configuration.OddsConfig;
import io.footypredictor.configuration.PredictionMLConfig;
import io.footypredictor.data.PredictionRepository;
import io.footypredictor.model.odds.Event;
import io.footypredictor.model.odds.OddsPayload;
import io.footypredictor.model.prediction.Match;
import io.footypredictor.model.prediction.Predictions;
import io.footypredictor.preprocessor.model.EnrichedFootballHistoricRecord;
import io.footypredictor.preprocessor.service.NewPredictionsDataPreProcessor;
import io.footypredictor.services.odds.OddsRetriever;
import io.footypredictor.services.odds.stub.DummyFootballOddsRetriever;
import io.footypredictor.services.recommendation.BetRecommendationDecorator;
import io.footypredictor.services.transformers.MatchesTransformer;
import io.footypredictor.services.transformers.PredictionsTransformer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FootballPredictionService implements PredictionService {

    private final RestTemplate restTemplate;
    private OddsRetriever oddsRetriever;
    private final PredictionRepository predictionRepository;
    private final PredictionMLConfig predictionMLConfig;
    private final OddsConfig oddsConfig;
    private final NewPredictionsDataPreProcessor newPredictionsDataPreProcessor;

    @Autowired
    public FootballPredictionService(RestTemplate restTemplate, OddsRetriever oddsRetriever, PredictionRepository predictionRepository, PredictionMLConfig predictionMLConfig, OddsConfig oddsConfig, NewPredictionsDataPreProcessor newPredictionsDataPreProcessor) throws IOException {
        this.restTemplate = restTemplate;
        this.oddsRetriever = oddsRetriever;
        //this.oddsRetriever = new DummyFootballOddsRetriever("/Users/lking/Workspace/footypredictor/src/test/resources/test-odds-data/sample.json");
        this.predictionRepository = predictionRepository;
        this.predictionMLConfig = predictionMLConfig;
        this.oddsConfig = oddsConfig;
        this.newPredictionsDataPreProcessor = newPredictionsDataPreProcessor;
    }

    @Override
    public Predictions predict(String leagueId) throws JsonProcessingException {

        List<OddsPayload> oddsPayloads = new ArrayList<>();
        List<EnrichedFootballHistoricRecord> overallEnrichedFootballMatches = new ArrayList<>();
        oddsConfig.getLeagues().forEach(league -> {
            oddsPayloads.addAll(oddsRetriever.retrieveOdds(league));
            List<Match> matches = MatchesTransformer.constructMatches(oddsPayloads);
            List<EnrichedFootballHistoricRecord> enrichedFootballData = newPredictionsDataPreProcessor.enrichFootballData(matches);
            overallEnrichedFootballMatches.addAll(enrichedFootballData);
        });

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestPayload = new ObjectMapper().writeValueAsString(overallEnrichedFootballMatches);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestPayload, headers);
        final ResponseEntity<Predictions> predictionsResponse = restTemplate.exchange(predictionMLConfig.getApi(), HttpMethod.POST, requestEntity, Predictions.class, (Object) null);
        List<Event> events = oddsPayloads.stream().map(oddsPayload -> oddsPayload.getEvents())
                .flatMap(e -> e.stream()).collect(Collectors.toList());
        final Predictions predictions = PredictionsTransformer.enrichPredictions(events, predictionsResponse.getBody());

        predictionRepository.saveAll(predictions.getPredictions());

        return predictions;
    }

    @Override
    public Predictions retrievePredictions() {
        return new Predictions(BetRecommendationDecorator.deriveRecommendedBetTypes(predictionRepository.retrieveLatestPredictions()));
    }
}
