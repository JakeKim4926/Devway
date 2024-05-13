package com.ssafy.devway.local.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class LocalResponse {

    private String title;
    private String link;
    private String category;
    private String description;
    private String telephone;
    private String roadAddress;
}
