package com.alfa.giphy_giver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitData {
    private ExchangeRatesService exchangeRatesService;

    @Autowired
    public InitData(ExchangeRatesService exchangeRatesService) {
        this.exchangeRatesService = exchangeRatesService;
    }

    @PostConstruct
    public void FirstLoad(){
        exchangeRatesService.refreshRates();
    }
}
