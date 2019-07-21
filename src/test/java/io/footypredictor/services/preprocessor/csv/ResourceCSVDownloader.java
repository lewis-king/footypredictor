package io.footypredictor.services.preprocessor.csv;

import io.footypredictor.preprocessor.service.csv.CSVDownloader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class ResourceCSVDownloader implements CSVDownloader {

    public InputStream download(String path) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        return classloader.getResourceAsStream(path);
    }
}
