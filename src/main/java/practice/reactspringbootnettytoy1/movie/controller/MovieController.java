package practice.reactspringbootnettytoy1.movie.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import practice.reactspringbootnettytoy1.movie.entity.Movie;
import practice.reactspringbootnettytoy1.movie.service.MovieService;

import java.util.List;


@RequiredArgsConstructor
@Slf4j
@RestController
public class MovieController {

    private final MovieService movieService;

    @Bean
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @Bean
    public Movie saveMovie(Movie movie) {
        return movieService.saveMovie(movie);
    }


}
