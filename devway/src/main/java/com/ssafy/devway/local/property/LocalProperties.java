package com.ssafy.devway.local.property;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LocalProperties {

    private String clientId;
    private String clientSecretKey;
    private String url = "https://openapi.naver.com/v1/search/local";

    private String query;
    private Integer display = 1;
    private Integer start = 1;
    private String sort;
}
