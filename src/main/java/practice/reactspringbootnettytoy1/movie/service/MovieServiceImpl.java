package practice.reactspringbootnettytoy1.movie.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import practice.reactspringbootnettytoy1.movie.repository.MovieRepository;

@RequiredArgsConstructor
@Slf4j
@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

}
