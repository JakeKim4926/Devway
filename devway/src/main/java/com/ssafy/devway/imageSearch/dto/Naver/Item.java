package com.ssafy.devway.imageSearch.dto.Naver;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class Item {

    private String title;
    private String link;
    private String thumbnail;
    private String sizeheight;
    private String sizewidth;

}
