package com.ssafy.devway.news.property;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class NewsProperites {

    private String clientId;
    private String clientSecretKey;
    private String url = "https://openapi.naver.com/v1/search/news";

    private String query;
    private Integer display = 10;
    private Integer start = 1;
    private String sort;

}
