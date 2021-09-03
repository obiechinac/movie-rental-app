package com.esm.movies.service;

import com.esm.movies.entity.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Obi on 9/2/2021.
 */
public interface VideoService {
    Page<Video> findAll(Pageable pageable);
    void save(Video video);
    Video findByTitle(String title);
    Video findByid(long id);


}
