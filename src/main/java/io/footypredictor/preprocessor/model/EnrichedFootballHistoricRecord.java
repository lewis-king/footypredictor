package io.footypredictor.preprocessor.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

//TODO: COMPUTED FEATURES SHOULD NOT TAKE INTO THE CURRENT MATCH RESULT, THEY SHOULD BE BASED ON THE PRIOR MATCHES, AS WHEN I FEED IN A PREDICTION THAT DATA WILL BE BASED ON PRIOR MATCHES AS WE DON'T KNOW THE CURRENT GAME RESULT AS OF YET.
//Try to think of it as you are using previous data to help predict the current game result, i.e Previous goals scored before current game, form before current game etc influences the score of the current game to be played, that's what we are tring to build a model around!
public class EnrichedFootballHistoricRecord extends FootballHistoricRecord {

    private static final DecimalFormat FORM_FORMAT = new DecimalFormat("0.00");

    // Home Team's Overall Form (both home and away) based on last 3 results
    private Double homeTeamOverallFormL3;
    // Away Team's Overall Form (both home and away) based on last 3 results
    private Double awayTeamOverallFormL3;
    // Home Team's Home Form based on last 3 results
    private Double homeTeamHomeFormL3;
    // Away Team's Away Form based on last 3 results
    private Double awayTeamAwayFormL3;
    // Was Home Team promoted to this div this season?
    private Boolean homeTeamWasPromoted;
    // Was Away Team promoted to this div this season?
    private Boolean awayTeamWasPromoted;
    // Average goals scored by Home Team in all games throughout entire season to date
    private Double homeTeamAverageGoalsScoredOverall = 0d;
    // Average goals conceded by Home Team in all games throughout entire season to date
    private Double homeTeamAverageGoalsConcededOverall = 0d;
    // Average goals scored by Away Team in all games throughout entire season to date
    private Double awayTeamAverageGoalsScoredOverall = 0d;
    // Average goals conceded by Away Team in all games throughout entire season to date
    private Double awayTeamAverageGoalsConcededOverall = 0d;
    // Average goals scored by Home Team at Home throughout entire season to date
    private Double homeTeamAverageGoalsScoredHome = 0d;
    // Average goals conceded by Home Team at Home throughout entire season to date
    private Double homeTeamAverageGoalsConcededHome = 0d;
    // Average goals scored by Away Team at Home throughout entire season to date
    private Double awayTeamAverageGoalsScoredAway = 0d;
    // Average goals conceded by Away Team at Home throughout entire season to date
    private Double awayTeamAverageGoalsConcededAway = 0d;
    // Average goals scored by Home Team in all games throughout entire season to date
    private Double homeTeamAverageGoalsScoredOverallL3 = 0d;
    // Average goals conceded by Home Team in all games throughout entire season to date
    private Double homeTeamAverageGoalsConcededOverallL3 = 0d;
    // Average goals scored by Away Team in all games throughout entire season to date
    private Double awayTeamAverageGoalsScoredOverallL3 = 0d;
    // Average goals conceded by Away Team in all games throughout entire season to date
    private Double awayTeamAverageGoalsConcededOverallL3 = 0d;
    // Average goals scored by Home Team at Home throughout entire season to date
    private Double homeTeamAverageGoalsScoredHomeL3 = 0d;
    // Average goals conceded by Home Team at Home throughout entire season to date
    private Double homeTeamAverageGoalsConcededHomeL3 = 0d;
    // Average goals scored by Away Team at Home throughout entire season to date
    private Double awayTeamAverageGoalsScoredAwayL3 = 0d;
    // Average goals conceded by Away Team at Home throughout entire season to date
    private Double awayTeamAverageGoalsConcededAwayL3 = 0d;


    public EnrichedFootballHistoricRecord(String division, LocalDate date, String homeTeam, String awayTeam, Integer homeTeamGoalsScored, Integer awayTeamGoalsScored, Character matchResult) {
        super(division, date, homeTeam, awayTeam, homeTeamGoalsScored, awayTeamGoalsScored, matchResult);
    }

    public EnrichedFootballHistoricRecord(String division, String homeTeam, String awayTeam) {
        super(division, LocalDate.now(), homeTeam, awayTeam, null, null, null);
    }

    public EnrichedFootballHistoricRecord(FootballHistoricRecord historicRecord) {
        super(historicRecord.getDivision(), historicRecord.getDate(), historicRecord.getHomeTeam(), historicRecord.getAwayTeam(), historicRecord.getHomeTeamGoalsScored(), historicRecord.getAwayTeamGoalsScored(), historicRecord.getMatchResult());
    }

    public EnrichedFootballHistoricRecord(FootballHistoricRecord historicRecord, Double homeTeamOverallFormL3, Double awayTeamOverallFormL3, Boolean homeTeamWasPromoted, Boolean awayTeamWasPromoted) {
        super(historicRecord.getDivision(), historicRecord.getDate(), historicRecord.getHomeTeam(), historicRecord.getAwayTeam(), historicRecord.getHomeTeamGoalsScored(), historicRecord.getAwayTeamGoalsScored(), historicRecord.getMatchResult());
        this.homeTeamOverallFormL3 = Double.valueOf(FORM_FORMAT.format(homeTeamOverallFormL3));
        this.awayTeamOverallFormL3 = Double.valueOf(FORM_FORMAT.format(awayTeamOverallFormL3));
        this.homeTeamWasPromoted = homeTeamWasPromoted;
        this.awayTeamWasPromoted = awayTeamWasPromoted;
        this.homeTeamAverageGoalsScoredHome = Double.valueOf(FORM_FORMAT.format(homeTeamAverageGoalsScoredHome));
        this.homeTeamAverageGoalsConcededHome = Double.valueOf(FORM_FORMAT.format(homeTeamAverageGoalsConcededHome));
        this.awayTeamAverageGoalsScoredAway = Double.valueOf(FORM_FORMAT.format(awayTeamAverageGoalsScoredAway));
        this.awayTeamAverageGoalsConcededAway = Double.valueOf(FORM_FORMAT.format(awayTeamAverageGoalsConcededAway));
    }

    public EnrichedFootballHistoricRecord(String division, LocalDate date, String homeTeam, String awayTeam, Integer homeTeamGoalsScored, Integer awayTeamGoalsScored, Character matchResult, Double homeTeamOverallFormL3, Double awayTeamOverallFormL3, Double homeTeamHomeFormL3, Double awayTeamAwayFormL3, Boolean homeTeamWasPromoted, Boolean awayTeamWasPromoted, Double homeTeamAverageGoalsScoredOverall, Double homeTeamAverageGoalsConcededOverall, Double awayTeamAverageGoalsScoredOverall, Double awayTeamAverageGoalsConcededOverall, Double homeTeamAverageGoalsScoredHome, Double homeTeamAverageGoalsConcededHome, Double awayTeamAverageGoalsScoredAway, Double awayTeamAverageGoalsConcededAway,
                                          Double homeTeamAverageGoalsScoredOverallL3, Double homeTeamAverageGoalsConcededOverallL3, Double awayTeamAverageGoalsScoredOverallL3, Double awayTeamAverageGoalsConcededOverallL3, Double homeTeamAverageGoalsScoredHomeL3, Double homeTeamAverageGoalsConcededHomeL3, Double awayTeamAverageGoalsScoredAwayL3, Double awayTeamAverageGoalsConcededAwayL3) {
        super(division, date, homeTeam, awayTeam, homeTeamGoalsScored, awayTeamGoalsScored, matchResult);
        this.homeTeamOverallFormL3 = Double.valueOf(FORM_FORMAT.format(homeTeamOverallFormL3));
        this.awayTeamOverallFormL3 = Double.valueOf(FORM_FORMAT.format(awayTeamOverallFormL3));
        this.homeTeamHomeFormL3 = Double.valueOf(FORM_FORMAT.format(homeTeamHomeFormL3));
        this.awayTeamAwayFormL3 = Double.valueOf(FORM_FORMAT.format(awayTeamAwayFormL3));
        this.homeTeamWasPromoted = homeTeamWasPromoted;
        this.awayTeamWasPromoted = awayTeamWasPromoted;
        this.homeTeamAverageGoalsScoredOverall = Double.valueOf(FORM_FORMAT.format(homeTeamAverageGoalsScoredOverall));
        this.homeTeamAverageGoalsConcededOverall = Double.valueOf(FORM_FORMAT.format(homeTeamAverageGoalsConcededOverall));
        this.awayTeamAverageGoalsScoredOverall = Double.valueOf(FORM_FORMAT.format(awayTeamAverageGoalsScoredOverall));
        this.awayTeamAverageGoalsConcededOverall = Double.valueOf(FORM_FORMAT.format(awayTeamAverageGoalsConcededOverall));
        this.homeTeamAverageGoalsScoredHome = Double.valueOf(FORM_FORMAT.format(homeTeamAverageGoalsScoredHome));
        this.homeTeamAverageGoalsConcededHome = Double.valueOf(FORM_FORMAT.format(homeTeamAverageGoalsConcededHome));
        this.awayTeamAverageGoalsScoredAway = Double.valueOf(FORM_FORMAT.format(awayTeamAverageGoalsScoredAway));
        this.awayTeamAverageGoalsConcededAway = Double.valueOf(FORM_FORMAT.format(awayTeamAverageGoalsConcededAway));

        this.homeTeamAverageGoalsScoredOverallL3 = Double.valueOf(FORM_FORMAT.format(homeTeamAverageGoalsScoredOverallL3));
        this.homeTeamAverageGoalsConcededOverallL3 = Double.valueOf(FORM_FORMAT.format(homeTeamAverageGoalsConcededOverallL3));
        this.awayTeamAverageGoalsScoredOverallL3 = Double.valueOf(FORM_FORMAT.format(awayTeamAverageGoalsScoredOverallL3));
        this.awayTeamAverageGoalsConcededOverallL3 = Double.valueOf(FORM_FORMAT.format(awayTeamAverageGoalsConcededOverallL3));
        this.homeTeamAverageGoalsScoredHomeL3 = Double.valueOf(FORM_FORMAT.format(homeTeamAverageGoalsScoredHomeL3));
        this.homeTeamAverageGoalsConcededHomeL3 = Double.valueOf(FORM_FORMAT.format(homeTeamAverageGoalsConcededHomeL3));
        this.awayTeamAverageGoalsScoredAwayL3 = Double.valueOf(FORM_FORMAT.format(awayTeamAverageGoalsScoredAwayL3));
        this.awayTeamAverageGoalsConcededAwayL3 = Double.valueOf(FORM_FORMAT.format(awayTeamAverageGoalsConcededAwayL3));
    }

    @JsonProperty("HomeTeamOverallFormL3")
    public Double getHomeTeamOverallFormL3() {
        return homeTeamOverallFormL3;
    }

    @JsonProperty("AwayTeamOverallFormL3")
    public Double getAwayTeamOverallFormL3() {
        return awayTeamOverallFormL3;
    }

    @JsonProperty("HomeTeamHomeFormL3")
    public Double getHomeTeamHomeFormL3() {
        return homeTeamHomeFormL3;
    }

    @JsonProperty("AwayTeamAwayFormL3")
    public Double getAwayTeamAwayFormL3() {
        return awayTeamAwayFormL3;
    }

    @JsonProperty("HomeTeamPromoted")
    public Boolean getHomeTeamWasPromoted() {
        return homeTeamWasPromoted;
    }

    @JsonProperty("AwayTeamPromoted")
    public Boolean getAwayTeamWasPromoted() {
        return awayTeamWasPromoted;
    }

    @JsonProperty("HomeTeamAvgGoalsScoredOverall")
    public Double getHomeTeamAverageGoalsScoredOverall() {
        return homeTeamAverageGoalsScoredOverall;
    }

    @JsonProperty("HomeTeamAvgGoalsConcededOverall")
    public Double getHomeTeamAverageGoalsConcededOverall() {
        return homeTeamAverageGoalsConcededOverall;
    }

    @JsonProperty("AwayTeamAvgGoalsScoredOverall")
    public Double getAwayTeamAverageGoalsScoredOverall() {
        return awayTeamAverageGoalsScoredOverall;
    }

    @JsonProperty("AwayTeamAvgGoalsConcededOverall")
    public Double getAwayTeamAverageGoalsConcededOverall() {
        return awayTeamAverageGoalsConcededOverall;
    }

    @JsonProperty("HomeTeamAvgGoalsScoredHome")
    public Double getHomeTeamAverageGoalsScoredHome() {
        return homeTeamAverageGoalsScoredHome;
    }

    @JsonProperty("HomeTeamAvgGoalsConcededHome")
    public Double getHomeTeamAverageGoalsConcededHome() {
        return homeTeamAverageGoalsConcededHome;
    }

    @JsonProperty("AwayTeamAvgGoalsScoredAway")
    public Double getAwayTeamAverageGoalsScoredAway() {
        return awayTeamAverageGoalsScoredAway;
    }

    @JsonProperty("AwayTeamAvgGoalsConcededAway")
    public Double getAwayTeamAverageGoalsConcededAway() {
        return awayTeamAverageGoalsConcededAway;
    }

    @JsonProperty("HomeTeamAvgGoalsScoredOverallL3")
    public Double getHomeTeamAverageGoalsScoredOverallL3() {
        return homeTeamAverageGoalsScoredOverallL3;
    }

    @JsonProperty("HomeTeamAvgGoalsConcededOverallL3")
    public Double getHomeTeamAverageGoalsConcededOverallL3() {
        return homeTeamAverageGoalsConcededOverallL3;
    }

    @JsonProperty("AwayTeamAvgGoalsScoredOverallL3")
    public Double getAwayTeamAverageGoalsScoredOverallL3() {
        return awayTeamAverageGoalsScoredOverallL3;
    }

    @JsonProperty("AwayTeamAvgGoalsConcededOverallL3")
    public Double getAwayTeamAverageGoalsConcededOverallL3() {
        return awayTeamAverageGoalsConcededOverallL3;
    }

    @JsonProperty("HomeTeamAvgGoalsScoredHomeL3")
    public Double getHomeTeamAverageGoalsScoredHomeL3() {
        return homeTeamAverageGoalsScoredHomeL3;
    }

    @JsonProperty("HomeTeamAvgGoalsConcededHomeL3")
    public Double getHomeTeamAverageGoalsConcededHomeL3() {
        return homeTeamAverageGoalsConcededHomeL3;
    }

    @JsonProperty("AwayTeamAvgGoalsScoredAwayL3")
    public Double getAwayTeamAverageGoalsScoredAwayL3() {
        return awayTeamAverageGoalsScoredAwayL3;
    }

    @JsonProperty("AwayTeamAvgGoalsConcededAwayL3")
    public Double getAwayTeamAverageGoalsConcededAwayL3() {
        return awayTeamAverageGoalsConcededAwayL3;
    }

    public EnrichedFootballHistoricRecord setHomeTeamOverallFormL3(Double homeTeamOverallFormL3) {
        this.homeTeamOverallFormL3 = homeTeamOverallFormL3;
        return this;
    }

    public EnrichedFootballHistoricRecord setAwayTeamOverallFormL3(Double awayTeamOverallFormL3) {
        this.awayTeamOverallFormL3 = awayTeamOverallFormL3;
        return this;
    }

    public EnrichedFootballHistoricRecord setHomeTeamHomeFormL3(Double homeTeamHomeFormL3) {
        this.homeTeamHomeFormL3 = homeTeamHomeFormL3;
        return this;
    }

    public EnrichedFootballHistoricRecord setAwayTeamAwayFormL3(Double awayTeamAwayFormL3) {
        this.awayTeamAwayFormL3 = awayTeamAwayFormL3;
        return this;
    }

    public EnrichedFootballHistoricRecord setHomeTeamWasPromoted(Boolean homeTeamWasPromoted) {
        this.homeTeamWasPromoted = homeTeamWasPromoted;
        return this;
    }

    public EnrichedFootballHistoricRecord setAwayTeamWasPromoted(Boolean awayTeamWasPromoted) {
        this.awayTeamWasPromoted = awayTeamWasPromoted;
        return this;
    }

    public EnrichedFootballHistoricRecord setHomeTeamAverageGoalsScoredOverall(Double homeTeamAverageGoalsScoredOverall) {
        this.homeTeamAverageGoalsScoredOverall = Double.valueOf(FORM_FORMAT.format(homeTeamAverageGoalsScoredOverall));
        return this;
    }

    public EnrichedFootballHistoricRecord setHomeTeamAverageGoalsConcededOverall(Double homeTeamAverageGoalsConcededOverall) {
        this.homeTeamAverageGoalsConcededOverall = Double.valueOf(FORM_FORMAT.format(homeTeamAverageGoalsConcededOverall));
        return this;
    }

    public EnrichedFootballHistoricRecord setAwayTeamAverageGoalsScoredOverall(Double awayTeamAverageGoalsScoredOverall) {
        this.awayTeamAverageGoalsScoredOverall = Double.valueOf(FORM_FORMAT.format(awayTeamAverageGoalsScoredOverall));
        return this;
    }

    public EnrichedFootballHistoricRecord setAwayTeamAverageGoalsConcededOverall(Double awayTeamAverageGoalsConcededOverall) {
        this.awayTeamAverageGoalsConcededOverall = Double.valueOf(FORM_FORMAT.format(awayTeamAverageGoalsConcededOverall));
        return this;
    }

    public EnrichedFootballHistoricRecord setHomeTeamAverageGoalsScoredHome(Double homeTeamAverageGoalsScoredHome) {
        this.homeTeamAverageGoalsScoredHome = Double.valueOf(FORM_FORMAT.format(homeTeamAverageGoalsScoredHome));
        return this;
    }

    public EnrichedFootballHistoricRecord setHomeTeamAverageGoalsConcededHome(Double homeTeamAverageGoalsConcededHome) {
        this.homeTeamAverageGoalsConcededHome = Double.valueOf(FORM_FORMAT.format(homeTeamAverageGoalsConcededHome));
        return this;
    }

    public EnrichedFootballHistoricRecord setAwayTeamAverageGoalsScoredAway(Double awayTeamAverageGoalsScoredAway) {
        this.awayTeamAverageGoalsScoredAway = Double.valueOf(FORM_FORMAT.format(awayTeamAverageGoalsScoredAway));
        return this;
    }

    public EnrichedFootballHistoricRecord setAwayTeamAverageGoalsConcededAway(Double awayTeamAverageGoalsConcededAway) {
        this.awayTeamAverageGoalsConcededAway = Double.valueOf(FORM_FORMAT.format(awayTeamAverageGoalsConcededAway));
        return this;
    }

    public EnrichedFootballHistoricRecord setHomeTeamAverageGoalsScoredOverallL3(Double homeTeamAverageGoalsScoredOverallL3) {
        this.homeTeamAverageGoalsScoredOverallL3 = Double.valueOf(FORM_FORMAT.format(homeTeamAverageGoalsScoredOverallL3));
        return this;
    }

    public EnrichedFootballHistoricRecord setHomeTeamAverageGoalsConcededOverallL3(Double homeTeamAverageGoalsConcededOverallL3) {
        this.homeTeamAverageGoalsConcededOverallL3 = Double.valueOf(FORM_FORMAT.format(homeTeamAverageGoalsConcededOverallL3));
        return this;
    }

    public EnrichedFootballHistoricRecord setAwayTeamAverageGoalsScoredOverallL3(Double awayTeamAverageGoalsScoredOverallL3) {
        this.awayTeamAverageGoalsScoredOverallL3 = Double.valueOf(FORM_FORMAT.format(awayTeamAverageGoalsScoredOverallL3));
        return this;
    }

    public EnrichedFootballHistoricRecord setAwayTeamAverageGoalsConcededOverallL3(Double awayTeamAverageGoalsConcededOverallL3) {
        this.awayTeamAverageGoalsConcededOverallL3 = Double.valueOf(FORM_FORMAT.format(awayTeamAverageGoalsConcededOverallL3));
        return this;
    }

    public EnrichedFootballHistoricRecord setHomeTeamAverageGoalsScoredHomeL3(Double homeTeamAverageGoalsScoredHomeL3) {
        this.homeTeamAverageGoalsScoredHomeL3 = Double.valueOf(FORM_FORMAT.format(homeTeamAverageGoalsScoredHomeL3));
        return this;
    }

    public EnrichedFootballHistoricRecord setHomeTeamAverageGoalsConcededHomeL3(Double homeTeamAverageGoalsConcededHomeL3) {
        this.homeTeamAverageGoalsConcededHomeL3 = Double.valueOf(FORM_FORMAT.format(homeTeamAverageGoalsConcededHomeL3));
        return this;
    }

    public EnrichedFootballHistoricRecord setAwayTeamAverageGoalsScoredAwayL3(Double awayTeamAverageGoalsScoredAwayL3) {
        this.awayTeamAverageGoalsScoredAwayL3 = Double.valueOf(FORM_FORMAT.format(awayTeamAverageGoalsScoredAwayL3));
        return this;
    }

    public EnrichedFootballHistoricRecord setAwayTeamAverageGoalsConcededAwayL3(Double awayTeamAverageGoalsConcededAwayL3) {
        this.awayTeamAverageGoalsConcededAwayL3 = Double.valueOf(FORM_FORMAT.format(awayTeamAverageGoalsConcededAwayL3));
        return this;
    }

    public EnrichedFootballHistoricRecord build() {
        return new EnrichedFootballHistoricRecord(this.div, this.date, this.homeTeam, this.awayTeam, this.homeTeamGoalsScored, this.awayTeamGoalsScored, this.matchResult, this.homeTeamOverallFormL3, this.awayTeamOverallFormL3, this.homeTeamHomeFormL3, this.awayTeamAwayFormL3, this.homeTeamWasPromoted, this.awayTeamWasPromoted, this.homeTeamAverageGoalsScoredOverall, this.homeTeamAverageGoalsConcededOverall, this.awayTeamAverageGoalsScoredOverall, this.awayTeamAverageGoalsConcededOverall, this.homeTeamAverageGoalsScoredHome, this.homeTeamAverageGoalsConcededHome, this.awayTeamAverageGoalsScoredAway, this.awayTeamAverageGoalsConcededAway, this.homeTeamAverageGoalsScoredOverallL3, this.homeTeamAverageGoalsConcededOverallL3, this.awayTeamAverageGoalsScoredOverallL3, this.awayTeamAverageGoalsConcededOverallL3, this.homeTeamAverageGoalsScoredHomeL3, this.homeTeamAverageGoalsConcededHomeL3, this.awayTeamAverageGoalsScoredAwayL3, this.awayTeamAverageGoalsConcededAwayL3);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EnrichedFootballHistoricRecord that = (EnrichedFootballHistoricRecord) o;
        return Objects.equals(homeTeamOverallFormL3, that.homeTeamOverallFormL3) &&
                Objects.equals(awayTeamOverallFormL3, that.awayTeamOverallFormL3) &&
                Objects.equals(homeTeamHomeFormL3, that.homeTeamHomeFormL3) &&
                Objects.equals(awayTeamAwayFormL3, that.awayTeamAwayFormL3) &&
                Objects.equals(homeTeamWasPromoted, that.homeTeamWasPromoted) &&
                Objects.equals(awayTeamWasPromoted, that.awayTeamWasPromoted) &&
                Objects.equals(homeTeamAverageGoalsScoredOverall, that.homeTeamAverageGoalsScoredOverall) &&
                Objects.equals(homeTeamAverageGoalsConcededOverall, that.homeTeamAverageGoalsConcededOverall) &&
                Objects.equals(awayTeamAverageGoalsScoredOverall, that.awayTeamAverageGoalsScoredOverall) &&
                Objects.equals(awayTeamAverageGoalsConcededOverall, that.awayTeamAverageGoalsConcededOverall) &&
                Objects.equals(homeTeamAverageGoalsScoredHome, that.homeTeamAverageGoalsScoredHome) &&
                Objects.equals(homeTeamAverageGoalsConcededHome, that.homeTeamAverageGoalsConcededHome) &&
                Objects.equals(awayTeamAverageGoalsScoredAway, that.awayTeamAverageGoalsScoredAway) &&
                Objects.equals(awayTeamAverageGoalsConcededAway, that.awayTeamAverageGoalsConcededAway) &&
                Objects.equals(homeTeamAverageGoalsScoredOverallL3, that.homeTeamAverageGoalsScoredOverallL3) &&
                Objects.equals(homeTeamAverageGoalsConcededOverallL3, that.homeTeamAverageGoalsConcededOverallL3) &&
                Objects.equals(awayTeamAverageGoalsScoredOverallL3, that.awayTeamAverageGoalsScoredOverallL3) &&
                Objects.equals(awayTeamAverageGoalsConcededOverallL3, that.awayTeamAverageGoalsConcededOverallL3) &&
                Objects.equals(homeTeamAverageGoalsScoredHomeL3, that.homeTeamAverageGoalsScoredHomeL3) &&
                Objects.equals(homeTeamAverageGoalsConcededHomeL3, that.homeTeamAverageGoalsConcededHomeL3) &&
                Objects.equals(awayTeamAverageGoalsScoredAwayL3, that.awayTeamAverageGoalsScoredAwayL3) &&
                Objects.equals(awayTeamAverageGoalsConcededAwayL3, that.awayTeamAverageGoalsConcededAwayL3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), homeTeamOverallFormL3, awayTeamOverallFormL3, homeTeamHomeFormL3, awayTeamAwayFormL3, homeTeamWasPromoted, awayTeamWasPromoted, homeTeamAverageGoalsScoredOverall, homeTeamAverageGoalsConcededOverall, awayTeamAverageGoalsScoredOverall, awayTeamAverageGoalsConcededOverall, homeTeamAverageGoalsScoredHome, homeTeamAverageGoalsConcededHome, awayTeamAverageGoalsScoredAway, awayTeamAverageGoalsConcededAway, homeTeamAverageGoalsScoredOverallL3, homeTeamAverageGoalsConcededOverallL3, awayTeamAverageGoalsScoredOverallL3, awayTeamAverageGoalsConcededOverallL3, homeTeamAverageGoalsScoredHomeL3, homeTeamAverageGoalsConcededHomeL3, awayTeamAverageGoalsScoredAwayL3, awayTeamAverageGoalsConcededAwayL3);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", EnrichedFootballHistoricRecord.class.getSimpleName() + "[", "]")
                .add("homeTeamOverallFormL3=" + homeTeamOverallFormL3)
                .add("awayTeamOverallFormL3=" + awayTeamOverallFormL3)
                .add("homeTeamHomeFormL3=" + homeTeamHomeFormL3)
                .add("awayTeamAwayFormL3=" + awayTeamAwayFormL3)
                .add("homeTeamWasPromoted=" + homeTeamWasPromoted)
                .add("awayTeamWasPromoted=" + awayTeamWasPromoted)
                .add("homeTeamAverageGoalsScoredOverall=" + homeTeamAverageGoalsScoredOverall)
                .add("homeTeamAverageGoalsConcededOverall=" + homeTeamAverageGoalsConcededOverall)
                .add("awayTeamAverageGoalsScoredOverall=" + awayTeamAverageGoalsScoredOverall)
                .add("awayTeamAverageGoalsConcededOverall=" + awayTeamAverageGoalsConcededOverall)
                .add("homeTeamAverageGoalsScoredHome=" + homeTeamAverageGoalsScoredHome)
                .add("homeTeamAverageGoalsConcededHome=" + homeTeamAverageGoalsConcededHome)
                .add("awayTeamAverageGoalsScoredAway=" + awayTeamAverageGoalsScoredAway)
                .add("awayTeamAverageGoalsConcededAway=" + awayTeamAverageGoalsConcededAway)
                .add("homeTeamAverageGoalsScoredOverallL3=" + homeTeamAverageGoalsScoredOverallL3)
                .add("homeTeamAverageGoalsConcededOverallL3=" + homeTeamAverageGoalsConcededOverallL3)
                .add("awayTeamAverageGoalsScoredOverallL3=" + awayTeamAverageGoalsScoredOverallL3)
                .add("awayTeamAverageGoalsConcededOverallL3=" + awayTeamAverageGoalsConcededOverallL3)
                .add("homeTeamAverageGoalsScoredHomeL3=" + homeTeamAverageGoalsScoredHomeL3)
                .add("homeTeamAverageGoalsConcededHomeL3=" + homeTeamAverageGoalsConcededHomeL3)
                .add("awayTeamAverageGoalsScoredAwayL3=" + awayTeamAverageGoalsScoredAwayL3)
                .add("awayTeamAverageGoalsConcededAwayL3=" + awayTeamAverageGoalsConcededAwayL3)
                .add("div='" + div + "'")
                .add("date=" + date)
                .add("homeTeam='" + homeTeam + "'")
                .add("awayTeam='" + awayTeam + "'")
                .add("homeTeamGoalsScored=" + homeTeamGoalsScored)
                .add("awayTeamGoalsScored=" + awayTeamGoalsScored)
                .add("matchResult=" + matchResult)
                .toString();
    }
}
