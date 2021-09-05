package com.alfa.giphy_giver.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface GiphyService {
    ResponseEntity<Map> getGif(String tag);
}
