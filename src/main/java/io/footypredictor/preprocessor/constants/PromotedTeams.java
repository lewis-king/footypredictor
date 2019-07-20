package io.footypredictor.preprocessor.constants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Promoted Teams is used for building a new feature during pre processing of the current season.
 * It will be used in place of using the actual home team name/indexes during feature generation.
 * Or I must build the first records in the current season for model generation although there's no guarantee the data would be used... thinking...
 */
public class PromotedTeams {

    public static final Map<Integer, List<String>> PROMOTED_TEAMS_BY_YEAR = new HashMap<Integer, List<String>>(){{
        put(2019, Arrays.asList("Norwich", "Sheffield United", "Aston Villa", "Luton", "Barnsley", "Charlton", "Lincoln", "Bury", "Milton Keynes Dons", "Tranmere", "Osasuna", "Granada", "Mallorca", "Brescia", "Lecce", "Verona", "FC Koln", "SC Paderborn", "Union Berlin", "Metz", "Brest"));
        put(2018, Arrays.asList("Wolves", "Fulham", "Cardiff", "Wigan", "Blackburn", "Rotherham", "Accrington", "Luton", "Wycombe", "Coventry", "Vallecano", "Huesca", "Valladolid", "Empoli", "Parma", "Frosinone", "Fortuna Dusseldorf", "Nurnberg", "Reims", "Nimes"));
        put(2017, Arrays.asList("Newcastle", "Brighton", "Huddersfield", "Sheffield United", "Bolton", "Millwall", "Portsmouth", "Plymouth", "Doncaster", "Blackpool", "Levante", "Girona", "Getafe", "Spal", "Verona", "Benevento", "Stuttgart", "Hannover", "Strasbourg", "Amiens", "Troyes"));
        put(2016, Arrays.asList("Burnley", "Middlesbrough", "Hull", "Wigan", "Burton", "Barnsley", "Northampton", "Oxford", "Bristol Rvs", "AFC Wimbledon", "Alaves", "Leganes", "Osasuna", "Cagliari", "Crotone", "Pescara", "Freiburg", "RB Leipzig", "Nancy", "Dijon", "Metz"));
    }};

}
