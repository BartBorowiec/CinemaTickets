package uph.ii.borowiec.cinematickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uph.ii.borowiec.cinematickets.entity.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query(value ="SELECT DISTINCT movies.id, movies.title FROM cinemas INNER JOIN auditoriums on cinemas.id = auditoriums.cinema_id INNER JOIN screenings on auditoriums.id=screenings.auditorium_id INNER JOIN movies on screenings.movie_id=movies.id WHERE cinemas.id=:cinemaId", nativeQuery = true)
    List<Movie> findMoviesByCinemaId(Long cinemaId);
}
