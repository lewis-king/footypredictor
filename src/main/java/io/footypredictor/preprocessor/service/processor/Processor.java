package io.footypredictor.preprocessor.service.processor;


import io.footypredictor.preprocessor.model.EnrichedFootballHistoricRecord;

import java.util.List;

public interface Processor {

    List<EnrichedFootballHistoricRecord> enrich(List<EnrichedFootballHistoricRecord> footballData);
}
