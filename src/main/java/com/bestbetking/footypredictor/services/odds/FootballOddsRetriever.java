package com.bestbetking.footypredictor.services.odds;

import com.bestbetking.footypredictor.configuration.OddsConfig;
import com.bestbetking.footypredictor.model.odds.OddsPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FootballOddsRetriever implements OddsRetriever {

    private static final String ODDS_API_KEY_PARAM = "&apiKey=";
    private static final String REGION_PARAM = "&region=uk";

    private RestTemplate restTemplate;
    private OddsConfig oddsConfig;

    @Autowired
    public FootballOddsRetriever(OddsConfig oddsConfig, RestTemplate restTemplate) {
        this.oddsConfig = oddsConfig;
        this.restTemplate = restTemplate;
    }


    @Override
    public List<OddsPayload> retrieveOdds() {
        List<OddsPayload> oddsPayloads = new ArrayList<>();
        //Call Odds API to get upcoming fixtures and odds (NB: swap out real service with stub for testing)
        oddsConfig.getLeagues().forEach(league -> {
                String url = constructURL(league);
                oddsPayloads.add(restTemplate.getForObject(url, OddsPayload.class));
                }
        );
        return oddsPayloads;
    }

    private String constructURL(final String league) {
        return oddsConfig.getApi() + "?sport=" + league + REGION_PARAM + ODDS_API_KEY_PARAM + oddsConfig.getApiKey();
    }
}
