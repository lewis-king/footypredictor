package com.bestbetking.footypredictor.configuration;

import com.bestbetking.footypredictor.services.odds.FootballOddsRetriever;
import com.bestbetking.footypredictor.services.odds.OddsRetriever;
import com.bestbetking.footypredictor.services.odds.stub.DummyFootballOddsRetriever;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public OddsRetriever oddsRetriever() throws IOException {
        //return new FootballOddsRetriever();
        return new DummyFootballOddsRetriever();
    }

}
