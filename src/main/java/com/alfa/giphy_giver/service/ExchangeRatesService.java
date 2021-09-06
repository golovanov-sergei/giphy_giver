package com.alfa.giphy_giver.service;

import com.alfa.giphy_giver.model.ExchangeRates;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ExchangeRatesService {
    ExchangeRates refreshRates();
    List<String> getCurrencyCodes();
    ExchangeRates getPrevDayRates();
    ExchangeRates getCurDayRates();
    int compareCurrencies(String code);

}
