package io.footypredictor.preprocessor.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Objects;

public class FootballHistoricRecord {

    protected final String div;
    @JsonIgnore
    protected final LocalDate date;
    protected final String homeTeam;
    protected final String awayTeam;
    @JsonIgnore
    protected final Integer homeTeamGoalsScored;
    @JsonIgnore
    protected final Integer awayTeamGoalsScored;
    @JsonIgnore
    protected final Character matchResult;

    public FootballHistoricRecord(String div, LocalDate date, String homeTeam, String awayTeam, Integer homeTeamGoalsScored, Integer awayTeamGoalsScored, Character matchResult) {
        this.div = div;
        this.date = date;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamGoalsScored = homeTeamGoalsScored;
        this.awayTeamGoalsScored = awayTeamGoalsScored;
        this.matchResult = matchResult;
    }

    @JsonProperty("div")
    public String getDivision() {
        return div;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public Integer getHomeTeamGoalsScored() {
        return homeTeamGoalsScored;
    }

    public Integer getAwayTeamGoalsScored() {
        return awayTeamGoalsScored;
    }

    public Character getMatchResult() {
        return matchResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballHistoricRecord that = (FootballHistoricRecord) o;
        return Objects.equals(div, that.div) &&
                Objects.equals(date, that.date) &&
                Objects.equals(homeTeam, that.homeTeam) &&
                Objects.equals(awayTeam, that.awayTeam) &&
                Objects.equals(homeTeamGoalsScored, that.homeTeamGoalsScored) &&
                Objects.equals(awayTeamGoalsScored, that.awayTeamGoalsScored) &&
                Objects.equals(matchResult, that.matchResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(div, date, homeTeam, awayTeam, homeTeamGoalsScored, awayTeamGoalsScored, matchResult);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FootballHistoricRecord{");
        sb.append("div='").append(div).append('\'');
        sb.append(", date=").append(date);
        sb.append(", homeTeam='").append(homeTeam).append('\'');
        sb.append(", awayTeam='").append(awayTeam).append('\'');
        sb.append(", homeTeamGoalsScored=").append(homeTeamGoalsScored);
        sb.append(", awayTeamGoalsScored=").append(awayTeamGoalsScored);
        sb.append(", matchResult=").append(matchResult);
        sb.append('}');
        return sb.toString();
    }
}
