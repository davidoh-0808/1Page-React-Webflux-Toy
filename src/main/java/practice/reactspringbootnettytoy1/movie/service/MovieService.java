package practice.reactspringbootnettytoy1.movie.service;

import practice.reactspringbootnettytoy1.movie.entity.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();

    Movie saveMovie(Movie movie);

}
