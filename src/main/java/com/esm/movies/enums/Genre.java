package com.esm.movies.enums;

/**
 * Created by Obi on 9/2/2021.
 */
public enum Genre {
ACTION("Action"),
    DRAMA("Drama"),
    ROMANCE("Romance"),
    COMEDY("Comedy"),
    HORROR("Horror");
private String name;

Genre(String name){
    this.name = name;
}

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "name='" + name + '\'' +
                '}';
    }
}
