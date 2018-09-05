package com.bestbetking.footypredictor.services.transformers;

import com.bestbetking.footypredictor.services.odds.OddsRetriever;
import com.bestbetking.footypredictor.services.odds.stub.DummyFootballOddsRetriever;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MatchesTransformerTest {

    private final OddsRetriever oddsRetriever;

    public MatchesTransformerTest() throws IOException {
        this.oddsRetriever = new DummyFootballOddsRetriever();
    }

    @Test
    public void verifySizeOfConstructedMatches() {
        assertThat(MatchesTransformer.constructMatches(oddsRetriever.retrieveOdds()).size(), is(equalTo(13)));
    }
}