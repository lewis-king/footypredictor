package com.bestbetking.footypredictor.model.prediction;

public class Match {

    private final String homeTeam;
    private final String awayTeam;
    private final Double homeWinOdds;
    private final Double drawOdds;
    private final Double awayWinOdds;

    private final Double FTHG;
    private final Double FTAG;

    public Match(String homeTeam, String awayTeam, Double homeWinOdds, Double drawOdds, Double awayWinOdds) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeWinOdds = homeWinOdds;
        this.drawOdds = drawOdds;
        this.awayWinOdds = awayWinOdds;
        this.FTHG = 0d;
        this.FTAG = 0d;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public Double getHomeWinOdds() {
        return homeWinOdds;
    }

    public Double getDrawOdds() {
        return drawOdds;
    }

    public Double getAwayWinOdds() {
        return awayWinOdds;
    }

    public Double getFTHG() {
        return FTHG;
    }

    public Double getFTAG() {
        return FTAG;
    }
}
