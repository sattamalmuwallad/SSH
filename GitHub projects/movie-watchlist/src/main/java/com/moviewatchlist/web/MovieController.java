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


    public MovieController(MovieService movieService) {
        this.movieService = movieService;
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

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        return movieService.updateMovie(id, movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }



}
