package com.bestbetking.footypredictor.services.mapping;

import java.util.Arrays;
import java.util.HashMap;

public enum TeamNamesMapping {

    ARSENAL("Arsenal", "Arsenal"),
    BRIGHTON("Brighton", "Brighton and Hove Albion"),
    CHELSEA("Chelsea", "Chelsea"),
    CRYSTAL_PALACE("Crystal Palace", "Crystal Palace"),
    EVERTON("Everton", "Everton"),
    SOUTHAMPTON("Southampton", "Southampton"),
    WATFORD("Watford", "Watford"),
    WEST_BROM("West Brom", ""),
    MAN_UNITED("Man United", "Manchester United"),
    MAN_CITY("Man City", "Manchester City"),
    NEWCASTLE("Newcastle", "Newcastle United"),
    BOURNEMOUTH("Bournemouth", "Bournemouth"),
    BURNLEY("Burnley", "Burnley"),
    LEICESTER("Leicester", "Leicester City"),
    TOTTENHAM("Tottenham", "Tottenham Hotspur"),
    LIVERPOOL("Liverpool", "Liverpool"),
    WEST_HAM("West Ham", "West Ham United"),
    HUDDERSFIELD("Huddersfield", "Huddersfield Town"),
    CARDIFF("Cardiff", "Cardiff City"),
    WOLVES("Wolves", "Wolverhampton Wanderers"),
    FULHAM("Fulham", "Fulham")
    ;

    private final String primaryName;
    private final String secondaryName;

    private static final HashMap<String, TeamNamesMapping> teamNamesKeyedBySecondaryName = new HashMap<>();
    private static final HashMap<String, TeamNamesMapping> teamNamesKeyedByPrimaryName = new HashMap<>();

    static {
        Arrays.asList(TeamNamesMapping.values()).stream().forEach(teamNameMapping -> {
            teamNamesKeyedByPrimaryName.put(teamNameMapping.primaryName, teamNameMapping);
            teamNamesKeyedBySecondaryName.put(teamNameMapping.secondaryName, teamNameMapping);
        });
    }

    TeamNamesMapping(String primaryName, String secondaryName) {
        this.primaryName = primaryName;
        this.secondaryName = secondaryName;
    }

    public String getPrimaryName() {
        return primaryName;
    }

    public String getSecondaryName() {
        return secondaryName;
    }

    public static TeamNamesMapping getTeamNamesBySecondaryName(final String secondaryName) {
        final TeamNamesMapping lookedUp = teamNamesKeyedBySecondaryName.get(secondaryName);
        if (lookedUp == null) {
            throw new IllegalArgumentException("Unable to lookup Team by secondary name: " +secondaryName);
        }
        return lookedUp;

    }

    public static TeamNamesMapping getTeamNamesByPrimaryName(final String primaryName) {
        final TeamNamesMapping lookedUp = teamNamesKeyedByPrimaryName.get(primaryName);
        if (lookedUp == null) {
            throw new IllegalArgumentException("Unable to lookup Team by primary name: " +primaryName);
        }
        return lookedUp;
    }
}
