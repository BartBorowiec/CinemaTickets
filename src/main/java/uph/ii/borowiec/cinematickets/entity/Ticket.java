package uph.ii.borowiec.cinematickets.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int seatRow;
    private int seatNumber;

    @ManyToOne
    private Reservation reservation;

    public Ticket() {}
    public Ticket(int seatRow, int seatNumber) {
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
    }

    public Ticket(int seatRow, int seatNumber, Reservation reservation) {
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
        this.reservation = reservation;
    }

    public Ticket(Long id, int seatRow, int seatNumber, Reservation reservation) {
        this.id = id;
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
        this.reservation = reservation;
    }

    public Long getId() {
        return id;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "Rząd: " + seatRow + ", miejsce: " + seatNumber + "\n";
    }
}
