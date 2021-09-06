package com.alfa.giphy_giver.controller;

import com.alfa.giphy_giver.model.GifObject;
import com.alfa.giphy_giver.service.ExchangeRatesService;
import com.alfa.giphy_giver.service.ExchangeRatesServiceImpl;
import com.alfa.giphy_giver.service.GiphyService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FrontController {
    private ExchangeRatesService exchangeRatesService;
    private GiphyService giphyService;
    @Value("${openexchangerates.base}")
    private String base;
    private Double prevRates;
    private Double curRates;

    @Autowired
    public FrontController(ExchangeRatesService exchangeRatesService, GiphyService giphyService) {
        this.exchangeRatesService = exchangeRatesService;
        this.giphyService = giphyService;
    }

    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("list",exchangeRatesService.getCurrencyCodes());
        return "index";
    }
    @GetMapping("/showgif")
    public String showGif(@RequestParam("code") String code, Model model){
        model.addAttribute("prevDayRates",exchangeRatesService.getPrevDayRates().getRates().get(code));
        model.addAttribute("curDayRates",exchangeRatesService.getCurDayRates().getRates().get(code));
        model.addAttribute("base",this.base);
        model.addAttribute("code",code);
        model.addAttribute("compareResult",exchangeRatesService.compareCurrencies(code));
        model.addAttribute("list",exchangeRatesService.getCurrencyCodes());
        model.addAttribute("img", giphyService.getGif(code).getStdUrl());
        return "showgif";
    }
}
