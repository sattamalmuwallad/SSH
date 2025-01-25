package com.moviewatchlist.repository;

import com.moviewatchlist.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository <Movie,Long> {

}
