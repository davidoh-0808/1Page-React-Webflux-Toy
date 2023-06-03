package practice.reactspringbootnettytoy1.movie.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import practice.reactspringbootnettytoy1.movie.entity.Movie;
import practice.reactspringbootnettytoy1.movie.service.MovieService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 *     The Spring RestTemplate class is, by nature, blocking.
 *     * Consequently, we do not want to use it in a reactive application.
 *     * For reactive applications, Spring offers the WebClient class, which is non-blocking.
 *
 *     using Webflux-provided WebClient to consume the RESTful service... was a bit difficult
 *     so just stuck with RestController
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/movies")
public class MovieController {

    /*
    // *********** Reactive Client to perform HTTP requests **********
    // private final WebClient webClient;

    public NettyWebClientMovie() {
        this.webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
    }

    // performs what MVC controllers would do, fetching data from reactive handler and returning it to the web client
    public Mono<Movie> callGetMoviesEndpoint(ServerRequest serverRequest) {

        log.info("***************" + serverRequest.toString() + "***************");

        return webClient
                .get().uri("/movies").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Movie.class)
                .subscribe(NettyReactiveHandlerMovie::getMovies);     //toDO: ************* FIX HERE *************
    }
     */


    private final MovieService movieService;


    @GetMapping
    public Flux<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Movie> saveMovie(Mono<Movie> movie) {
        return movieService.saveMovie(movie);
    }



}
