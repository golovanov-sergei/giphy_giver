package com.alfa.giphy_giver.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonAutoDetect
public class GifObject {
    private String type;
    private String id;
    private String url;
    private String embed_url;
    private String title;
    private String stdUrl;

    public String getStdUrl() {
        return stdUrl;
    }

    public void setStdUrl(String stdUrl) {
        this.stdUrl = stdUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmbed_url() {
        return embed_url;
    }

    public void setEmbed_url(String embed_url) {
        this.embed_url = embed_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("data")
    private void unpackNested(Map<String,Object> data) {
        this.type = (String)data.get("type");
        this.id = (String)data.get("id");
        this.url = (String)data.get("url");
        this.embed_url = (String)data.get("embed_url");
        this.title = (String)data.get("title");
        Map<String,Object> images = (Map<String, Object>)data.get("images");
        Map<String,Object> original = (Map<String, Object>)images.get("original");
        this.stdUrl = (String)original.get("url");
    }
}
