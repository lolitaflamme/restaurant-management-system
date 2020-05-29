package web.controller;

import dao.entity.Reservation;
import dao.entity.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.api.ReservationService;
import service.api.RestaurantService;
import service.model.ReservationDto;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;
    private final RestaurantService restaurantService;

    @ModelAttribute(value = "reservationDto")
    public ReservationDto addReservationToModel() {
        return new ReservationDto();
    }

    @ModelAttribute()
    @GetMapping("/reservation")
    public String getReservationForm(Model model) {
        List<Restaurant> listOfAllRestaurants = restaurantService.getListOfAllRestaurants();
        model.addAttribute("listOfAllRestaurants", listOfAllRestaurants);
        return "reservation";
    }

    @PostMapping("/reservation")
    public String createReservation(@Valid ReservationDto reservationDto) {
        reservationService.createReservation(reservationDto);
        return "redirect:all-reservations";
    }

    @GetMapping("/all-reservations")
    public String getAllReservation(@RequestParam("page") int page, @RequestParam("size") int size, Model model) {
        List<Reservation> allReservations = reservationService.getAllReservations(page, size);
        model.addAttribute("allReservations", allReservations);
        return "all-reservations";
    }
}
