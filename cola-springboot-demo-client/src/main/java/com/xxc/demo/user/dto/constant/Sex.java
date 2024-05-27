package com.xxc.demo.user.dto.constant;

import lombok.Getter;

@Getter
public enum Sex {
    UNKNOWN("未知"),
    MALE("男"),
    FEMALE("女");

    private final String description;

    Sex(String description) {
        this.description = description;
    }
}
