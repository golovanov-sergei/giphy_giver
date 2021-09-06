package com.alfa.giphy_giver.service;

import com.alfa.giphy_giver.model.GifObject;
import com.fasterxml.jackson.databind.JsonNode;

public interface GiphyService {
    GifObject getGif(String tag);
}
