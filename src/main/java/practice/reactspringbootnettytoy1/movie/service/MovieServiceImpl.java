package practice.reactspringbootnettytoy1.movie.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import practice.reactspringbootnettytoy1.movie.entity.Movie;
// import practice.reactspringbootnettytoy1.movie.repository.MovieRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@RequiredArgsConstructor
@Slf4j
@Service
public class MovieServiceImpl implements MovieService {

    // private final MovieRepository movieRepository;


    @Override
    public Flux<Movie> getAllMovies() {

        /**
         *  *********** ERROR *************
         *  Reactive stack doesn't accept JPA (JDBC which is blocking)
         *
         *  Reactive Repositories are not supported by JPA;
         *  Offending repository is practice.reactspringbootnettytoy1.movie.repository.MovieRepository
         */
        //return movieRepository.getAllMovies();

        /*
        INSERT INTO movie (id, genre, title) VALUES (1, 'action', 'John Wick')
        INSERT INTO movie (id, genre, title) VALUES (2, 'action', 'The Fast And Furious')
        INSERT INTO movie (id, genre, title) VALUES (3, 'sci-fi', 'Interstellar')
         */
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(Movie.builder().id(1).genre("action").title("John Wick").build());
        movies.add(Movie.builder().id(2).genre("action").title("The Fast And Furious").build());
        movies.add(Movie.builder().id(3).genre("sci-fi").title("Interstellar").build());

        return Flux.fromIterable( movies );
    }

    @Override
    public Mono<Movie> saveMovie(Mono<Movie> movie) {
        return null;    // << TODO
    }


}
