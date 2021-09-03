package com.esm.movies.service;

import com.esm.movies.entity.Rent;
import com.esm.movies.entity.Video;

/**
 * Created by HP on 9/2/2021.
 */
public interface RentService {
    Rent saveRent(Rent rent, Video video);
}
