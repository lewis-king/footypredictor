package io.footypredictor.preprocessor.service;

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
import java.util.List;

import static io.footypredictor.preprocessor.constants.FootballDataMetadata.LEAGUES;
import static io.footypredictor.preprocessor.constants.FootballDataMetadata.HISTORIC_YEARS;


@Service
public class HistoricDataPreProcessor {

    private CSVReaderWriter csvReaderWriter;
    private CSVDownloader csvDownloader;


    @Autowired
    public HistoricDataPreProcessor(CSVReaderWriter csvReaderWriter, CSVDownloader csvDownloader) {
        this.csvReaderWriter = csvReaderWriter;
        this.csvDownloader = csvDownloader;
    }

    public List<List<EnrichedFootballHistoricRecord>> enrichFootballData() {

        List<List<EnrichedFootballHistoricRecord>> enrichedFootballDatas = new ArrayList<>();

        for (String year : HISTORIC_YEARS) {
            for (String league : LEAGUES) {
                List<EnrichedFootballHistoricRecord> enrichedFootballData = null;
                try {
                    InputStream input = csvDownloader.download("data" + File.separator + year + File.separator + league + ".csv");
                    List<EnrichedFootballHistoricRecord> footballData = csvReaderWriter.read(input);
                    enrichedFootballData = new FormProcessor().enrich(footballData);
                    enrichedFootballData = new PromotedProcessor().enrich(enrichedFootballData);
                    enrichedFootballData = new AvgGoalsScoredAndConcededProcessor().enrich(enrichedFootballData);

                    csvReaderWriter.write(enrichedFootballData, year, league);
                    enrichedFootballDatas.add(enrichedFootballData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return enrichedFootballDatas;
    }

}
