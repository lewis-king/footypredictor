package com.bestbetking.footypredictor.services.odds;

import com.bestbetking.footypredictor.configuration.OddsConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FootballOddsRetrieverTest {

    private static final List<String> LEAGUES = Arrays.asList("E1", "E2", "F1", "S1");
    private static final String API = "api-example.com";

    @Mock
    private RestTemplate mockRestTemplate;
    @Mock
    private OddsConfig oddsConfig;

    private final FootballOddsRetriever footballOddsRetriever;

    public FootballOddsRetrieverTest() {
        footballOddsRetriever = new FootballOddsRetriever(oddsConfig, mockRestTemplate);
    }


    @Test
    public void shouldRetrieveOdds() {

        footballOddsRetriever.retrieveOdds();
    }

}