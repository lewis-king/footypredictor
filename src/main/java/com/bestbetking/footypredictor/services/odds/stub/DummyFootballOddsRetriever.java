package com.bestbetking.footypredictor.services.odds.stub;

import com.bestbetking.footypredictor.model.odds.OddsPayload;
import com.bestbetking.footypredictor.services.odds.OddsRetriever;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DummyFootballOddsRetriever implements OddsRetriever {

    private final List<OddsPayload> oddsPayload;

    public DummyFootballOddsRetriever(final String... paths) throws IOException {
        oddsPayload = new ArrayList<>();

        for (String path : paths) {
            byte[] jsonData = Files.readAllBytes(Paths.get(path));

            ObjectMapper objectMapper = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            oddsPayload.add(objectMapper.readValue(jsonData, OddsPayload.class));
        }
    }

    @Override
    public List<OddsPayload> retrieveOdds() {
        return oddsPayload;
    }
}
