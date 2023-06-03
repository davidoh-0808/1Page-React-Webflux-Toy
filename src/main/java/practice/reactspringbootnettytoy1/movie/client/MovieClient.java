package practice.reactspringbootnettytoy1.movie.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import practice.reactspringbootnettytoy1.movie.entity.Movie;
import reactor.core.publisher.Flux;

@Slf4j
@Component
public class MovieClient {

    /*
        private WebClient client = WebClient.create("http://localhost:8080");
    public Mono<User> getUser(String userId){
       return client.get()
                .uri("/users/{userId}", userId)
                .retrieve()
                .bodyToMono(User.class).log(" User fetched ");
    }

    public Flux<User> getAllUsers(){
        return client.get()
                .uri("/users")
                .exchange().flatMapMany(clientResponse -> clientResponse.bodyToFlux(User.class)).log("Users Fetched : ");
    }
     */

    private WebClient client = WebClient.create("http://localhost:8080");

    public Flux<Movie> getMovies() {
        return client.get()
                // << invokes RestController endpoint /movies
                .uri("/movies")
                // << map the Rest API result into FLUX to be consumed in the web client
                .exchange().flatMapMany(clientResponse -> clientResponse.bodyToFlux(Movie.class))
                .log("Movies Fetched : ");
    }

}
