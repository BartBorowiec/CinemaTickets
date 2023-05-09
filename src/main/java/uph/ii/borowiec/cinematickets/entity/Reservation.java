package uph.ii.borowiec.cinematickets.entity;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Screening screening;

    @ManyToOne
    private User user;

    @OneToMany(
            mappedBy = "reservation",
            cascade = CascadeType.ALL)
    private Set<Ticket> tickets = new HashSet<>();

    public Reservation() {
    }

    public Reservation(User user, Screening screening, Set<Ticket> tickets) {
        this.user = user;
        this.screening = screening;
        this.tickets = tickets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
