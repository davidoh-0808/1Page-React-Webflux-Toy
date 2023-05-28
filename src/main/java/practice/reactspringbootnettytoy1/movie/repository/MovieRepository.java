package practice.reactspringbootnettytoy1.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import practice.reactspringbootnettytoy1.movie.entity.Movie;

import java.util.List;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m")
    List<Movie> getAllMovies();

}
