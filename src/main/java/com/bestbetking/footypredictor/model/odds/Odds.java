package com.bestbetking.footypredictor.model.odds;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Odds {

    @JsonProperty("h2h")
    private final List<Double> matchOdds;


    public Odds(List<Double> matchOdds) {
        this.matchOdds = matchOdds;
    }

    public Odds() {
        matchOdds = null;
    }

    public List<Double> getMatchOdds() {
        return matchOdds;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Odds{");
        sb.append("matchOdds=").append(matchOdds);
        sb.append('}');
        return sb.toString();
    }
}
