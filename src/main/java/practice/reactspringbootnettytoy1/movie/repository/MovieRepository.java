//package practice.reactspringbootnettytoy1.movie.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//import practice.reactspringbootnettytoy1.movie.entity.Movie;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import java.util.List;
//
///**
// *  *********** ERROR *************
// *  Reactive stack doesn't accept JPA (JDBC which is blocking)
// *
// *  Reactive Repositories are not supported by JPA;
// *  Offending repository is practice.reactspringbootnettytoy1.movie.repository.MovieRepository
// */
//@Repository
//public interface MovieRepository extends JpaRepository<Movie, Long> {
//
//    @Query("SELECT m FROM Movie m")
//    Flux<Movie> getAllMovies();
//
//
//
//}
