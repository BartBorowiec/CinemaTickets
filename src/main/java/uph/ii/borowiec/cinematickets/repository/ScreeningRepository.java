package uph.ii.borowiec.cinematickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uph.ii.borowiec.cinematickets.entity.Screening;

import java.util.List;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    @Query(value ="SELECT screenings.* FROM cinemas INNER JOIN auditoriums on cinemas.id = auditoriums.cinema_id INNER JOIN screenings on auditoriums.id=screenings.auditorium_id INNER JOIN movies on screenings.movie_id=movies.id WHERE cinemas.id=:cinemaId AND movies.id=:movieId", nativeQuery = true)
    List<Screening> getMovieScreenigs(Long cinemaId, Long movieId);
}
