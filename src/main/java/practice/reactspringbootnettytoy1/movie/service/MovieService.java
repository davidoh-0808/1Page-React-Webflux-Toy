package practice.reactspringbootnettytoy1.movie.service;

import practice.reactspringbootnettytoy1.movie.entity.Movie;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface MovieService {

    Flux<Movie> getAllMovies();

    Mono<Movie> saveMovie(Mono<Movie> movie);

}
