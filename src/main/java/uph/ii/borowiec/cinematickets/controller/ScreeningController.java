package uph.ii.borowiec.cinematickets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uph.ii.borowiec.cinematickets.dto.ReservationDto;
import uph.ii.borowiec.cinematickets.entity.Seat;
import uph.ii.borowiec.cinematickets.entity.Screening;
import uph.ii.borowiec.cinematickets.service.ScreeningService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/screening")
public class ScreeningController {
    ScreeningService screeningService;

    public ScreeningController(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }

    @GetMapping({"/{id}", "/{id}/"})
    public String showScreening(@PathVariable("id") Long id, Model model) {
        Screening screening = screeningService.getScreeningById(id);
        //1. wygeneruj miejsca dla sali kinowej wybranego seansu
        ReservationDto reservation = new ReservationDto();
        reservation.setScreening(screening);
        reservation.createSeats(screening);
        //2. dla wszystkich biletów wszystkich rezerwacji na dany seans ustaw isTaken na true
        reservation.updateStatusOfAllSeats(screening);
        //3. dodaj tablicę do modelu
        model.addAttribute("reservation", reservation);
        return "screening/screening";
    }
}
