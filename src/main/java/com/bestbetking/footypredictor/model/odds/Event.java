package com.bestbetking.footypredictor.model.odds;

import com.bestbetking.footypredictor.services.serialization.deserializer.UnixTimestampDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Event {

    private final List<String> teams;
    @JsonProperty("home_team")
    private final String homeTeam;
    @JsonProperty("sites")
    private final List<Source> sources;
    @JsonProperty("commence_time")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private final LocalDateTime startTime;


    public Event(List<String> teams, String homeTeam, List<Source> sources, LocalDateTime startTime) {
        this.teams = teams;
        this.homeTeam = homeTeam;
        this.sources = sources;
        this.startTime = startTime;
    }

    public Event() {
        this.startTime = null;
        teams = null;
        homeTeam = null;
        sources = null;
    }

    public List<String> getTeams() {
        return teams;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return teams.stream().filter(team -> !team.equals(homeTeam)).collect(Collectors.joining());
    }

    public List<Source> getSources() {
        return sources;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Event{");
        sb.append("teams=").append(teams);
        sb.append(", homeTeam='").append(homeTeam).append('\'');
        sb.append(", sources=").append(sources);
        sb.append(", startTime=").append(startTime);
        sb.append('}');
        return sb.toString();
    }
}
