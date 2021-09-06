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

//контроллер для простого html с демонстрацией работы сервиса

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
        //Вывод данных для отладки
        //Курс предыдущего дня
        model.addAttribute("prevDayRates",exchangeRatesService.getPrevDayRates().getRates().get(code));
        //Курс текущего дня
        model.addAttribute("curDayRates",exchangeRatesService.getCurDayRates().getRates().get(code));
        //Базовая валюта USD, т.к. RUB недоступен на бесплатном аккаунте
        model.addAttribute("base",this.base);
        //Валюта для сравнения
        model.addAttribute("code",code);
        //Результат сравнения
        // 1 - курс вырос
        //-1 - курс уменьшился
        // 0 - курс неизменился, в задаче никак условие не было оговорено, поэтому выводим рандомную гифку без тэгов
        model.addAttribute("compareResult",exchangeRatesService.compareCurrencies(code));
        //список валют для сравнения
        model.addAttribute("list",exchangeRatesService.getCurrencyCodes());
        //url гифки
        model.addAttribute("img", giphyService.getGif(code).getStdUrl());
        return "showgif";
    }
}
