package uph.ii.borowiec.cinematickets.service;

import org.springframework.stereotype.Service;
import uph.ii.borowiec.cinematickets.entity.Cinema;
import uph.ii.borowiec.cinematickets.repository.CinemaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaService {
    private final CinemaRepository cinemaRepository;

    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }
    public List<Cinema> getAll() {
        return cinemaRepository.findAll();
    }
    public Optional<Cinema> getById(Long id) {
        return cinemaRepository.findById(id);
    }

    public Cinema getByName(String name) {
        return cinemaRepository.findByName(name);
    }
}
