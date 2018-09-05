package com.bestbetking.footypredictor.services.odds;

import com.bestbetking.footypredictor.model.odds.OddsPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class FootballOddsRetriever implements OddsRetriever {

    @Autowired
    private RestTemplate restTemplate;



    @Override
    public OddsPayload retrieveOdds() {
        //Call Odds API to get upcoming fixtures and odds (NB: swap out real service with stub for testing)

        return null;
    }
}
