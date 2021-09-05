package com.alfa.giphy_giver.feign;


import com.alfa.giphy_giver.model.ExchangeRates;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "OpenExchange", url = "${openexchangerates.url}")
public interface FeignOpenExchangeClient extends FeignOpenExchange
{
//    @Override
//    @GetMapping("/currencies.json")
//    ResponseEntity<Map> getCodes();

    @Override
    @GetMapping("/latest.json")
    ExchangeRates getCurRates(
            @RequestParam("app_id") String appId,
            @RequestParam("base") String base);

    @Override
    @GetMapping("/historical/{date}.json")
    ExchangeRates getPrevRates(
            @PathVariable("date") String prevDate,
            @RequestParam("app_id") String appId,
            @RequestParam("base") String base);
}
