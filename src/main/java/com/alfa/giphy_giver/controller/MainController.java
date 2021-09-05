package com.alfa.giphy_giver.controller;

import com.alfa.giphy_giver.feign.FeignOpenExchange;
import com.alfa.giphy_giver.feign.FeignOpenExchangeClient;
import com.alfa.giphy_giver.model.ExchangeRates;
import com.alfa.giphy_giver.service.ExchangeRatesService;
import com.alfa.giphy_giver.service.ExchangeRatesServiceImpl;
import feign.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class MainController implements FeignOpenExchange {
//    private FeignOpenExchangeClient client;
    private ExchangeRatesServiceImpl exchangeRatesService;

//    public MainController(FeignOpenExchangeClient client) {
//        this.client = client;
//    }

    public MainController(ExchangeRatesServiceImpl exchangeRatesService) {
                this.exchangeRatesService = exchangeRatesService;
    }

//    @Override
//    @GetMapping("/get-codes")
//    public ResponseEntity<Map> getCodes() {
//        return exchangeRatesService.getCodes();
//    }

    @Override
    @GetMapping("/get-currates")
    public ExchangeRates getCurRates(String appId, String base) {
        exchangeRatesService.refreshRates();
        return exchangeRatesService.getCurDayRates();
    }

    @Override
    @GetMapping("/get-prevrates")
    public ExchangeRates getPrevRates(String prevDate, String appId, String base) {
        exchangeRatesService.refreshRates();
        return exchangeRatesService.getPrevDayRates();
    }

    @GetMapping("/rates")
    public List<String> getRates(){
        return exchangeRatesService.getCurrencyCodes();
    }
}
