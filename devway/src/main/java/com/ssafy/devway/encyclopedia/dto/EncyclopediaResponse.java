package com.ssafy.devway.encyclopedia.dto;

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
public class EncyclopediaResponse {

    private String title;
    private String link;
    private String description;
    private String thumbnail;

}
