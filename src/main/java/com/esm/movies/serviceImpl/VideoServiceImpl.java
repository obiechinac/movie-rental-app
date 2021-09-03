package com.esm.movies.serviceImpl;

import com.esm.movies.entity.Video;
import com.esm.movies.enums.Genre;
import com.esm.movies.enums.Type;
import com.esm.movies.repository.VideoRepository;
import com.esm.movies.service.VideoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * Created by Obi on 9/2/2021.
 */
@Service
public class VideoServiceImpl implements VideoService {


    private VideoRepository videoRepository;

    private String children = "Children's Movie";

    private String newRelease = "New Release";

    public VideoServiceImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public Page<Video> findAll(Pageable pageable) {
        return this.videoRepository.findAll(pageable);
    }


    @Override
    public void save(Video video) {

        video.setId(0);
        boolean isVideoValid = this.validateVideo(video);

        if (isVideoValid) {
            this.videoRepository.save(video);
        }
    }

    @Override
    public Video findByTitle(String title) {

        Optional<Video> videoOptional = this.videoRepository.findByTitle(title);
        if (videoOptional.isPresent()) {
            return videoOptional.get();
        } else {
            throw new NullPointerException(title + " Does not exist, please review and try again");
        }
    }

    @Override
    public Video findByid(long id) {
        return this.videoRepository.findById(id);
    }


    private boolean validateVideo(Video video) throws NullPointerException {

//        boolean isValidVideo = false;
        boolean isValidType = false;
        for (Type type : Type.values()) {
            System.out.println("Selected: " + video.getType() + " Iterating: " + type.getValue());
            if (type.getValue().equals(video.getType())) {
                isValidType = true;
                break;
            }
        }
        System.out.println(isValidType);
        if (!isValidType) {
            throw new NullPointerException("Invalid type: " + video.getType() + ". " + "use any of: Children's Movie, Regular, New Release");
        }

        boolean isValidGenre = false;
        for (Genre genre : Genre.values()) {
            if (genre.getName().equals(video.getGenre())) {
                isValidGenre = true;
            }
        }
        if (!isValidGenre) {
            throw new NullPointerException("Invalid genre: " + video.getGenre() + ". " + " use any of: Drama,Action,Romance,Comedy,Horror");
        }


        if (video.getType().equals(children) && (video.getMaximumAge() < 1)) {
            System.out.println("validating for max age ");

            throw new NullPointerException("You must set max age for children's video");
        } else if (video.getType().equals(newRelease) && video.getYearReleased() == null) {
            throw new NullPointerException("You must set Year Released eg 2014");


        }


        if (videoRepository.findByTitle(video.getTitle()).isPresent()) {
            throw new NullPointerException("Video title already exist");
        }


        return true;
    }
}
