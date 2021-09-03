package com.esm.movies.serviceImpl;
import com.esm.movies.entity.Video;
import com.esm.movies.repository.VideoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by HP on 9/3/2021.
 */

//@RunWith(SpringRunner.class)
class VideoServiceImplTest {

    private VideoRepository videoRepository;
    private VideoServiceImpl videoService;

    @BeforeEach
    void setUp() {
        videoRepository = mock(VideoRepository.class);
        videoService = new VideoServiceImpl(videoRepository);
    }

//    Video video = new Video(1,"rango", "Comedy","Regular",0,"2014");
//    Video video1 = new Video(2,"sponge bob", "Drama","Children's Movie",14,"");
//    Video video2 = new Video(3,"Dictator", "Comedy","New Release",0,"2012");

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {
        List<Video> videoList = new ArrayList<>();

        when(videoRepository.findAll()).thenReturn(videoList);

        assertThat(videoList.size() == 0);
    }

    @Test
    void save() {
        when(videoRepository.save(any())).then(returnsFirstArg());
    }

    @Test
    void findByTitle() {
    }

    @Test
    void findByid() {
    }

}