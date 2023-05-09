package uph.ii.borowiec.cinematickets.service;

import org.springframework.stereotype.Service;
import uph.ii.borowiec.cinematickets.entity.Cinema;
import uph.ii.borowiec.cinematickets.entity.Screening;
import uph.ii.borowiec.cinematickets.repository.ScreeningRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ScreeningService {
    ScreeningRepository screeningRepository;

    public ScreeningService(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    public Screening getScreeningById(Long id) {
        Optional<Screening> screening = screeningRepository.findById(id);
        if(screening.isPresent())
            return screening.get();
        return null;
    }

    public List<Screening> getMovieScreeningsByCinema(Cinema cinema, Long movieId) {
        return this.screeningRepository.getMovieScreenigs(cinema.getId(), movieId);
    }
}
