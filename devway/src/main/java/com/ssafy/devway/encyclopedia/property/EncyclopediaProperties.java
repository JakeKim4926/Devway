package com.ssafy.devway.encyclopedia.property;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class EncyclopediaProperties {

    private String clientId;
    private String clientSecretKey;
    private String url = "https://openapi.naver.com/v1/search/encyc";

    private String query;
    private Integer display = 3;
    private Integer start = 1;
}
