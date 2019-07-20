package io.footypredictor.services.odds;

import io.footypredictor.model.odds.OddsPayload;

import java.util.List;

public interface OddsRetriever {

    List<OddsPayload> retrieveOdds(String league);

}
