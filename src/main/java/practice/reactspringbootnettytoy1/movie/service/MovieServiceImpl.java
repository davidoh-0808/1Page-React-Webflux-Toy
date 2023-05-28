package practice.reactspringbootnettytoy1.movie.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import practice.reactspringbootnettytoy1.movie.entity.Movie;
import practice.reactspringbootnettytoy1.movie.repository.MovieRepository;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;


    public List<Movie> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

}
