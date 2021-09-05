package com.alfa.giphy_giver.feign;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

public interface FeignGiphy {
    @GetMapping("/random")
    ResponseEntity<Map> getRandomGif(String api_key,String tag);
}
