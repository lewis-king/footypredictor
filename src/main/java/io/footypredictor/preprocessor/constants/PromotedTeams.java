package io.footypredictor.preprocessor.constants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PromotedTeams depict whether the club was a newly promoted team for that season.
 * We believe newly promoted teams tend to not fair too well as usually their primary goal is to survive relegation
 */
public class PromotedTeams {

    public static final Map<Integer, List<String>> PROMOTED_TEAMS_BY_YEAR = new HashMap<Integer, List<String>>(){{
        put(2019, Arrays.asList("Norwich", "Sheffield United", "Aston Villa", "Luton", "Barnsley", "Charlton", "Lincoln", "Bury", "Milton Keynes Dons", "Tranmere", "Leyton Orient", "Salford", "Osasuna", "Granada", "Mallorca", "Brescia", "Lecce", "Verona", "FC Koln", "SC Paderborn", "Union Berlin", "Metz", "Brest", "Ross County", "Twente", "Waalwijk", "Rotterdam"));
        put(2018, Arrays.asList("Wolves", "Fulham", "Cardiff", "Wigan", "Blackburn", "Rotherham", "Accrington", "Luton", "Wycombe", "Coventry", "Macclesfield", "Tranmere", "Vallecano", "Huesca", "Valladolid", "Empoli", "Parma", "Frosinone", "Fortuna Dusseldorf", "Nurnberg", "Reims", "Nimes", "St Mirren", "Livingston", "For Sittard", "Graafschap", "FC Emmen"));
        put(2017, Arrays.asList("Newcastle", "Brighton", "Huddersfield", "Sheffield United", "Bolton", "Millwall", "Portsmouth", "Plymouth", "Doncaster", "Blackpool", "Lincoln", "Forest Green", "Levante", "Girona", "Getafe", "Spal", "Verona", "Benevento", "Stuttgart", "Hannover", "Strasbourg", "Amiens", "Troyes", "Hibernian", "VVV Venlo", "NAC Breda"));
        put(2016, Arrays.asList("Burnley", "Middlesbrough", "Hull", "Wigan", "Burton", "Barnsley", "Northampton", "Oxford", "Bristol Rvs", "AFC Wimbledon", "Cheltenham", "Grimsby", "Alaves", "Leganes", "Osasuna", "Cagliari", "Crotone", "Pescara", "Freiburg", "RB Leipzig", "Nancy", "Dijon", "Metz", "Rangers", "Sparta Rotterdam", "Go Ahead Eagles"));
    }};

}
