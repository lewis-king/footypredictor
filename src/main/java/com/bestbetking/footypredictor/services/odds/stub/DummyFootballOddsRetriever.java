package com.bestbetking.footypredictor.services.odds.stub;

import com.bestbetking.footypredictor.model.odds.OddsPayload;
import com.bestbetking.footypredictor.services.odds.OddsRetriever;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DummyFootballOddsRetriever implements OddsRetriever {

    private final OddsPayload oddsPayload;

    public DummyFootballOddsRetriever() throws IOException {

        byte[] jsonData = Files.readAllBytes(Paths.get("src/test/resources/odds_api_example.json"));

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        oddsPayload = objectMapper.readValue(jsonData, OddsPayload.class);
    }

    @Override
    public OddsPayload retrieveOdds() {
        return oddsPayload;
    }
}
