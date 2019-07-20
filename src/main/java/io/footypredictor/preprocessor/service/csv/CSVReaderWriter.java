package io.footypredictor.preprocessor.service.csv;

import io.footypredictor.preprocessor.model.EnrichedFootballHistoricRecord;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

@Service
public class CSVReaderWriter {

    private static String[] HEADERS = { "Div", "Date", "HomeTeam", "AwayTeam", "FTHG", "FTAG", "FTR"};
    private static String[] ENRICHED_HEADERS = { "Div", "Date", "HomeTeam", "AwayTeam", "FTHG", "FTAG", "FTR", "HomeTeamOverallFormL3", "AwayTeamOverallFormL3", "HomeTeamHomeFormL3", "AwayTeamAwayFormL3", "HomeTeamPromoted", "AwayTeamPromoted", "HomeTeamAvgGoalsScoredOverall", "HomeTeamAvgGoalsConcededOverall", "AwayTeamAvgGoalsScoredOverall", "AwayTeamAvgGoalsConcededOverall", "HomeTeamAvgGoalsScoredHome", "HomeTeamAvgGoalsConcededHome", "AwayTeamAvgGoalsScoredAway", "AwayTeamAvgGoalsConcededAway", "HomeTeamAvgGoalsScoredOverallForm", "HomeTeamAvgGoalsConcededOverallForm", "AwayTeamAvgGoalsScoredOverallForm", "AwayTeamAvgGoalsConcededOverallForm", "HomeTeamAvgGoalsScoredHomeForm", "HomeTeamAvgGoalsConcededHomeForm", "AwayTeamAvgGoalsScoredAwayForm", "AwayTeamAvgGoalsConcededAwayForm"};

    public List<EnrichedFootballHistoricRecord> read(InputStream input) throws IOException {

        List<EnrichedFootballHistoricRecord> footballHistoricRecords = new LinkedList<>();
        Reader in = new InputStreamReader(input, "UTF-8");
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withHeader(HEADERS)
                .withFirstRecordAsHeader()
                .parse(in);

        records.forEach(record -> {
            String division = record.get("Div");
            LocalDate date;
            try {
                date = LocalDate.parse(record.get("Date"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (DateTimeParseException dtpe) {
                date = LocalDate.parse(record.get("Date"), DateTimeFormatter.ofPattern("dd/MM/yy"));
            }
            String homeTeam = record.get("HomeTeam");
            String awayTeam = record.get("AwayTeam");
            Integer homeTeamGoalsScored = Integer.parseInt(record.get("FTHG"));
            Integer awayTeamGoalsScored = Integer.parseInt(record.get("FTAG"));
            Character matchResult = record.get("FTR").charAt(0);

            EnrichedFootballHistoricRecord footballHistoricRecord = new EnrichedFootballHistoricRecord(division, date, homeTeam, awayTeam, homeTeamGoalsScored, awayTeamGoalsScored, matchResult);
            footballHistoricRecords.add(footballHistoricRecord);
        });
        return footballHistoricRecords;
    }

    public void write(List<EnrichedFootballHistoricRecord> footballRecords, String directoryName, String filename) throws IOException {
        File directory = new File("target" + File.separator + directoryName);
        if (!directory.exists()) {
            directory.mkdir();
        }
        FileWriter out = new FileWriter("target" + File.separator + directoryName + File.separator + filename + ".csv");
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
                .withHeader(ENRICHED_HEADERS))) {
            footballRecords.forEach((record) -> {
                try {
                    printer.printRecord(record.getDivision(), record.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), record.getHomeTeam(), record.getAwayTeam(),
                            record.getHomeTeamGoalsScored(), record.getAwayTeamGoalsScored(), record.getMatchResult(), record.getHomeTeamOverallForm(), record.getAwayTeamOverallForm(), record.getHomeTeamHomeForm(), record.getAwayTeamAwayForm(),
                            record.getHomeTeamWasPromoted() ? 1 : 0, record.getAwayTeamWasPromoted() ? 1 : 0,
                            record.getHomeTeamAverageGoalsScoredOverall(), record.getHomeTeamAverageGoalsConcededOverall(), record.getAwayTeamAverageGoalsScoredOverall(), record.getAwayTeamAverageGoalsConcededOverall(),
                            record.getHomeTeamAverageGoalsScoredHome(), record.getHomeTeamAverageGoalsConcededHome(), record.getAwayTeamAverageGoalsScoredAway(), record.getAwayTeamAverageGoalsConcededAway(),
                            record.getHomeTeamAverageGoalsScoredOverallForm(), record.getHomeTeamAverageGoalsConcededOverallForm(), record.getAwayTeamAverageGoalsScoredOverallForm(), record.getAwayTeamAverageGoalsConcededOverallForm(),
                            record.getHomeTeamAverageGoalsScoredHomeForm(), record.getHomeTeamAverageGoalsConcededHomeForm(), record.getAwayTeamAverageGoalsScoredAwayForm(), record.getAwayTeamAverageGoalsConcededAwayForm());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

}
