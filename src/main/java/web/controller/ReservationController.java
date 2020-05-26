package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import service.api.ReservationDtoService;
import service.model.ReservationDto;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class ReservationController {

    ReservationDtoService reservationDtoService;

    @GetMapping("/reservation")
    public String getReservationForm() {
        return "reservation";
    }

    @PostMapping("/reservation")
    public String createReservation(@Valid ReservationDto reservationDto) {
        reservationDtoService.createReservation(reservationDto);
        return "reservation";
    }
}
