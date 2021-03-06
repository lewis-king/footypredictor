package io.footypredictor.services.mapping;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeagueTest {

    @Test
    public void getLeagueByThirdPartyKey_e0() {
        League actual = League.getLeagueByThirdPartyKey("soccer_epl");
        assertEquals(League.E0, actual);
    }

    @Test
    public void getLeagueByThirdPartyKey_e1() {
        League actual = League.getLeagueByThirdPartyKey("soccer_efl_champ");
        assertEquals(League.E1, actual);
    }

    @Test
    public void getLeagueByThirdPartyKey_e2() {
        League actual = League.getLeagueByThirdPartyKey("soccer_england_league1");
        assertEquals(League.E2, actual);
    }

    @Test
    public void getLeagueByThirdPartyKey_e3() {
        League actual = League.getLeagueByThirdPartyKey("soccer_england_league2");
        assertEquals(League.E3, actual);
    }

    @Test
    public void getLeagueByThirdPartyKey_sp1() {
        League actual = League.getLeagueByThirdPartyKey("soccer_spain_la_liga");
        assertEquals(League.SP1, actual);
    }

    @Test
    public void getLeagueByThirdPartyKey_d1() {
        League actual = League.getLeagueByThirdPartyKey("soccer_germany_bundesliga");
        assertEquals(League.D1, actual);
    }

    @Test
    public void getLeagueByThirdPartyKey_i1() {
        League actual = League.getLeagueByThirdPartyKey("soccer_italy_serie_a");
        assertEquals(League.I1, actual);
    }

    @Test
    public void getLeagueByThirdPartyKey_f1() {
        League actual = League.getLeagueByThirdPartyKey("soccer_france_ligue_one");
        assertEquals(League.F1, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLeagueByThirdPartyKey_notFound() {
        League.getLeagueByThirdPartyKey("someLeagueKey");
    }

    @Test
    public void getLeagueByKey_e1() {
        League actual = League.getLeagueByKey("E1");
        assertEquals(League.E1, actual);
    }
}