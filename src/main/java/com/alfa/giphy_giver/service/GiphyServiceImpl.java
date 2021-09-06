package com.alfa.giphy_giver.service;

import com.alfa.giphy_giver.feign.FeignGiphyClient;
import com.alfa.giphy_giver.model.GifObject;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GiphyServiceImpl implements GiphyService{
    private FeignGiphyClient feignGiphyClient;
    @Value("${giphy.apikey}")
    private String apikey;

    @Autowired
    public GiphyServiceImpl(FeignGiphyClient feignGiphyClient) {
        this.feignGiphyClient = feignGiphyClient;
    }

    @Override
    public GifObject getGif(String tag) {
        return feignGiphyClient.getRandomGif(this.apikey, tag);
    }
}
