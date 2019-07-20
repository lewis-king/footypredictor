package io.footypredictor.model.prediction;

public class Match {

    private final String league;
    private final String homeTeam;
    private final String awayTeam;
    private final Double homeWinOdds;
    private final Double drawOdds;
    private final Double awayWinOdds;




    public Match(String league, String homeTeam, String awayTeam, Double homeWinOdds, Double drawOdds, Double awayWinOdds) {
        this.league = league;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeWinOdds = homeWinOdds;
        this.drawOdds = drawOdds;
        this.awayWinOdds = awayWinOdds;
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

    public Double getHomeWinOdds() {
        return homeWinOdds;
    }

    public Double getDrawOdds() {
        return drawOdds;
    }

    public Double getAwayWinOdds() {
        return awayWinOdds;
    }

}
