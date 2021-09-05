package com.alfa.giphy_giver.feign;

import com.alfa.giphy_giver.model.ExchangeRates;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface FeignOpenExchange {
//    @GetMapping("/currencies.json")
//    ResponseEntity<Map> getCodes();

    @GetMapping("/latest.json")
    ExchangeRates getCurRates(
            String appId,
            String base);

    @GetMapping("/historical/{date}.json")
    ExchangeRates getPrevRates(
            String prevDate,
            String appId,
            String base);
}
