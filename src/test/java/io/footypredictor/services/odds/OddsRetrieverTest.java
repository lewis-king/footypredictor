package io.footypredictor.services.odds;

import io.footypredictor.model.odds.OddsPayload;
import io.footypredictor.services.odds.stub.DummyFootballOddsRetriever;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class OddsRetrieverTest {

    private final OddsRetriever oddsRetriever;

    public OddsRetrieverTest() throws IOException {
        oddsRetriever = new DummyFootballOddsRetriever("src/test/resources/odds_api_example.json");
    }

    @Test
    public void testOddsRetrieval() {
        List<OddsPayload> oddsPayloads = oddsRetriever.retrieveOdds("EO");
        OddsPayload oddsPayload = oddsPayloads.get(0);

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
