package com.esm.movies.entity;

import com.esm.movies.enums.Genre;
import com.esm.movies.enums.Type;
import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;

/**
 * Created by Obi on 9/2/2021.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String title;

    @NotBlank(message = "you must provide a valid video genre")
    private String genre;

    @NotBlank(message = "you must provide a valid video type")
    private String type;

    private int maximumAge;

    private String yearReleased;

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", type='" + type + '\'' +
                ", maximumAge=" + maximumAge +
                ", yearReleased='" + yearReleased + '\'' +
                '}';
    }
}
