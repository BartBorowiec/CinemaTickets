package uph.ii.borowiec.cinematickets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uph.ii.borowiec.cinematickets.entity.Cinema;
import uph.ii.borowiec.cinematickets.entity.Movie;
import uph.ii.borowiec.cinematickets.entity.Screening;
import uph.ii.borowiec.cinematickets.service.CinemaService;
import uph.ii.borowiec.cinematickets.service.MovieService;
import uph.ii.borowiec.cinematickets.service.ScreeningService;

import java.util.List;

@Controller
@RequestMapping("/cinema")
public class CinemaController {

    CinemaService cinemaService;
    MovieService movieService;
    ScreeningService screeningService;

    public CinemaController(CinemaService cinemaService, MovieService movieService, ScreeningService screeningService) {
        this.cinemaService = cinemaService;
        this.movieService = movieService;
        this.screeningService = screeningService;
    }

    @GetMapping({"/", ""})
    public String listCinemas(Model model) {
        model.addAttribute("cinemas", cinemaService.getAll());
        return "cinema/cinemas";
    }

    @GetMapping({"/{city}/","/{city}"})
    public String handleCity(@PathVariable("city") String cityName, @RequestParam(value = "movie", required = false) Long movieId, Model model) {
        Cinema cinema = cinemaService.getByName(cityName);
        model.addAttribute("cinema", cinema);
        if(movieId != null) {
            List<Screening> screenings = screeningService.getMovieScreeningsByCinema(cinema, movieId);
            model.addAttribute("screenings", screenings);
            return "screening/screenings";
        }
        else {
            List<Movie> movies = movieService.getMoviesByCinema(cinema);
            model.addAttribute("movies", movies);
            return "cinema/cinema";
        }
    }
}
