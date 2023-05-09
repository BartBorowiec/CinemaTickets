package uph.ii.borowiec.cinematickets.dto;

import uph.ii.borowiec.cinematickets.entity.Screening;
import uph.ii.borowiec.cinematickets.entity.Seat;

import java.util.ArrayList;
import java.util.List;

public class ReservationDto {
    List<Seat> seats;
    Screening screening;

    public void createSeats(Screening screening) {
        seats = new ArrayList<>();
        for(int i = 1; i <= screening.getAuditorium().getSeatRows(); i++) {
            for(int j = 1; j <= screening.getAuditorium().getSeatsInRow(); j++) {
                seats.add(new Seat(i, j));
            }
        }
    }

    public void updateStatusOfAllSeats(Screening screening) {
        for(Seat seat : seats)
            seat.setIsTakenForScreening(screening);
    }

    public ReservationDto() {
        List<Seat> seats = new ArrayList<>();
    }

    public ReservationDto(List<Seat> seats) {
        this.seats = seats;
    }

    public ReservationDto(List<Seat> seats, Screening screening) {
        this.seats = seats;
        this.screening = screening;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    @Override
    public String toString() {
        return "Screening " + screening.getMovie().getTitle() + ", seats " + seats.toString();
    }
}
