package com.sdabbous.learningspring.web;


import com.sdabbous.learningspring.business.GuestList;
import com.sdabbous.learningspring.business.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/guestList")
public class GuestListController {

    private final ReservationService reservationService;

    public GuestListController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String getGuestList(Model model){
        model.addAttribute("guests", this.reservationService.getGuestList());
        return "guestlist";
    }
}
