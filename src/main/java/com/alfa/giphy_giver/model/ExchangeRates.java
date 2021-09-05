package com.alfa.giphy_giver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRates {
//    disclaimer: "https://openexchangerates.org/terms/",
//    license: "https://openexchangerates.org/license/",
//    timestamp: 1449877801,
//    base: "USD",
//    rates:{
//        AED: 3.672538,
//                AFN: 66.809999,
//                ALL: 125.716501,
//                AMD: 484.902502,
//                ANG: 1.788575,
//                AOA: 135.295998,
//                ARS: 9.750101,
//                AUD: 1.390866,
//        /* ... */
//    }

    private String disclaimer;
    private String license;
    private int timestamp;
    private String base;
    private Map<String, Double> rates;

    public ExchangeRates() {
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}
