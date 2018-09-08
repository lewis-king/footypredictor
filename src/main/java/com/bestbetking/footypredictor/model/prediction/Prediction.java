package com.bestbetking.footypredictor.model.prediction;

import java.time.LocalDateTime;

public class Prediction {

    private final String homeTeam;
    private final String awayTeam;
    private final Double homeTeamScore;
    private final Double awayTeamScore;
    private LocalDateTime startTime;


    public Prediction(final String homeTeam, final String awayTeam, final Double homeTeamScore, final Double awayTeamScore, final LocalDateTime startTime) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        this.startTime = startTime;
    }

    public Prediction() {
        this.homeTeam = null;
        this.awayTeam = null;
        this.homeTeamScore = null;
        this.awayTeamScore = null;
        this.startTime = null;
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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(final LocalDateTime startTime) {
        this.startTime = startTime;
    }
}
