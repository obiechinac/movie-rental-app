package com.esm.movies.dto.error;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Obi on 9/2/2021.
 */
@Getter
@Setter
@NoArgsConstructor
public class ErrorResponse {

    private long status;
    private String message;
    private long timeStamp;
}
