package com.bestbetking.footypredictor.model.prediction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

import static com.bestbetking.footypredictor.services.recommendation.BetRecommendationDecorator.buildRecommendedBetTypes;

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
    @Transient
    private List<BetType> recommendedBets;


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
        this.recommendedBets = null;
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

    public List<BetType> getRecommendedBets() {
        return recommendedBets;
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

    public void setRecommendedBets(List<BetType> recommendedBets) {
        this.recommendedBets = recommendedBets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prediction that = (Prediction) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(league, that.league) &&
                Objects.equals(homeTeam, that.homeTeam) &&
                Objects.equals(awayTeam, that.awayTeam) &&
                Objects.equals(homeTeamScore, that.homeTeamScore) &&
                Objects.equals(awayTeamScore, that.awayTeamScore) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(recommendedBets, that.recommendedBets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, league, homeTeam, awayTeam, homeTeamScore, awayTeamScore, startTime, recommendedBets);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Prediction{");
        sb.append("id='").append(id).append('\'');
        sb.append(", league='").append(league).append('\'');
        sb.append(", homeTeam='").append(homeTeam).append('\'');
        sb.append(", awayTeam='").append(awayTeam).append('\'');
        sb.append(", homeTeamScore=").append(homeTeamScore);
        sb.append(", awayTeamScore=").append(awayTeamScore);
        sb.append(", startTime=").append(startTime);
        sb.append(", recommendedBets=").append(recommendedBets);
        sb.append('}');
        return sb.toString();
    }
}
