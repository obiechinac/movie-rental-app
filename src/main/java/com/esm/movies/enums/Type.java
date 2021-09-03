package com.esm.movies.enums;

import lombok.Getter;

/**
 * Created by Obi on 9/2/2021.
 */

public enum Type {
    REGULAR("Regular"),
    CHILDREN_MOVIE("Children's Movie"),
    NEW_RELEASE("New Release");

    private String value;

    Type(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
