package io.footypredictor.services.mapping;

import java.util.Arrays;

public enum League {

    E1("E0", "Premier League", "soccer_epl"),
    E2("E1", "Championship", "soccer_efl_champ"),
    E3("E2", "League One", "soccer_england_league1"),
    E4("E3", "League Two", "soccer_england_league2"),
    SC0("SC0", "SPL", "soccer_spl"),

    S1("SP1", "La Liga", "soccer_spain_la_liga"),

    D1("D1", "Bundesliga", "soccer_germany_bundesliga"),

    I1("I1", "Serie A", "soccer_italy_serie_a"),

    F1("F1", "Ligue 1", "soccer_france_ligue_one"),

    N1("N1", "Eredivisie", "soccer_netherlands_eredivisie")
    ;

    private final String leagueKey;
    private final String leagueDisplayName;
    private final String leagueOddsThirdPartyKey;

    League(String leagueKey, String leagueDisplayName, String leagueOddsThirdPartyKey) {
        this.leagueKey = leagueKey;
        this.leagueDisplayName = leagueDisplayName;
        this.leagueOddsThirdPartyKey = leagueOddsThirdPartyKey;
    }

    public String getLeagueKey() {
        return leagueKey;
    }

    public String getLeagueDisplayName() {
        return leagueDisplayName;
    }

    public String getLeagueOddsThirdPartyKey() {
        return leagueOddsThirdPartyKey;
    }

    public static League getLeagueByThirdPartyKey(final String thirdPartyLeagueKey) {
        return Arrays.stream(League.values()).filter(l -> l.leagueOddsThirdPartyKey.equals(thirdPartyLeagueKey))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Could not lookup League by Third Party Key: " + thirdPartyLeagueKey));
    }

    public static League getLeagueByKey(final String leagueKey) {
        return Arrays.stream(League.values()).filter(l -> l.leagueKey.equals(leagueKey))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Could not lookup League by League Key: " +leagueKey));
    }

}
