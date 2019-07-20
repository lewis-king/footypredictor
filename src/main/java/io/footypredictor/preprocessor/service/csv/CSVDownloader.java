package io.footypredictor.preprocessor.service.csv;

import java.io.IOException;
import java.io.InputStream;

public interface CSVDownloader {

    InputStream download(String path) throws IOException;

}
