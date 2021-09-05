package com.alfa.giphy_giver.controller;

import com.alfa.giphy_giver.service.ExchangeRatesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FrontController {
    private ExchangeRatesServiceImpl exchangeRatesService;

    @Autowired
    public FrontController(ExchangeRatesServiceImpl exchangeRatesService) {
        this.exchangeRatesService = exchangeRatesService;
    }

    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("greeting","hello MF");
        model.addAttribute("list",exchangeRatesService.getCurrencyCodes());
        return "index";
    }
}
