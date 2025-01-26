package com.moviewatchlist.web;

import com.moviewatchlist.domain.Movie;
import com.moviewatchlist.repository.MovieRepository;
import com.moviewatchlist.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;
    private final MovieRepository movieRepository;

    public MovieController(MovieService movieService, MovieRepository movieRepository){
        this.movieService = movieService;
        this.movieRepository = movieRepository;
    }
    @GetMapping("/api/movies/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.findMovieById(id);
    }

    @GetMapping
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie){
        return movieService.saveMovie(movie);
    }

}
