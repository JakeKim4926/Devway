package com.ssafy.devway.imageSearch.property;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ImageSearchProperties {

    private String clientId;
    private String clientSecretKey;
    private String url = "https://openapi.naver.com/v1/search/image";

    private String query;
    private Integer display = 10;
    private Integer start = 1;
    private String sort;
    private String filter;


}
