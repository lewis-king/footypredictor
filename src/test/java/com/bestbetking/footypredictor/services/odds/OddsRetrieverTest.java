package com.bestbetking.footypredictor.services.odds;

import com.bestbetking.footypredictor.model.odds.OddsPayload;
import com.bestbetking.footypredictor.services.odds.stub.DummyFootballOddsRetriever;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class OddsRetrieverTest {

    private final OddsRetriever oddsRetriever;

    public OddsRetrieverTest() throws IOException {
        oddsRetriever = new DummyFootballOddsRetriever();
    }

    @Test
    public void testOddsRetrieval() {
        OddsPayload oddsPayload = oddsRetriever.retrieveOdds();

        assertThat(oddsPayload.getEvents().size(), is(13));
        assertThat(oddsPayload.isSuccess(), is(true));
        assertThat(oddsPayload.getEvents().get(0).getStartTime(), is(notNullValue()));
        assertThat(oddsPayload.getEvents().get(0).getHomeTeam(), is(equalTo("Cardiff City")));
        assertThat(oddsPayload.getEvents().get(0).getAwayTeam(), is(equalTo("Arsenal")));
        assertThat(oddsPayload.getEvents().get(0).getStartTime(), is(equalTo(LocalDateTime.of(2018, 9, 02, 13, 30))));
        assertThat(oddsPayload.getEvents().get(0).getSources().get(1).getSourceId(), is(equalTo("paddypower")));
        assertThat(oddsPayload.getEvents().get(0).getSources().get(1).getOdds().getMatchOdds().get(0), is(equalTo(1.53)));
        assertThat(oddsPayload.getEvents().get(0).getSources().get(1).getOdds().getMatchOdds().get(1), is(equalTo(6.0)));
        assertThat(oddsPayload.getEvents().get(0).getSources().get(1).getOdds().getMatchOdds().get(2), is(equalTo(4.33)));
    }

}
