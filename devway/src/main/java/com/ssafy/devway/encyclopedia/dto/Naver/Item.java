package com.ssafy.devway.encyclopedia.dto.Naver;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class Item {

    private String title;
    private String link;
    private String description;
    private String thumbnail;
}
