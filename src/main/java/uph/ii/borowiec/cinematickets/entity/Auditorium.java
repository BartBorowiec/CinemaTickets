package uph.ii.borowiec.cinematickets.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "auditoriums")
public class Auditorium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;

    private int seatRows;

    private int seatsInRow;

    @ManyToOne
    private Cinema cinema;

    public Auditorium() {
    }

    public Auditorium(int name, Cinema cinema) {
        this.number = name;
        this.cinema = cinema;
    }

    public Long getId() {
        return id;
    }

    public int getName() {
        return number;
    }

    public void setName(int name) {
        this.number = name;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public int getSeatRows() {return seatRows;}
    public void setSeatRows(int seatRows){
        this.seatRows = seatRows;
    }
    public int getSeatsInRow() { return seatsInRow; }
    public void setSeatsInRow(int seatsInRow) { this.seatRows = seatsInRow; }
}
