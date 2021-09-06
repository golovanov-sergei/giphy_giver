package com.alfa.giphy_giver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GifData {
//            "type":"gif"
//            "id":"26ybwecV2HYVektEY"
//            "url":"https://giphy.com/gifs/money-ice-rich-26ybwecV2HYVektEY"
//            "slug":"money-ice-rich-26ybwecV2HYVektEY"
//            "bitly_gif_url":"http://gph.is/2eT7uUh"
//            "bitly_url":"http://gph.is/2eT7uUh"
//            "embed_url":"https://giphy.com/embed/26ybwecV2HYVektEY"
//            "username":"iceaudience"
//            "source":"directv.com/ice"
//            "title":"money bills GIF by Ice on Audience"
//            "rating":"g"
//            "content_url":""
//            "source_tld":""
//            "source_post_url":"directv.com/ice"
//            "is_sticker":0
//            "import_datetime":"2016-11-12 23:34:21"
//            "trending_datetime":"1970-01-01 00:00:00"

    String type;
    String id;
    String url;
    String embed_url;
    String title;
}
