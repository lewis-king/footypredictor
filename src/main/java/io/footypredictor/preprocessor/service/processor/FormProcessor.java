package io.footypredictor.preprocessor.service.processor;


import io.footypredictor.preprocessor.model.EnrichedFootballHistoricRecord;
import io.footypredictor.preprocessor.model.FootballHistoricRecord;

import java.util.*;

public class FormProcessor implements Processor {

    public List<EnrichedFootballHistoricRecord> enrich(List<EnrichedFootballHistoricRecord> footballData) {
        Collections.reverse(footballData);
        List<EnrichedFootballHistoricRecord> enrichedRecords = new LinkedList<>();
        for (int i = 0; i < footballData.size(); i++) {
            FootballHistoricRecord currentRecord = footballData.get(i);
            List<Integer> homeTeamOverallAggregatePoints = new ArrayList<>(3);
            List<Integer> homeTeamHomeAggregatePoints = new ArrayList<>(3);
            List<Integer> awayTeamOverallAggregatePoints = new ArrayList<>(3);
            List<Integer> awayTeamAwayAggregatePoints = new ArrayList<>(3);
            OptionalDouble calculatedOverallHomeTeamForm = OptionalDouble.empty();
            OptionalDouble calculatedOverallAwayTeamForm = OptionalDouble.empty();
            OptionalDouble calculatedHomeTeamHomeForm = OptionalDouble.empty();
            OptionalDouble calculatedAwayTeamAwayForm = OptionalDouble.empty();
            String homeTeam = footballData.get(i).getHomeTeam();
            String awayTeam = footballData.get(i).getAwayTeam();
            for (int j = i + 1; j < footballData.size(); j++) {
                if (homeTeam.equals(footballData.get(j).getHomeTeam())) {
                    Integer points = deriveHomeTeamPointsScored(footballData.get(j).getMatchResult());
                    homeTeamOverallAggregatePoints.add(points);
                    homeTeamHomeAggregatePoints.add(points);
                }
                if (homeTeam.equals(footballData.get(j).getAwayTeam())) {
                    homeTeamOverallAggregatePoints.add(deriveAwayTeamPointsScored(footballData.get(j).getMatchResult()));
                }
                if (awayTeam.equals(footballData.get(j).getAwayTeam())) {
                    Integer points = deriveAwayTeamPointsScored(footballData.get(j).getMatchResult());
                    awayTeamOverallAggregatePoints.add(points);
                    awayTeamAwayAggregatePoints.add(points);
                }
                if (awayTeam.equals(footballData.get(j).getHomeTeam())) {
                    awayTeamOverallAggregatePoints.add(deriveHomeTeamPointsScored(footballData.get(j).getMatchResult()));
                }
                if (homeTeamOverallAggregatePoints.size() == 3 && !calculatedOverallHomeTeamForm.isPresent()) {
                    calculatedOverallHomeTeamForm = OptionalDouble.of(homeTeamOverallAggregatePoints.stream().mapToInt(Integer::intValue).sum() / 9d);
                }
                if (awayTeamOverallAggregatePoints.size() == 3 && !calculatedOverallAwayTeamForm.isPresent()) {
                    calculatedOverallAwayTeamForm = OptionalDouble.of(awayTeamOverallAggregatePoints.stream().mapToInt(Integer::intValue).sum() / 9d);
                }
                if (homeTeamHomeAggregatePoints.size() == 3 && !calculatedHomeTeamHomeForm.isPresent()) {
                    calculatedHomeTeamHomeForm = OptionalDouble.of(homeTeamHomeAggregatePoints.stream().mapToInt(Integer::intValue).sum() / 9d);
                }
                if (awayTeamAwayAggregatePoints.size() == 3 && !calculatedAwayTeamAwayForm.isPresent()) {
                    calculatedAwayTeamAwayForm = OptionalDouble.of(awayTeamAwayAggregatePoints.stream().mapToInt(Integer::intValue).sum() / 9d);
                }
                if (calculatedOverallHomeTeamForm.isPresent() && calculatedOverallAwayTeamForm.isPresent() && calculatedHomeTeamHomeForm.isPresent() && calculatedAwayTeamAwayForm.isPresent()) {
                    break;
                }
            }
            if (!calculatedOverallHomeTeamForm.isPresent() && homeTeamOverallAggregatePoints.size() > 0) {
                calculatedOverallHomeTeamForm = OptionalDouble.of(homeTeamOverallAggregatePoints.stream().mapToInt(Integer::intValue).sum() / (double) (homeTeamOverallAggregatePoints.size() * 3));
            }
            if (!calculatedOverallAwayTeamForm.isPresent() && awayTeamOverallAggregatePoints.size() > 0) {
                calculatedOverallAwayTeamForm = OptionalDouble.of(awayTeamOverallAggregatePoints.stream().mapToInt(Integer::intValue).sum() / (double) (awayTeamOverallAggregatePoints.size() * 3));
            }
            if (!calculatedHomeTeamHomeForm.isPresent() && homeTeamHomeAggregatePoints.size() > 0) {
                calculatedHomeTeamHomeForm = OptionalDouble.of(homeTeamHomeAggregatePoints.stream().mapToInt(Integer::intValue).sum() / (double) (homeTeamHomeAggregatePoints.size() * 3));
            }
            if (!calculatedAwayTeamAwayForm.isPresent() && awayTeamAwayAggregatePoints.size() > 0) {
                calculatedAwayTeamAwayForm = OptionalDouble.of(awayTeamAwayAggregatePoints.stream().mapToInt(Integer::intValue).sum() / (double) (awayTeamAwayAggregatePoints.size() * 3));
            }

            EnrichedFootballHistoricRecord enrichedRecord = new EnrichedFootballHistoricRecord(currentRecord);
            enrichedRecord = enrichedRecord.setHomeTeamOverallForm(calculatedOverallHomeTeamForm.orElse(0.5))
                    .setAwayTeamOverallForm(calculatedOverallAwayTeamForm.orElse(0.5))
                    .setHomeTeamHomeForm(calculatedHomeTeamHomeForm.orElse(0.5))
                    .setAwayTeamAwayForm(calculatedAwayTeamAwayForm.orElse(0.5))
                    .build();
            enrichedRecords.add(enrichedRecord);
        }
        Collections.reverse(enrichedRecords);
        return enrichedRecords;
    }

    private static Integer deriveHomeTeamPointsScored(Character matchResult) {
        if (matchResult.equals('H')) return 3;
        if (matchResult.equals('A')) return 0;
        if (matchResult.equals('D')) return 1;
        throw new IllegalArgumentException("Could not derive points scored from match result");
    }

    private static Integer deriveAwayTeamPointsScored(Character matchResult) {
        if (matchResult.equals('A')) return 3;
        if (matchResult.equals('H')) return 0;
        if (matchResult.equals('D')) return 1;
        throw new IllegalArgumentException("Could not derive points scored from match result");
    }

}
