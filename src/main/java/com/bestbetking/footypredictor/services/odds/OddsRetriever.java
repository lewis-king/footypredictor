package com.bestbetking.footypredictor.services.odds;

import com.bestbetking.footypredictor.model.odds.OddsPayload;

import java.util.List;

public interface OddsRetriever {

    List<OddsPayload> retrieveOdds();

}
