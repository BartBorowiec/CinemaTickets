package uph.ii.borowiec.cinematickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uph.ii.borowiec.cinematickets.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
