package io.footypredictor.services.transformers;

import io.footypredictor.services.odds.OddsRetriever;
import io.footypredictor.services.odds.stub.DummyFootballOddsRetriever;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MatchesTransformerTest {

    private final OddsRetriever oddsRetriever;

    public MatchesTransformerTest() throws IOException {
        this.oddsRetriever = new DummyFootballOddsRetriever("src/test/resources/odds_api_example.json");
    }

    @Test
    public void verifySizeOfConstructedMatches() {
        assertThat(MatchesTransformer.constructMatches(oddsRetriever.retrieveOdds("E0")).size(), is(equalTo(13)));
    }
}