package com.esm.movies.repository;

import com.esm.movies.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Obi on 9/2/2021.
 */
@Repository
public interface RentRepository extends JpaRepository<Rent,Long> {
}
