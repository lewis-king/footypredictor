package io.footypredictor.preprocessor.service;

import io.footypredictor.model.prediction.Match;
import io.footypredictor.preprocessor.model.EnrichedFootballHistoricRecord;
import io.footypredictor.preprocessor.service.csv.CSVDownloader;
import io.footypredictor.preprocessor.service.csv.CSVReaderWriter;
import io.footypredictor.preprocessor.service.processor.AvgGoalsScoredAndConcededProcessor;
import io.footypredictor.preprocessor.service.processor.FormProcessor;
import io.footypredictor.preprocessor.service.processor.PromotedProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.footypredictor.preprocessor.constants.FootballDataMetadata.CURRENT_YEAR;

@Service
public class NewPredictionsDataPreProcessor {

    private CSVReaderWriter csvReaderWriter;
    private CSVDownloader csvDownloader;

    @Autowired
    public NewPredictionsDataPreProcessor(CSVReaderWriter csvReaderWriter, CSVDownloader csvDownloader) {
        this.csvReaderWriter = csvReaderWriter;
        this.csvDownloader = csvDownloader;
    }

    public List<EnrichedFootballHistoricRecord> enrichFootballData(List<Match> matches) {

        InputStream input = null;
        List<EnrichedFootballHistoricRecord> enrichedFootballData;
        List<EnrichedFootballHistoricRecord> footballData;
        try {
            input = csvDownloader.download("mmz4281" + File.separator + CURRENT_YEAR.substring(2, 6) + File.separator + matches.get(0).getLeague() + ".csv");
            footballData = csvReaderWriter.read(input);
        } catch (IOException e) {
            footballData = new ArrayList<>();
        }
        for (Match match : matches) {
            footballData.add(new EnrichedFootballHistoricRecord(match.getLeague(), match.getHomeTeam(), match.getAwayTeam()));
        }
        enrichedFootballData = new FormProcessor().enrich(footballData);
        enrichedFootballData = new PromotedProcessor().enrich(enrichedFootballData);
        enrichedFootballData = new AvgGoalsScoredAndConcededProcessor().enrich(enrichedFootballData);

        return enrichedFootballData.subList(enrichedFootballData.size() - matches.size(), enrichedFootballData.size());
    }

}
