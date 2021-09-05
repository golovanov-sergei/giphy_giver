package com.alfa.giphy_giver.controller;

import com.alfa.giphy_giver.model.ExchangeRates;
import com.alfa.giphy_giver.service.ExchangeRatesServiceImpl;
import com.alfa.giphy_giver.service.GiphyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MainController{
    private ExchangeRatesServiceImpl exchangeRatesService;
    private GiphyServiceImpl giphyService;
    @Value("${giphy.richtag}")
    private String richTag;
    @Value("${giphy.broketag}")
    private String brokeTag;

    @Autowired
    public MainController(ExchangeRatesServiceImpl exchangeRatesService, GiphyServiceImpl giphyService) {
        this.exchangeRatesService = exchangeRatesService;
        this.giphyService = giphyService;
    }



    @GetMapping("/get-currates")
    public ExchangeRates getCurRates(String appId, String base) {
        exchangeRatesService.refreshRates();
        return exchangeRatesService.getCurDayRates();
    }


    @GetMapping("/codes")
    public List<String> getCodes(){
        return exchangeRatesService.getCurrencyCodes();
    }

    @GetMapping("/getgif")
    public ResponseEntity<Map> getGif(@RequestParam("code") String code){
        int compareResult = exchangeRatesService.compareCurrencies(code);
        String tag;
        switch (compareResult){
            case 1:
                tag = this.richTag;
            case -1:
                tag = this.brokeTag;
            default:
                tag = "";
        }

        return giphyService.getGif(tag);
    }
}
