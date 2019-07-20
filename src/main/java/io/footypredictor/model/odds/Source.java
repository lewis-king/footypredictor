package io.footypredictor.model.odds;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Source {

    @JsonProperty("site_key")
    private final String sourceId;
    private final Odds odds;

    public Source(String sourceId, Odds odds) {
        this.sourceId = sourceId;
        this.odds = odds;
    }

    public Source() {
        sourceId = null;
        odds = null;
    }

    public String getSourceId() {
        return sourceId;
    }

    public Odds getOdds() {
        return odds;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Source{");
        sb.append("sourceId='").append(sourceId).append('\'');
        sb.append(", odds=").append(odds);
        sb.append('}');
        return sb.toString();
    }
}
