package uph.ii.borowiec.cinematickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uph.ii.borowiec.cinematickets.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
