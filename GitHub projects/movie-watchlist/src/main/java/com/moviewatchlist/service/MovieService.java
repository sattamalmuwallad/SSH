package com.moviewatchlist.service;


import com.moviewatchlist.domain.Movie;
import com.moviewatchlist.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;


@Service
public class MovieService {

    private final MovieRepository movieRepository;

     public MovieService(MovieRepository movieRepository){
         this.movieRepository = movieRepository;
     }

     public Movie saveMovie(Movie movie){
         return movieRepository.save(movie);
     }


    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }
    public boolean isMoviePresent(Long id) {
        return movieRepository.existsById(id);
    }

    public Movie findMovieById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
         if (isMoviePresent(id)){
             return movieRepository.findById(id).get();
         } else {
             throw new RuntimeException("We couldn't find the movie your lookig for"+ id);
         }

    }
    public Movie updateMovie(Long id, Movie updatedMovie) {
        if (!movieRepository.existsById(id)) {
            throw new RuntimeException("Movie not found with ID: " + id);
        }

        Movie existingMovie = movieRepository.findById(id).get();
        existingMovie.setTitle(updatedMovie.getTitle());
        existingMovie.setDirector(updatedMovie.getDirector());
        existingMovie.setReleaseYear(updatedMovie.getReleaseYear());
        return movieRepository.save(existingMovie);
    }

    public void deleteMovie(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new RuntimeException("Movie not found with ID: " + id);
        }
        movieRepository.deleteById(id);
    }


}
