package com.bestbetking.footypredictor.model.odds;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OddsPayload {

    private final boolean success;
    @JsonProperty("data")
    private final List<Event> events;

    public OddsPayload(boolean success, List<Event> events) {
        this.success = success;
        this.events = events;
    }

    public OddsPayload() {
        success = false;
        events = null;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<Event> getEvents() {
        return events;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OddsPayload{");
        sb.append("success='").append(success).append('\'');
        sb.append(", events=").append(events);
        sb.append('}');
        return sb.toString();
    }
}
