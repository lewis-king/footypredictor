package io.footypredictor.preprocessor.service.processor;


import io.footypredictor.preprocessor.model.EnrichedFootballHistoricRecord;
import io.footypredictor.preprocessor.model.FootballHistoricRecord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class AvgGoalsScoredAndConcededProcessor implements Processor {

    @Override
    public List<EnrichedFootballHistoricRecord> enrich(List<EnrichedFootballHistoricRecord> footballData) {
        List<EnrichedFootballHistoricRecord> enrichedFootballHistoricRecords = new ArrayList<>();
        Collections.reverse(footballData);
        for (int i = 0; i < footballData.size(); i++) {
            String homeTeam = footballData.get(i).getHomeTeam();
            String awayTeam = footballData.get(i).getAwayTeam();

            List<EnrichedFootballHistoricRecord> limitedRecords = footballData.stream().skip(i + 1).limit(footballData.size() - i).collect(Collectors.toList());
            OptionalDouble avgHomeTeamGoalsScoredHome = limitedRecords.stream().filter(record -> record.getHomeTeam().equals(homeTeam)).mapToInt(FootballHistoricRecord::getHomeTeamGoalsScored).average();
            OptionalDouble avgHomeTeamGoalsConcededHome = limitedRecords.stream().filter(record -> record.getHomeTeam().equals(homeTeam)).mapToInt(FootballHistoricRecord::getAwayTeamGoalsScored).average();
            OptionalDouble avgAwayTeamGoalsScoredAway = limitedRecords.stream().filter(record -> record.getAwayTeam().equals(awayTeam)).mapToInt(FootballHistoricRecord::getAwayTeamGoalsScored).average();
            OptionalDouble avgAwayTeamGoalsConcededAway = limitedRecords.stream().filter(record -> record.getAwayTeam().equals(awayTeam)).mapToInt(FootballHistoricRecord::getHomeTeamGoalsScored).average();
            OptionalDouble avgHomeTeamGoalsScoredOverall = limitedRecords.stream().filter(record -> record.getHomeTeam().equals(homeTeam) || record.getAwayTeam().equals(homeTeam)).mapToInt(record -> record.getHomeTeam().equals(homeTeam) ? record.getHomeTeamGoalsScored() : record.getAwayTeamGoalsScored()).average();
            OptionalDouble avgHomeTeamGoalsConcededOverall = limitedRecords.stream().filter(record -> record.getHomeTeam().equals(homeTeam) || record.getAwayTeam().equals(homeTeam)).mapToInt(record -> record.getHomeTeam().equals(homeTeam) ? record.getAwayTeamGoalsScored() : record.getHomeTeamGoalsScored()).average();
            OptionalDouble avgAwayTeamGoalsScoredOverall = limitedRecords.stream().filter(record -> record.getAwayTeam().equals(awayTeam) || record.getHomeTeam().equals(awayTeam)).mapToInt(record -> record.getAwayTeam().equals(awayTeam) ? record.getAwayTeamGoalsScored() : record.getHomeTeamGoalsScored()).average();
            OptionalDouble avgAwayTeamGoalsConcededOverall = limitedRecords.stream().filter(record -> record.getAwayTeam().equals(awayTeam) || record.getHomeTeam().equals(awayTeam)).mapToInt(record -> record.getAwayTeam().equals(awayTeam) ? record.getHomeTeamGoalsScored() : record.getAwayTeamGoalsScored()).average();

            //TODO: DEFO WANT THIS AS THIS IS GOALS SCORED FORM WHEREAS CURRENTLY WE ONLY CALCULATE BASED ON ENTIRE SEASON TO DATE
            //Need to just calculate based on last 3 games.. hopefully can keep to a functional style
            List<EnrichedFootballHistoricRecord> last3RecordsHomeTeamHome = footballData.stream().skip(i + 1).filter(data -> data.getHomeTeam().equals(homeTeam)).limit(3).collect(Collectors.toList());
            List<EnrichedFootballHistoricRecord> last3RecordsAwayTeamAway = footballData.stream().skip(i + 1).filter(data -> data.getAwayTeam().equals(awayTeam)).limit(3).collect(Collectors.toList());
            List<EnrichedFootballHistoricRecord> last3RecordsHomeTeamOverall = footballData.stream().skip(i + 1).filter(data -> data.getHomeTeam().equals(homeTeam) || data.getAwayTeam().equals(homeTeam)).limit(3).collect(Collectors.toList());
            List<EnrichedFootballHistoricRecord> last3RecordsAwayTeamOverall = footballData.stream().skip(i + 1).filter(data -> data.getAwayTeam().equals(awayTeam) || data.getHomeTeam().equals(awayTeam)).limit(3).collect(Collectors.toList());
            OptionalDouble avgHomeTeamGoalsScoredHomeLast3 = last3RecordsHomeTeamHome.stream().mapToInt(FootballHistoricRecord::getHomeTeamGoalsScored).average();
            OptionalDouble avgHomeTeamGoalsConcededHomeLast3 = last3RecordsHomeTeamHome.stream().mapToInt(FootballHistoricRecord::getAwayTeamGoalsScored).average();
            OptionalDouble avgAwayTeamGoalsScoredAwayLast3 = last3RecordsAwayTeamAway.stream().mapToInt(FootballHistoricRecord::getAwayTeamGoalsScored).average();
            OptionalDouble avgAwayTeamGoalsConcededAwayLast3 = last3RecordsAwayTeamAway.stream().mapToInt(FootballHistoricRecord::getHomeTeamGoalsScored).average();
            OptionalDouble avgHomeTeamGoalsScoredOverallLast3 = last3RecordsHomeTeamOverall.stream().mapToInt(data -> data.getHomeTeam().equals(homeTeam) ? data.getHomeTeamGoalsScored() : data.getAwayTeamGoalsScored()).average();
            OptionalDouble avgHomeTeamGoalsConcededOverallLast3 = last3RecordsHomeTeamOverall.stream().mapToInt(data -> data.getHomeTeam().equals(homeTeam) ? data.getAwayTeamGoalsScored() : data.getHomeTeamGoalsScored()).average();
            OptionalDouble avgAwayTeamGoalsScoredOverallLast3 = last3RecordsAwayTeamOverall.stream().mapToInt(data -> data.getAwayTeam().equals(awayTeam) ? data.getAwayTeamGoalsScored() : data.getHomeTeamGoalsScored()).average();
            OptionalDouble avgAwayTeamGoalsConcededOverallLast3 = last3RecordsAwayTeamOverall.stream().mapToInt(data -> data.getAwayTeam().equals(awayTeam) ? data.getHomeTeamGoalsScored() : data.getAwayTeamGoalsScored()).average();


            EnrichedFootballHistoricRecord enrichedFootballHistoricRecord = footballData.get(i);
            enrichedFootballHistoricRecord
                    .setHomeTeamAverageGoalsScoredHome(avgHomeTeamGoalsScoredHome.orElse(0d))
                    .setHomeTeamAverageGoalsConcededHome(avgHomeTeamGoalsConcededHome.orElse(0d))
                    .setAwayTeamAverageGoalsScoredAway(avgAwayTeamGoalsScoredAway.orElse(0d))
                    .setAwayTeamAverageGoalsConcededAway(avgAwayTeamGoalsConcededAway.orElse(0d))
                    .setHomeTeamAverageGoalsScoredOverall(avgHomeTeamGoalsScoredOverall.orElse(0d))
                    .setHomeTeamAverageGoalsConcededOverall(avgHomeTeamGoalsConcededOverall.orElse(0d))
                    .setAwayTeamAverageGoalsScoredOverall(avgAwayTeamGoalsScoredOverall.orElse(0d))
                    .setAwayTeamAverageGoalsConcededOverall(avgAwayTeamGoalsConcededOverall.orElse(0d))

                    .setHomeTeamAverageGoalsScoredHomeForm(avgHomeTeamGoalsScoredHomeLast3.orElse(0d))
                    .setHomeTeamAverageGoalsConcededHomeForm(avgHomeTeamGoalsConcededHomeLast3.orElse(0d))
                    .setAwayTeamAverageGoalsScoredAwayForm(avgAwayTeamGoalsScoredAwayLast3.orElse(0d))
                    .setAwayTeamAverageGoalsConcededAwayForm(avgAwayTeamGoalsConcededAwayLast3.orElse(0d))
                    .setHomeTeamAverageGoalsScoredOverallForm(avgHomeTeamGoalsScoredOverallLast3.orElse(0d))
                    .setHomeTeamAverageGoalsConcededOverallForm(avgHomeTeamGoalsConcededOverallLast3.orElse(0d))
                    .setAwayTeamAverageGoalsScoredOverallForm(avgAwayTeamGoalsScoredOverallLast3.orElse(0d))
                    .setAwayTeamAverageGoalsConcededOverallForm(avgAwayTeamGoalsConcededOverallLast3.orElse(0d))
                    .build();
            enrichedFootballHistoricRecords.add(enrichedFootballHistoricRecord);
        }
        Collections.reverse(enrichedFootballHistoricRecords);
        return enrichedFootballHistoricRecords;
    }
}
