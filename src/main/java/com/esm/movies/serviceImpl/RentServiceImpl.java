package com.esm.movies.serviceImpl;

import com.esm.movies.entity.Rent;
import com.esm.movies.entity.Video;
import com.esm.movies.enums.Type;
import com.esm.movies.repository.RentRepository;
import com.esm.movies.service.RentService;
import com.esm.movies.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Obi on 9/2/2021.
 */
@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentRepository rentRepository;

    private final String regular = "Regular";
    private final String children = "Children's Movie";
    private final String newRelease = "New Release";
    private final int regular_rate = 10;
    private final int children_rate = 8;
    private final int newRelease_rate = 15;

    private int price;
    private String finalPriceString;


    @Override
    public Rent saveRent(Rent rent, Video video) {


        if (rent.getNumOfDays()<1){
            throw new NullPointerException("you have to chose renting days");
        }

            if (video.getType().equals(rent)) {

                price = regular_rate * rent.getNumOfDays();
            }
        if (video.getType().equals(children)) {
            price = (children_rate * rent.getNumOfDays()) + (video.getMaximumAge() / 2);
        }
        if (video.getType().equals(newRelease)) {
            int yearOfRelease = Integer.parseInt(video.getYearReleased());
            Integer thisYear = Integer.valueOf(new SimpleDateFormat("yyyy").format(new Date()));
            int years = thisYear - yearOfRelease;
            price = (newRelease_rate * rent.getNumOfDays()) - (years);
        }

        finalPriceString = Integer.toString(price) + " Dirr rentage fee";
        rent.setRentPrice(finalPriceString);

        return this.rentRepository.save(rent);

    }


//    public int computePrice(){
//
//    }
}
