package com.bestbetking.footypredictor.services.mapping;

import java.util.Arrays;

public enum League {

    E1("E1", "Premier League", "soccer_epl"),
    E2("E2", "Championship", "soccer_efl_champ"),
    E3("E3", "League One", "soccer_england_league1"),
    E4("E4", "League Two", "soccer_england_league2"),

    S1("S1", "La Liga", "soccer_spain_la_liga"),

    G1("G1", "Bundesliga", "soccer_germany_bundesliga"),

    I1("I1", "Serie A", "soccer_italy_serie_a"),

    F1("F1", "Ligue 1", "soccer_france_ligue_one")
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
