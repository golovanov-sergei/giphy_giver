package com.alfa.giphy_giver.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "Giphy", url = "${giphy.url}")
public interface FeignGiphyClient extends FeignGiphy{
    @Override
    @GetMapping("/random")
    ResponseEntity<Map> getRandomGif(
            @RequestParam("api_key") String api_key,
            @RequestParam("tag") String tag);
}
