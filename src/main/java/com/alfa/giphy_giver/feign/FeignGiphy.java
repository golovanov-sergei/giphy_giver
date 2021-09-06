package com.alfa.giphy_giver.feign;

import com.alfa.giphy_giver.model.GifObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

public interface FeignGiphy {
    @GetMapping("/random")
    GifObject getRandomGif(String api_key, String tag);
}
