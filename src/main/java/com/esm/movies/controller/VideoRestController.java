package com.esm.movies.controller;

import com.esm.movies.entity.Rent;
import com.esm.movies.entity.Video;
import com.esm.movies.enums.Type;
import com.esm.movies.service.RentService;
import com.esm.movies.service.VideoService;
import com.esm.movies.dto.VideoPrice;
import com.esm.movies.dto.VideoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Obi on 9/2/2021.
 */
@RestController
public class VideoRestController {
    final String children = "Children's Movie";
    final String newRelease = "New Release";

    @Autowired
    private VideoService videoService;

    @Autowired
    private RentService rentService;


    @PostMapping("/savevideo")
    public ResponseEntity saveVideo(@RequestBody Video video) {

        videoService.save(video);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/allvideos")
    public ResponseEntity<List<VideoDto>> findVideosPageable(@PageableDefault(size = 5) Pageable pageable) {

        Page<Video> videos = videoService.findAll(pageable);
        List<VideoDto> videoDtos = new ArrayList<>();
        for (Video video : videos.toList()) {
            VideoDto videoDto = new VideoDto();
            videoDto.setId(video.getId());
            videoDto.setTitle(video.getTitle());
            videoDto.setType(video.getType());
            videoDto.setGenre(video.getGenre());

            videoDtos.add(videoDto);
        }

        return new ResponseEntity<>(videoDtos, HttpStatus.OK);
    }

    @GetMapping("/video/{id}")
    public ResponseEntity<VideoPrice> findBYId(@PathVariable long id) {
        String regular_rate = "10 Birr/Day";
        String children_rate = "8 Birr/Day";
        String newRelease_rate = "15 Birr/Day";

        Video video = videoService.findByid(id);
        VideoPrice videoPrice = new VideoPrice();
        videoPrice.setTitle(video.getTitle());
        if (video.getType() == Type.REGULAR.getValue()) {
            videoPrice.setPriceRate(regular_rate);
        } else if (video.getTitle() == children) {
            videoPrice.setPriceRate(children_rate);
        } else {
            videoPrice.setPriceRate(newRelease_rate);
        }
        return new ResponseEntity<VideoPrice>(videoPrice, HttpStatus.OK);

    }

    @PostMapping("/rent")
    public ResponseEntity<String> rentVideo(@RequestBody Rent rent) {

        Video video = this.videoService.findByTitle(rent.getVideoTitle());

        System.out.println("found this video" + video.getTitle());
        Rent rent1 = this.rentService.saveRent(rent, video);
        String responseMessage = rent1.getRenterName() + " " + "rented " + rent1.getVideoTitle() + " for " + rent1.getNumOfDays()
                + " days " + "at : " + rent1.getRentPrice();

        return new ResponseEntity<String>(responseMessage, HttpStatus.OK);

    }


}
