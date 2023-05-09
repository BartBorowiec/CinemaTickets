package uph.ii.borowiec.cinematickets.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cinemas")
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    @OneToMany
    private Set<Auditorium> auditoriums = new HashSet<>();

    public Cinema() {
    }

    public Cinema(String name, Set<Auditorium> auditoriums) {
        this.city = name;
        this.auditoriums = auditoriums;
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String name) {
        this.city = name;
    }

    public Set<Auditorium> getAuditoriums() {
        return auditoriums;
    }

    public void setAuditoriums(Set<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }
}