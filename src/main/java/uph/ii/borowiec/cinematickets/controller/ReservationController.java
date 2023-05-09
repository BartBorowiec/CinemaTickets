package uph.ii.borowiec.cinematickets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uph.ii.borowiec.cinematickets.dto.ReservationDto;
import uph.ii.borowiec.cinematickets.entity.Reservation;
import uph.ii.borowiec.cinematickets.entity.Seat;
import uph.ii.borowiec.cinematickets.entity.Ticket;
import uph.ii.borowiec.cinematickets.service.ReservationService;

import java.util.HashSet;
import java.util.Set;

@Controller
public class ReservationController {

    ReservationService reservationService;
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setAutoGrowCollectionLimit(768);
    }
    @PostMapping({"/reservation", "/reservation/"})
    public String handleReservation(
            @ModelAttribute("reservation") ReservationDto reservationDto,
            BindingResult bindingResult,
            Model model
    ) {
        model.addAttribute("reservation", reservationService.saveReservation(reservationDto));
        return "success";
    }
}
