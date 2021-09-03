package com.esm.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Obi on 9/2/2021.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VideoDto {

    private Long id;
    private String type;
    private String genre;
    private String title;
}
