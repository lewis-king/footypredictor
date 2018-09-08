package com.bestbetking.footypredictor.services.transformers;

import com.bestbetking.footypredictor.model.odds.OddsPayload;
import com.bestbetking.footypredictor.model.odds.Source;
import com.bestbetking.footypredictor.model.prediction.Match;
import com.bestbetking.footypredictor.services.mapping.TeamNamesMapping;

import java.util.ArrayList;
import java.util.List;

public class MatchesTransformer {

    public static List<Match> constructMatches(final OddsPayload oddsPayload) {
        final List<Match> matches = new ArrayList<>();

        oddsPayload.getEvents().stream().forEach(event -> {

            final Source filteredSource = event.getSources().stream()
                    .filter(source -> source.getSourceId().equals("paddypower")).findFirst().get();

            final String homeTeamName = TeamNamesMapping.getTeamNamesBySecondaryName(event.getHomeTeam()).getPrimaryName();
            final String awayTeamName = TeamNamesMapping.getTeamNamesBySecondaryName(event.getAwayTeam()).getPrimaryName();
            final int homeTeamIndex = event.getTeams().indexOf(event.getHomeTeam());
            final int awayTeamIndex = event.getTeams().indexOf(event.getAwayTeam());
            final Double homeWinOdds = filteredSource.getOdds().getMatchOdds().get(homeTeamIndex);
            final Double drawOdds = filteredSource.getOdds().getMatchOdds().get(2);
            final Double awayWinOdds = filteredSource.getOdds().getMatchOdds().get(awayTeamIndex);

            final Match match = new Match(homeTeamName, awayTeamName, homeWinOdds, drawOdds, awayWinOdds);
            matches.add(match);
        });

        return matches;
    }

}
