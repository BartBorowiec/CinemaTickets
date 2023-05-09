package uph.ii.borowiec.cinematickets.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "screenings")
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Auditorium auditorium;

    private LocalDateTime startTime;

    @OneToMany(mappedBy = "screening",
            cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();
    public Screening() {
    }

    public Screening(Movie movie, Auditorium auditorium, LocalDateTime startTime, List<Reservation> reservations) {
        this.movie = movie;
        this.auditorium = auditorium;
        this.startTime = startTime;
        this.reservations = reservations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Film: " + movie.getTitle() +", sala kinowa nr " + auditorium.getName() + ", kino " + auditorium.getCinema().getCity() + "\n";
    }
}
