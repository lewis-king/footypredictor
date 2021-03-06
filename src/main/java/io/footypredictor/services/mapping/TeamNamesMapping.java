package io.footypredictor.services.mapping;

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
    WEST_BROM("West Brom", "West Bromwich Albion"),
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
    HUDDERSFIELD_2("Huddersfield", " Huddersfield Town"),
    CARDIFF("Cardiff", "Cardiff City"),
    WOLVES("Wolves", "Wolverhampton Wanderers"),
    FULHAM("Fulham", "Fulham"),

    BIRMINGHAM("Birmingham", "Birmingham City"),
    BOLTON("Bolton", "Bolton Wanderers"),
    QPR("QPR", "Queens Park Rangers"),
    BRISTOL_CITY("Bristol City", "Bristol City"),
    SHEFFIELD_UNITED("Sheffield United", "Sheffield United"),
    PRESTON("Preston", "Preston"),
    READING("Reading", "Reading"),
    LEEDS("Leeds", "Leeds United"),
    MILLWALL("Millwall", "Millwall"),
    HULL("Hull", "Hull City"),
    IPSWICH("Ipswich", "Ipswich Town"),
    BRENTFORD("Brentford", "Brentford"),
    WIGAN("Wigan", "Wigan Athletic"),
    DERBY("Derby", "Derby County"),
    ROTHEHHAM("Rotherham", "Rotherham United"),
    SHEFFIELD_WEDNESDAY("Sheffield Weds", "Sheffield Wednesday"),
    STOKE("Stoke", "Stoke City"),
    NOTTINGHAM_FOREST("Nott'm Forest", "Nottingham Forest"),
    SWANSEA_CITY("Swansea", "Swansea City"),
    ASTON_VILLA("Aston Villa", "Aston Villa"),
    BLACKBURN_ROVERS("Blackburn", "Blackburn Rovers"),
    NORWICH("Norwich", "Norwich City"),
    MIDDLESBROUGH("Middlesbrough", "Middlesbrough"),
    DONCASTER("Doncaster", "Doncaster Rovers"),

    OXFORD("Oxford", "Oxford United"),
    COVENTRY("Coventry", "Coventry City"),
    GILLINGHAM("Gillingham", "Gillingham"),
    PETERBOROUGH("Peterboro", "Peterborough United"),
    ACCRINGTON("Accrington", "Accrington Stanley"),
    WIMBLEDON("AFC Wimbledon", "AFC Wimbledon"),
    ROCHDALE("Rochdale", "Rochdale"),
    SUNDERLAND("Sunderland", "Sunderland"),
    BARNSLEY("Barnsley", "Barnsley"),
    BURTON("Burton", "Burton Albion"),
    WALSALL("Walsall", "Walsall"),
    SCUNTHORPE("Scunthorpe", "Scunthorpe"),
    SCUNTHORPE_2("Scunthorpe", "Scunthorpe United"),
    SHREWSBURY("Shrewsbury", "Shrewsbury Town"),
    BRISTOL_ROVERS("Bristol Rvs", "Bristol Rovers"),
    WYCOMBE("Wycombe", "Wycombe Wanderers"),
    PORTSMOUTH("Portsmouth", "Portsmouth"),
    CHARLTON("Charlton", "Charlton Athletic"),
    CHARLTON_2("Charlton", " Charlton Athletic"),
    PLYMOUTH("Plymouth", "Plymouth Argyle"),
    BLACKPOOL("Blackpool", "Blackpool FC"),
    LUTON("Luton", "Luton Town"),
    FLEETWOOD("Fleetwood Town", "Fleetwood Town"),
    SOUTHEND("Southend", "Southend United"),
    BRADFORD("Bradford", "Bradford City"),
    COLCHESTER("Colchester", "Colchester United"),

    FOREST_GREEN("Forest Green", "Forest Green Rovers"),
    CRAWLEY("Crawley Town", "Crawley Town"),
    CHELTENHAM("Cheltenham", "Cheltenham Town"),
    EXETER("Exeter", "Exeter City"),
    CREWE("Crewe", "Crewe Alexandra"),
    //Bug with third party API is returning inconsistent team name for Crewe
    CREWE_2("Crewe", "Crewe"),
    PORT_VALE("Port Vale", "Port Vale"),
    MACCLESFIELD("Macclesfield", "Macclesfield Town"),
    MORECAMBE("Morecambe", "Morecambe"),
    NORTHAMPTON("Northampton", "Northampton Town"),
    NOTTS_COUNTY("Notts County", "Notts County"),
    NEWPORT("Newport County", "Newport County"),
    TRANMERE("Tranmere", "Tranmere Rovers"),
    CAMBRIDGE("Cambridge", "Cambridge United"),
    MANSFIELD("Mansfield", "Mansfield Town"),
    MANSFIELD_2("Mansfield", "Mansfield"),
    LEYTON_ORIENT("Leyton Orient", "Leyton Orient"),
    LINCOLN("Lincoln", "Lincoln City"),
    MK_DONS("Milton Keynes Dons", "Milton Keynes Dons"),
    GRIMSBY("Grimsby", "Grimsby Town"),
    SALFORD("Salford", "Salford City"),
    STEVENAGE("Stevenage", "Stevenage FC"),
    STEVENAGE_2("Stevenage", "Stevenage"),
    SWINDON("Swindon", "Swindon Town"),
    YEOVIL("Yeovil", "Yeovil Town"),
    BURY("Bury", "Bury"),
    CARLISLE("Carlisle", "Carlisle United"),
    OLDHAM("Oldham", "Oldham Athletic"),

    CELTIC("Celtic", "Celtic"),
    MOTHERWELL("Motherwell", "Motherwell"),
    ST_MIRREN("St Mirren", "St Mirren"),
    ABERDEEN("Aberdeen", "Aberdeen"),
    HIBERNIAN("Hibernian", "Hibernian"),
    HEARTS("Hearts", "Hearts"),
    KILMARNOCK("Kilmarnock", "Kilmarnock"),
    ROSS_COUNTY("Ross County", "Ross County"),
    ST_JOHNSTONE("St Johnstone", "St Johnstone"),
    LIVINGSTONE("Livingston", "Livingston"),
    HAMILTON("Hamilton", "Hamilton Academical"),
    RANGERS("Rangers", "Rangers"),

    FIORENTINA("Fiorentina", "Fiorentina"),
    NAPOLI("Napoli", "Napoli"),
    ROMA("Roma", "AS Roma"),
    CHIEVO("Chievo", "Chievo"),
    BOLOGNA("Bologna", "Bologna"),
    GENOA("Genoa", "Genoa"),
    JUVENTUS("Juventus", "Juventus"),
    SASSUOLO("Sassuolo", "Sassuolo"),
    TORINO("Torino", "Torino"),
    AC_MILAN("Milan", "AC Milan"),
    CAGLIARI("Cagliari", "Cagliari"),
    ATALANTA("Atalanta", "Atalanta BC"),
    SPAL("Spal", "SPAL"),
    SAMPDORIA("Sampdoria", "Sampdoria"),
    INTER("Inter", "FC Internazionale"),
    LAZIO("Lazio", "Lazio"),
    UDINESE("Udinese", "Udinese"),
    PARMA("Parma", "Parma"),
    LECCE("Lecce", "Lecce"),
    BRESCIA("Brescia", "Brescia"),
    HELLAS_VERONA("Verona", "Hellas Verona FC"),

    ATLETICO_MADRID("Ath Madrid", "Atlético Madrid"),
    EIBAR("Eibar", "Eibar"),
    BARCELONA("Barcelona", "Barcelona"),
    REAL_SOCIEDAD("Sociedad", "Real Sociedad"),
    REAL_BETIS("Betis", "Real Betis"),
    VALENCIA("Valencia", "Valencia"),
    ATHLETIC_BILBAO("Ath Bilbao", "Athletic Bilbao"),
    REAL_MADRID("Real Madrid", "Real Madrid"),
    LEGANES("Leganes", "Leganés"),
    VILLARREAL("Villarreal", "Villarreal"),
    ESPANYOL("Espanol", "Espanyol"),
    LEVANTE("Levante", "Levante"),
    GETAFE("Getafe", "Getafe"),
    SEVILLA("Sevilla", "Sevilla"),
    CELTA_VIGO("Celta", "Celta Vigo"),
    GIRONA("Girona", "Girona"),
    ALAVES("Alaves", "Alavés"),
    RAYO_VALLECANO("Vallecano", "Rayo Vallecano"),
    VALLADOLID("Valladolid", "Valladolid"),
    HUESCA("Huesca", "Huesca"),
    GRANADA("Granada", "Granada"),
    MALLORCA("Mallorca", "Mallorca"),
    OSASUNA("Osasuna", "Osasuna"),

    DORTMUND("Dortmund", "Borussia Dortmund"),
    FRANKFURT("Ein Frankfurt", "Eintracht Frankfurt"),
    LEVERKUSEN("Leverkusen", "Bayer Leverkusen"),
    BAYERN_MUNICH("Bayern Munich", "Bayern Munich"),
    HERTHA_BERLIN("Hertha", "Hertha Berlin"),
    WOLFSBURG("Wolfsburg", "VfL Wolfsburg"),
    AUGSBURG("Augsburg", "Augsburg"),
    MAINZ("Mainz", "FSV Mainz 05"),
    HANNOVER("Hannover", "Hannover 96"),
    RB_LEIPZIG("RB Leipzig", "RB Leipzig"),
    DUSSELDORF("Fortuna Dusseldorf", "Fortuna Dusseldorf"),
    HOFFENHEIM("Hoffenheim", "TSG Hoffenheim"),
    MOCHENGLADBACH("M'gladbach", "Borussia Monchengladbach"),
    SCHALKE("Schalke 04", "Schalke 04"),
    FREIBURG("Freiburg", "SC Freiburg"),
    STUTTGART("Stuttgart", "VfB Stuttgart"),
    WERDER_BREMEN("Werder Bremen", "Werder Bremen"),
    NURNBERG("Nurnberg", "1 FC Nürnberg"),
    PADERBORN("Paderborn", "SC Paderborn"),
    KOLN("FC Koln", "FC Koln"),
    UNION_BERLIN("Union Berlin", "Union Berlin"),

    NICE("Nice", "Nice"),
    BREST("Brest", "Brest"),
    BORDEAUX("Bordeaux", "Bordeaux"),
    RENNES("Rennes", "Rennes"),
    PSG("Paris SG", "Paris Saint Germain"),
    ST_ETIENNE("St Etienne", "Saint Etienne"),
    CAEN("Caen", "Caen"),
    LYON("Lyon", "Lyon"),
    METZ("Metz", "Metz"),
    MONTPELLIER("Montpellier", "Montpellier"),
    STRASBOURG("Strasbourg", "Strasbourg"),
    MONACO("Monaco", "AS Monaco"),
    TOULOUSE("Toulouse", "Toulouse"),
    AMIENS("Amiens", "Amiens"),
    LILLE("Lille", "Lille"),
    ANGERS("Angers", "Angers"),
    DIJON("Dijon", "Dijon"),
    GUINGAMP("Guingamp", "Guingamp"),
    MARSEILLE("Marseille", "Marseille"),
    NANTES("Nantes", "Nantes"),
    NIMES("Nimes", "Nîmes Olympique"),
    REIMS("Reims", "Stade de Reims"),

    PSV("PSV Eindhoven", "PSV Eindhoven"),
    GRONINGEN("Groningen", "Groningen"),
    AJAX("Ajax", "Ajax"),
    FORTUNA_SITTARD("For Sittard", "Fortuna Sittard"),
    AZ_ALKMAAR("AZ Alkmaar", "AZ Alkmaar"),
    FEYENOORD("Feyenoord", "Feyenoord"),
    DEN_HAAG("Den Haag", "ADO Den Haag"),
    EMMEN("FC Emmen", "FC Emmen"),
    HEERENVEEN("Heerenveen", "Heerenveen"),
    VENLO("VVV Venlo", "VVV Venlo"),
    ROTTERDAM("Sparta Rotterdam", "Sparta Rotterdam"),
    WAALWIJK("Waalwijk", "RKC Waalwijk"),
    VITESSE("Vitesse", "Vitesse Arnhem"),
    ZWOLLE("Zwolle", "FC Zwolle"),
    WILLEM("Willem II", "Willem II"),
    UTRECHT("Utrecht", "FC Utrecht"),
    HERACLES("Heracles", "Heracles Almelo"),
    TWENTE("Twente", "FC Twente Enschede"),


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
