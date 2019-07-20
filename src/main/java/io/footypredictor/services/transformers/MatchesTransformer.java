package io.footypredictor.services.transformers;

import io.footypredictor.model.odds.OddsPayload;
import io.footypredictor.model.odds.Source;
import io.footypredictor.model.prediction.Match;
import io.footypredictor.services.mapping.League;
import io.footypredictor.services.mapping.TeamNamesMapping;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatchesTransformer {

    public static List<Match> constructMatches(final List<OddsPayload> oddsPayloads) {
        final List<Match> matches = new ArrayList<>();

        //The lambda code using Optional and orElse is to defend against when oddsPayload.getEvents() is null
        oddsPayloads.stream().forEach(oddsPayload -> Optional.ofNullable(oddsPayload.getEvents()).map(Collection::stream).orElse(Stream.empty()).filter(Objects::nonNull).forEach(event -> {
        try {
            final Source filteredSource = event.getSources().stream()
                    .filter(source -> source.getSourceId().equals("paddypower") || source.getSourceId().equals("skybet")).findFirst().get();
            if (event.getStartTime().isBefore(LocalDateTime.now().plusWeeks(10))) {
                if (event.getHomeTeam() != "" && event.getAwayTeam() != "") {
                    final String homeTeamName = TeamNamesMapping.getTeamNamesBySecondaryName(event.getHomeTeam()).getPrimaryName();
                    final String awayTeamName = TeamNamesMapping.getTeamNamesBySecondaryName(event.getAwayTeam()).getPrimaryName();
                    final String league = League.getLeagueByThirdPartyKey(event.getLeague()).getLeagueKey();
                    final int homeTeamIndex = event.getTeams().indexOf(event.getHomeTeam());
                    final int awayTeamIndex = event.getTeams().indexOf(event.getAwayTeam());
                    final Double homeWinOdds = filteredSource.getOdds().getMatchOdds().get(homeTeamIndex);
                    final Double drawOdds = filteredSource.getOdds().getMatchOdds().get(2);
                    final Double awayWinOdds = filteredSource.getOdds().getMatchOdds().get(awayTeamIndex);

                    final Match match = new Match(league, homeTeamName, awayTeamName, homeWinOdds, drawOdds, awayWinOdds);
                    if (!teamAlreadyExistsInMatches(matches, homeTeamName, awayTeamName)) {
                        matches.add(match);
                    }
                }
            }
        } catch (NoSuchElementException ex) {
            //Not doing anything atm, just continue
        }
        }));

        return matches;
    }

    private static boolean teamAlreadyExistsInMatches(List<Match> matches, String homeTeam, String awayTeam) {
        if (matches.stream().map(Match::getHomeTeam).collect(Collectors.toList()).contains(homeTeam)
                || matches.stream().map(Match::getAwayTeam).collect(Collectors.toList()).contains(homeTeam)
                || matches.stream().map(Match::getHomeTeam).collect(Collectors.toList()).contains(awayTeam)
                || matches.stream().map(Match::getAwayTeam).collect(Collectors.toList()).contains(awayTeam)) {
            return true;
        }
        return false;
    }

}
