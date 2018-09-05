package com.bestbetking.footypredictor.model.prediction;

public class Prediction {

    private final String homeTeam;
    private final String awayTeam;
    private final Double homeTeamScore;
    private final Double awayTeamScore;


    public Prediction(final String homeTeam, String awayTeam, Double homeTeamScore, Double awayTeamScore) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public Double getHomeTeamScore() {
        return homeTeamScore;
    }

    public Double getAwayTeamScore() {
        return awayTeamScore;
    }
}
