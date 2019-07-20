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
    private Double homeTeamOverallForm;
    // Away Team's Overall Form (both home and away) based on last 3 results
    private Double awayTeamOverallForm;
    // Home Team's Home Form based on last 3 results
    private Double homeTeamHomeForm;
    // Away Team's Away Form based on last 3 results
    private Double awayTeamAwayForm;
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
    private Double homeTeamAverageGoalsScoredOverallForm = 0d;
    // Average goals conceded by Home Team in all games throughout entire season to date
    private Double homeTeamAverageGoalsConcededOverallForm = 0d;
    // Average goals scored by Away Team in all games throughout entire season to date
    private Double awayTeamAverageGoalsScoredOverallForm = 0d;
    // Average goals conceded by Away Team in all games throughout entire season to date
    private Double awayTeamAverageGoalsConcededOverallForm = 0d;
    // Average goals scored by Home Team at Home throughout entire season to date
    private Double homeTeamAverageGoalsScoredHomeForm = 0d;
    // Average goals conceded by Home Team at Home throughout entire season to date
    private Double homeTeamAverageGoalsConcededHomeForm = 0d;
    // Average goals scored by Away Team at Home throughout entire season to date
    private Double awayTeamAverageGoalsScoredAwayForm = 0d;
    // Average goals conceded by Away Team at Home throughout entire season to date
    private Double awayTeamAverageGoalsConcededAwayForm = 0d;


    public EnrichedFootballHistoricRecord(String division, LocalDate date, String homeTeam, String awayTeam, Integer homeTeamGoalsScored, Integer awayTeamGoalsScored, Character matchResult) {
        super(division, date, homeTeam, awayTeam, homeTeamGoalsScored, awayTeamGoalsScored, matchResult);
    }

    public EnrichedFootballHistoricRecord(String division, String homeTeam, String awayTeam) {
        super(division, LocalDate.now(), homeTeam, awayTeam, null, null, null);
    }

    public EnrichedFootballHistoricRecord(FootballHistoricRecord historicRecord) {
        super(historicRecord.getDivision(), historicRecord.getDate(), historicRecord.getHomeTeam(), historicRecord.getAwayTeam(), historicRecord.getHomeTeamGoalsScored(), historicRecord.getAwayTeamGoalsScored(), historicRecord.getMatchResult());
    }

    public EnrichedFootballHistoricRecord(FootballHistoricRecord historicRecord, Double homeTeamOverallForm, Double awayTeamOverallForm, Boolean homeTeamWasPromoted, Boolean awayTeamWasPromoted) {
        super(historicRecord.getDivision(), historicRecord.getDate(), historicRecord.getHomeTeam(), historicRecord.getAwayTeam(), historicRecord.getHomeTeamGoalsScored(), historicRecord.getAwayTeamGoalsScored(), historicRecord.getMatchResult());
        this.homeTeamOverallForm = Double.valueOf(FORM_FORMAT.format(homeTeamOverallForm));
        this.awayTeamOverallForm = Double.valueOf(FORM_FORMAT.format(awayTeamOverallForm));
        this.homeTeamWasPromoted = homeTeamWasPromoted;
        this.awayTeamWasPromoted = awayTeamWasPromoted;
        this.homeTeamAverageGoalsScoredHome = Double.valueOf(FORM_FORMAT.format(homeTeamAverageGoalsScoredHome));
        this.homeTeamAverageGoalsConcededHome = Double.valueOf(FORM_FORMAT.format(homeTeamAverageGoalsConcededHome));
        this.awayTeamAverageGoalsScoredAway = Double.valueOf(FORM_FORMAT.format(awayTeamAverageGoalsScoredAway));
        this.awayTeamAverageGoalsConcededAway = Double.valueOf(FORM_FORMAT.format(awayTeamAverageGoalsConcededAway));
    }

    public EnrichedFootballHistoricRecord(String division, LocalDate date, String homeTeam, String awayTeam, Integer homeTeamGoalsScored, Integer awayTeamGoalsScored, Character matchResult, Double homeTeamOverallForm, Double awayTeamOverallForm, Double homeTeamHomeForm, Double awayTeamAwayForm, Boolean homeTeamWasPromoted, Boolean awayTeamWasPromoted, Double homeTeamAverageGoalsScoredOverall, Double homeTeamAverageGoalsConcededOverall, Double awayTeamAverageGoalsScoredOverall, Double awayTeamAverageGoalsConcededOverall, Double homeTeamAverageGoalsScoredHome, Double homeTeamAverageGoalsConcededHome, Double awayTeamAverageGoalsScoredAway, Double awayTeamAverageGoalsConcededAway,
                                          Double homeTeamAverageGoalsScoredOverallForm, Double homeTeamAverageGoalsConcededOverallForm, Double awayTeamAverageGoalsScoredOverallForm, Double awayTeamAverageGoalsConcededOverallForm, Double homeTeamAverageGoalsScoredHomeForm, Double homeTeamAverageGoalsConcededHomeForm, Double awayTeamAverageGoalsScoredAwayForm, Double awayTeamAverageGoalsConcededAwayForm) {
        super(division, date, homeTeam, awayTeam, homeTeamGoalsScored, awayTeamGoalsScored, matchResult);
        this.homeTeamOverallForm = Double.valueOf(FORM_FORMAT.format(homeTeamOverallForm));
        this.awayTeamOverallForm = Double.valueOf(FORM_FORMAT.format(awayTeamOverallForm));
        this.homeTeamHomeForm = Double.valueOf(FORM_FORMAT.format(homeTeamHomeForm));
        this.awayTeamAwayForm = Double.valueOf(FORM_FORMAT.format(awayTeamAwayForm));
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

        this.homeTeamAverageGoalsScoredOverallForm = Double.valueOf(FORM_FORMAT.format(homeTeamAverageGoalsScoredOverallForm));
        this.homeTeamAverageGoalsConcededOverallForm = Double.valueOf(FORM_FORMAT.format(homeTeamAverageGoalsConcededOverallForm));
        this.awayTeamAverageGoalsScoredOverallForm = Double.valueOf(FORM_FORMAT.format(awayTeamAverageGoalsScoredOverallForm));
        this.awayTeamAverageGoalsConcededOverallForm = Double.valueOf(FORM_FORMAT.format(awayTeamAverageGoalsConcededOverallForm));
        this.homeTeamAverageGoalsScoredHomeForm = Double.valueOf(FORM_FORMAT.format(homeTeamAverageGoalsScoredHomeForm));
        this.homeTeamAverageGoalsConcededHomeForm = Double.valueOf(FORM_FORMAT.format(homeTeamAverageGoalsConcededHomeForm));
        this.awayTeamAverageGoalsScoredAwayForm = Double.valueOf(FORM_FORMAT.format(awayTeamAverageGoalsScoredAwayForm));
        this.awayTeamAverageGoalsConcededAwayForm = Double.valueOf(FORM_FORMAT.format(awayTeamAverageGoalsConcededAwayForm));
    }

    @JsonProperty("HomeTeamOverallFormL3")
    public Double getHomeTeamOverallForm() {
        return homeTeamOverallForm;
    }

    @JsonProperty("AwayTeamOverallFormL3")
    public Double getAwayTeamOverallForm() {
        return awayTeamOverallForm;
    }

    @JsonProperty("HomeTeamHomeFormL3")
    public Double getHomeTeamHomeForm() {
        return homeTeamHomeForm;
    }

    @JsonProperty("AwayTeamAwayFormL3")
    public Double getAwayTeamAwayForm() {
        return awayTeamAwayForm;
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

    @JsonProperty("HomeTeamAvgGoalsScoredOverallForm")
    public Double getHomeTeamAverageGoalsScoredOverallForm() {
        return homeTeamAverageGoalsScoredOverallForm;
    }

    @JsonProperty("HomeTeamAvgGoalsConcededOverallForm")
    public Double getHomeTeamAverageGoalsConcededOverallForm() {
        return homeTeamAverageGoalsConcededOverallForm;
    }

    @JsonProperty("AwayTeamAvgGoalsScoredOverallForm")
    public Double getAwayTeamAverageGoalsScoredOverallForm() {
        return awayTeamAverageGoalsScoredOverallForm;
    }

    @JsonProperty("AwayTeamAvgGoalsConcededOverallForm")
    public Double getAwayTeamAverageGoalsConcededOverallForm() {
        return awayTeamAverageGoalsConcededOverallForm;
    }

    @JsonProperty("HomeTeamAvgGoalsScoredHomeForm")
    public Double getHomeTeamAverageGoalsScoredHomeForm() {
        return homeTeamAverageGoalsScoredHomeForm;
    }

    @JsonProperty("HomeTeamAvgGoalsConcededHomeForm")
    public Double getHomeTeamAverageGoalsConcededHomeForm() {
        return homeTeamAverageGoalsConcededHomeForm;
    }

    @JsonProperty("AwayTeamAvgGoalsScoredAwayForm")
    public Double getAwayTeamAverageGoalsScoredAwayForm() {
        return awayTeamAverageGoalsScoredAwayForm;
    }

    @JsonProperty("AwayTeamAvgGoalsConcededAwayForm")
    public Double getAwayTeamAverageGoalsConcededAwayForm() {
        return awayTeamAverageGoalsConcededAwayForm;
    }

    public EnrichedFootballHistoricRecord setHomeTeamOverallForm(Double homeTeamOverallForm) {
        this.homeTeamOverallForm = homeTeamOverallForm;
        return this;
    }

    public EnrichedFootballHistoricRecord setAwayTeamOverallForm(Double awayTeamOverallForm) {
        this.awayTeamOverallForm = awayTeamOverallForm;
        return this;
    }

    public EnrichedFootballHistoricRecord setHomeTeamHomeForm(Double homeTeamHomeForm) {
        this.homeTeamHomeForm = homeTeamHomeForm;
        return this;
    }

    public EnrichedFootballHistoricRecord setAwayTeamAwayForm(Double awayTeamAwayForm) {
        this.awayTeamAwayForm = awayTeamAwayForm;
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

    public EnrichedFootballHistoricRecord setHomeTeamAverageGoalsScoredOverallForm(Double homeTeamAverageGoalsScoredOverallForm) {
        this.homeTeamAverageGoalsScoredOverallForm = Double.valueOf(FORM_FORMAT.format(homeTeamAverageGoalsScoredOverallForm));
        return this;
    }

    public EnrichedFootballHistoricRecord setHomeTeamAverageGoalsConcededOverallForm(Double homeTeamAverageGoalsConcededOverallForm) {
        this.homeTeamAverageGoalsConcededOverallForm = Double.valueOf(FORM_FORMAT.format(homeTeamAverageGoalsConcededOverallForm));
        return this;
    }

    public EnrichedFootballHistoricRecord setAwayTeamAverageGoalsScoredOverallForm(Double awayTeamAverageGoalsScoredOverallForm) {
        this.awayTeamAverageGoalsScoredOverallForm = Double.valueOf(FORM_FORMAT.format(awayTeamAverageGoalsScoredOverallForm));
        return this;
    }

    public EnrichedFootballHistoricRecord setAwayTeamAverageGoalsConcededOverallForm(Double awayTeamAverageGoalsConcededOverallForm) {
        this.awayTeamAverageGoalsConcededOverallForm = Double.valueOf(FORM_FORMAT.format(awayTeamAverageGoalsConcededOverallForm));
        return this;
    }

    public EnrichedFootballHistoricRecord setHomeTeamAverageGoalsScoredHomeForm(Double homeTeamAverageGoalsScoredHomeForm) {
        this.homeTeamAverageGoalsScoredHomeForm = Double.valueOf(FORM_FORMAT.format(homeTeamAverageGoalsScoredHomeForm));
        return this;
    }

    public EnrichedFootballHistoricRecord setHomeTeamAverageGoalsConcededHomeForm(Double homeTeamAverageGoalsConcededHomeForm) {
        this.homeTeamAverageGoalsConcededHomeForm = Double.valueOf(FORM_FORMAT.format(homeTeamAverageGoalsConcededHomeForm));
        return this;
    }

    public EnrichedFootballHistoricRecord setAwayTeamAverageGoalsScoredAwayForm(Double awayTeamAverageGoalsScoredAwayForm) {
        this.awayTeamAverageGoalsScoredAwayForm = Double.valueOf(FORM_FORMAT.format(awayTeamAverageGoalsScoredAwayForm));
        return this;
    }

    public EnrichedFootballHistoricRecord setAwayTeamAverageGoalsConcededAwayForm(Double awayTeamAverageGoalsConcededAwayForm) {
        this.awayTeamAverageGoalsConcededAwayForm = Double.valueOf(FORM_FORMAT.format(awayTeamAverageGoalsConcededAwayForm));
        return this;
    }

    public EnrichedFootballHistoricRecord build() {
        return new EnrichedFootballHistoricRecord(this.div, this.date, this.homeTeam, this.awayTeam, this.homeTeamGoalsScored, this.awayTeamGoalsScored, this.matchResult, this.homeTeamOverallForm, this.awayTeamOverallForm, this.homeTeamHomeForm, this.awayTeamAwayForm, this.homeTeamWasPromoted, this.awayTeamWasPromoted, this.homeTeamAverageGoalsScoredOverall, this.homeTeamAverageGoalsConcededOverall, this.awayTeamAverageGoalsScoredOverall, this.awayTeamAverageGoalsConcededOverall, this.homeTeamAverageGoalsScoredHome, this.homeTeamAverageGoalsConcededHome, this.awayTeamAverageGoalsScoredAway, this.awayTeamAverageGoalsConcededAway, this.homeTeamAverageGoalsScoredOverallForm, this.homeTeamAverageGoalsConcededOverallForm, this.awayTeamAverageGoalsScoredOverallForm, this.awayTeamAverageGoalsConcededOverallForm, this.homeTeamAverageGoalsScoredHomeForm, this.homeTeamAverageGoalsConcededHomeForm, this.awayTeamAverageGoalsScoredAwayForm, this.awayTeamAverageGoalsConcededAwayForm);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EnrichedFootballHistoricRecord that = (EnrichedFootballHistoricRecord) o;
        return Objects.equals(homeTeamOverallForm, that.homeTeamOverallForm) &&
                Objects.equals(awayTeamOverallForm, that.awayTeamOverallForm) &&
                Objects.equals(homeTeamHomeForm, that.homeTeamHomeForm) &&
                Objects.equals(awayTeamAwayForm, that.awayTeamAwayForm) &&
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
                Objects.equals(homeTeamAverageGoalsScoredOverallForm, that.homeTeamAverageGoalsScoredOverallForm) &&
                Objects.equals(homeTeamAverageGoalsConcededOverallForm, that.homeTeamAverageGoalsConcededOverallForm) &&
                Objects.equals(awayTeamAverageGoalsScoredOverallForm, that.awayTeamAverageGoalsScoredOverallForm) &&
                Objects.equals(awayTeamAverageGoalsConcededOverallForm, that.awayTeamAverageGoalsConcededOverallForm) &&
                Objects.equals(homeTeamAverageGoalsScoredHomeForm, that.homeTeamAverageGoalsScoredHomeForm) &&
                Objects.equals(homeTeamAverageGoalsConcededHomeForm, that.homeTeamAverageGoalsConcededHomeForm) &&
                Objects.equals(awayTeamAverageGoalsScoredAwayForm, that.awayTeamAverageGoalsScoredAwayForm) &&
                Objects.equals(awayTeamAverageGoalsConcededAwayForm, that.awayTeamAverageGoalsConcededAwayForm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), homeTeamOverallForm, awayTeamOverallForm, homeTeamHomeForm, awayTeamAwayForm, homeTeamWasPromoted, awayTeamWasPromoted, homeTeamAverageGoalsScoredOverall, homeTeamAverageGoalsConcededOverall, awayTeamAverageGoalsScoredOverall, awayTeamAverageGoalsConcededOverall, homeTeamAverageGoalsScoredHome, homeTeamAverageGoalsConcededHome, awayTeamAverageGoalsScoredAway, awayTeamAverageGoalsConcededAway, homeTeamAverageGoalsScoredOverallForm, homeTeamAverageGoalsConcededOverallForm, awayTeamAverageGoalsScoredOverallForm, awayTeamAverageGoalsConcededOverallForm, homeTeamAverageGoalsScoredHomeForm, homeTeamAverageGoalsConcededHomeForm, awayTeamAverageGoalsScoredAwayForm, awayTeamAverageGoalsConcededAwayForm);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", EnrichedFootballHistoricRecord.class.getSimpleName() + "[", "]")
                .add("homeTeamOverallForm=" + homeTeamOverallForm)
                .add("awayTeamOverallForm=" + awayTeamOverallForm)
                .add("homeTeamHomeForm=" + homeTeamHomeForm)
                .add("awayTeamAwayForm=" + awayTeamAwayForm)
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
                .add("homeTeamAverageGoalsScoredOverallForm=" + homeTeamAverageGoalsScoredOverallForm)
                .add("homeTeamAverageGoalsConcededOverallForm=" + homeTeamAverageGoalsConcededOverallForm)
                .add("awayTeamAverageGoalsScoredOverallForm=" + awayTeamAverageGoalsScoredOverallForm)
                .add("awayTeamAverageGoalsConcededOverallForm=" + awayTeamAverageGoalsConcededOverallForm)
                .add("homeTeamAverageGoalsScoredHomeForm=" + homeTeamAverageGoalsScoredHomeForm)
                .add("homeTeamAverageGoalsConcededHomeForm=" + homeTeamAverageGoalsConcededHomeForm)
                .add("awayTeamAverageGoalsScoredAwayForm=" + awayTeamAverageGoalsScoredAwayForm)
                .add("awayTeamAverageGoalsConcededAwayForm=" + awayTeamAverageGoalsConcededAwayForm)
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
