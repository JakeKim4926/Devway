package com.ssafy.devway.local.dto.Naver;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class Item {

    private String title;
    private String link;
    private String category;
    private String description;
    private String telephone;
    private String address;
    private String roadAddress;
    private Integer mapx;
    private Integer mapy;

}
