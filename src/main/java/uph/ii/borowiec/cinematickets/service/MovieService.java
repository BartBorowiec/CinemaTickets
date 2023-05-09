package uph.ii.borowiec.cinematickets.service;

import org.springframework.stereotype.Service;
import uph.ii.borowiec.cinematickets.entity.Cinema;
import uph.ii.borowiec.cinematickets.entity.Movie;
import uph.ii.borowiec.cinematickets.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {
    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    public List<Movie> getMoviesByCinema(Cinema cinema) {
        return movieRepository.findMoviesByCinemaId(cinema.getId());
    }
}
