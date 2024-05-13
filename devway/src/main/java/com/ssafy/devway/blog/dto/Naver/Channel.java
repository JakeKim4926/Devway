package com.ssafy.devway.blog.dto.Naver;


import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class Channel {

    private String lastBuildDate;
    private Integer total;
    private Integer start;
    private Integer display;
    private List<Item> items;

}
