package com.ssafy.devway.blog.dto;

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
public class BlogResponse {

    private String title;
    private String link;
    private String description;
    private String dateTime;

}
