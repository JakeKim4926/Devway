package com.ssafy.devway.typoConversion.property;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TypoConversionProperties {

    private String clientId;
    private String clientSecretKey;
    private String url = "https://openapi.naver.com/v1/search/errata";

    private String query;

}
