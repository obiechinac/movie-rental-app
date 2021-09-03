package com.esm.movies.repository;

import com.esm.movies.entity.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Obi on 9/2/2021.
 */
@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

//    Video findByTitle(String title);
    Video findById(long id);
    Optional<Video> findByTitle(String title);

}
