package io.footypredictor.services.odds;

import io.footypredictor.configuration.OddsConfig;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FootballOddsRetrieverTest {

    private static final List<String> LEAGUES = Arrays.asList("E0", "E1", "F1", "S1");
    private static final String API = "api-example.com";

    @Mock
    private RestTemplate mockRestTemplate;
    @Mock
    private OddsConfig oddsConfig;

    private final FootballOddsRetriever footballOddsRetriever;

    public FootballOddsRetrieverTest() {
        footballOddsRetriever = new FootballOddsRetriever(oddsConfig, mockRestTemplate);
    }


    @Ignore
    @Test
    public void shouldRetrieveOdds() {

        footballOddsRetriever.retrieveOdds("E0");
    }

}