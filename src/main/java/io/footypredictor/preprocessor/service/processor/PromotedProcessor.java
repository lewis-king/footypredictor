package io.footypredictor.preprocessor.service.processor;


import io.footypredictor.preprocessor.constants.PromotedTeams;
import io.footypredictor.preprocessor.model.EnrichedFootballHistoricRecord;

import java.util.ArrayList;
import java.util.List;

public class PromotedProcessor implements Processor {

    @Override
    public List<EnrichedFootballHistoricRecord> enrich(List<EnrichedFootballHistoricRecord> footballData) {
        final int year = footballData.get(0).getDate().getYear();
        List<EnrichedFootballHistoricRecord> enrichedFootballHistoricRecords = new ArrayList<>();
        footballData.stream().forEach(data -> {
            EnrichedFootballHistoricRecord record = data;
            Boolean wasHomeTeamPromoted = deriveWasTeamPromoted(year, data.getHomeTeam());
            Boolean wasAwayTeamPromoted = deriveWasTeamPromoted(year, data.getAwayTeam());
            record.setHomeTeamWasPromoted(wasHomeTeamPromoted).setAwayTeamWasPromoted(wasAwayTeamPromoted).build();
            enrichedFootballHistoricRecords.add(record);
        });
        return enrichedFootballHistoricRecords;
    }

    private Boolean deriveWasTeamPromoted(int year, String team) {
        return PromotedTeams.PROMOTED_TEAMS_BY_YEAR.get(year).contains(team);
    }
}
