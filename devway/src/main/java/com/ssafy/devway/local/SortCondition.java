package com.ssafy.devway.local;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SortCondition {

    SORT_BY_ACCURACY("random"),
    SORT_BY_COMMENT("comment");

    public final String condition;
}
