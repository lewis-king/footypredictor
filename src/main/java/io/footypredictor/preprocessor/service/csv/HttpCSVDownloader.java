package io.footypredictor.preprocessor.service.csv;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Service
public class HttpCSVDownloader implements CSVDownloader {

    private static final String FOOTBALL_DATA_HOST = "http://www.football-data.co.uk/";

    public InputStream download(String path) throws IOException {
        return new URL(FOOTBALL_DATA_HOST + path).openStream();
    }
}
