package com.bestbetking.footypredictor.services.mapping;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TeamNamesMappingTest {

    @Test
    public void getTeamNamesKeyedBySecondaryName() {
        final TeamNamesMapping expected = TeamNamesMapping.BRIGHTON;
        final TeamNamesMapping result = TeamNamesMapping.getTeamNamesBySecondaryName("Brighton and Hove Albion");
        assertThat(result, is(equalTo(expected)));
        assertThat(result.getPrimaryName(), is(equalTo("Brighton")));
    }

    @Test
    public void getTeamNamesKeyedByPrimaryName() {
        final TeamNamesMapping expected = TeamNamesMapping.BRIGHTON;
        final TeamNamesMapping result = TeamNamesMapping.getTeamNamesByPrimaryName("Brighton");
        assertThat(result, is(equalTo(expected)));
        assertThat(result.getSecondaryName(), is(equalTo("Brighton and Hove Albion")));
    }
}