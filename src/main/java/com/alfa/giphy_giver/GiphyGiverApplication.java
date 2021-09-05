package com.alfa.giphy_giver;

import com.alfa.giphy_giver.service.ExchangeRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GiphyGiverApplication {

    private ExchangeRatesService exchangeRatesService;

    public static void main(String[] args) {
        SpringApplication.run(GiphyGiverApplication.class, args);
    }


}
