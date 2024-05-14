package com.ssafy.devway.imageSearch;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SearchCondition {

    SORT_BY_ACCURACY("sim"),
    SORT_BY_LATEST("date"),
    IMAGE_SIZE_ALL("all"),
    IMAGE_SIZE_LARGE("large"),
    IMAGE_SIZE_MEDIUM("medium"),
    IMAGE_SIZE_SMALL("small");

    public final String condition;
}
