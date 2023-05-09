package uph.ii.borowiec.cinematickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uph.ii.borowiec.cinematickets.entity.Cinema;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
    @Query(value = "SELECT * FROM cinemas WHERE city=:name", nativeQuery = true)
    Cinema findByName(String name);
}
