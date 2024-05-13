package com.ssafy.devway.news.dto.Naver;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class Item {

    private String title;
    private String originallink;
    private String link;
    private String description;
    private String pubDate;

}
