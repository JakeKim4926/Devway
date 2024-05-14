package com.ssafy.devway.blog;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SortCondition {

    SORT_BY_ACCURACY("sim"),
    SORT_BY_LATEST("date");

    public final String condition;

}
