package com.bestbetking.footypredictor.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "footypredictor.odds")
public class OddsConfig {

    private String api;
    private String apiKey;
    private List<String> leagues;

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public List<String> getLeagues() {
        return leagues;
    }

    public void setLeagues(List<String> leagues) {
        this.leagues = leagues;
    }
}
