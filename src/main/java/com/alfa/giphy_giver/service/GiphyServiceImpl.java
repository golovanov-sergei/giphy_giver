package com.alfa.giphy_giver.service;

import com.alfa.giphy_giver.feign.FeignGiphyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

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
    public ResponseEntity<Map> getGif(String tag) {
        return feignGiphyClient.getRandomGif(this.apikey, tag);
    }
}
