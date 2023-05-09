package uph.ii.borowiec.cinematickets.service;

import org.springframework.stereotype.Service;
import uph.ii.borowiec.cinematickets.dto.ReservationDto;
import uph.ii.borowiec.cinematickets.entity.Reservation;
import uph.ii.borowiec.cinematickets.entity.Seat;
import uph.ii.borowiec.cinematickets.entity.Ticket;
import uph.ii.borowiec.cinematickets.repository.ReservationRepository;
import uph.ii.borowiec.cinematickets.repository.TicketRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class ReservationService {
    ReservationRepository reservationRepository;
    TicketRepository ticketRepository;

    public ReservationService(ReservationRepository reservationRepository, TicketRepository ticketRepository) {
        this.reservationRepository = reservationRepository;
        this.ticketRepository = ticketRepository;
    }

    public Reservation saveReservation(ReservationDto reservationDto) {
        Reservation reservation = new Reservation();
        reservation.setScreening(reservationDto.getScreening());
        reservation.setUser(null);
        Set<Ticket> tickets = new HashSet<>();
        for(Seat seat: reservationDto.getSeats()) {
            if(seat.getIsTaken())
                tickets.add(new Ticket(seat.getRowNumber(), seat.getSeatNumber(), reservation));
        }
        reservation.setTickets(tickets);
        return reservationRepository.save(reservation);
    }
}
