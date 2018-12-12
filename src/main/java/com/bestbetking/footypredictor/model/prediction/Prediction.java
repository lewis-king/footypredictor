package com.bestbetking.footypredictor.model.prediction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Prediction {

    @JsonIgnore
    @Id
    private final String id;

    private String league;
    private final String homeTeam;
    private final String awayTeam;
    private final Double homeTeamScore;
    private final Double awayTeamScore;
    private LocalDateTime startTime;


    public Prediction(String league, final String homeTeam, final String awayTeam, final Double homeTeamScore,
                      final Double awayTeamScore, final LocalDateTime startTime) {
        this.id = homeTeam + "Vs" + awayTeam + "-" + startTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
        this.league = league;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        this.startTime = startTime;
    }

    public Prediction() {
        this.id = null;
        this.league = null;
        this.homeTeam = null;
        this.awayTeam = null;
        this.homeTeamScore = null;
        this.awayTeamScore = null;
        this.startTime = null;
    }

    public String getId() {
        return id;
    }

    public String getLeague() {
        return league;
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

    public void setLeague(final String league) {
        this.league = league;
    }
}
