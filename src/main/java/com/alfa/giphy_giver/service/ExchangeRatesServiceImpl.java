package com.alfa.giphy_giver.service;

import com.alfa.giphy_giver.feign.FeignOpenExchangeClient;
import com.alfa.giphy_giver.model.ExchangeRates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ExchangeRatesServiceImpl implements ExchangeRatesService {
    public ExchangeRates prevDayRates;
    public ExchangeRates curDayRates;
    private FeignOpenExchangeClient feignOpenExchangeClient;
    @Value("${openexchangerates.appid}")
    private String appId;
    @Value("${openexchangerates.base}")
    private String base;

    public ExchangeRates getPrevDayRates() {
        return prevDayRates;
    }

    public ExchangeRates getCurDayRates() {
        return curDayRates;
    }


    @Autowired
    public ExchangeRatesServiceImpl(FeignOpenExchangeClient feignOpenExchangeClient) {
        this.feignOpenExchangeClient = feignOpenExchangeClient;
    }

    @Override
    public ExchangeRates refreshRates() {
        Long curTime = System.currentTimeMillis();
        this.refreshCurrentRates();
        this.refreshPrevRates(curTime);
        return this.curDayRates;

    }

    public ExchangeRates refreshCurrentRates() {
        return this.curDayRates = feignOpenExchangeClient.getCurRates(appId, base);

    }

    //    public Set<String> getCurrencyCodes() {
//        return this.curDayRates.getRates().keySet();
//    }
    public List<String> getCurrencyCodes() {
        List<String> res = null;
        if (this.refreshCurrentRates() != null) {
            res = new ArrayList<>(this.curDayRates.getRates().keySet());
        }
        return res;
    }

    public ExchangeRates refreshPrevRates(Long curTime) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
        cal.setTimeInMillis(curTime);
        cal.add(Calendar.DATE,-1);
        String prevDate = sFormat.format(cal.getTime());

        return this.prevDayRates = feignOpenExchangeClient.getPrevRates(prevDate, appId, base);
    }
}
