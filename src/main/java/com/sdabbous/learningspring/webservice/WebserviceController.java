package com.sdabbous.learningspring.webservice;

import com.sdabbous.learningspring.business.ReservationService;
import com.sdabbous.learningspring.business.RoomReservation;
import com.sdabbous.learningspring.data.Guest;
import com.sdabbous.learningspring.data.Room;
import com.sdabbous.learningspring.util.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WebserviceController {

    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public WebserviceController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<RoomReservation> getReservations(@RequestParam(value = "date", required = false) String datString){
        Date date = this.dateUtils.createDateFromDateString(datString);
        return this.reservationService.getRoomReservationsForDate(date);
    }

    @PostMapping("/guests") //POST
    @ResponseStatus(HttpStatus.CREATED)
    public void addGuest(@RequestBody Guest guest){
        this.reservationService.addGuest(guest);
    }

    @RequestMapping(path = "/guests", method = RequestMethod.GET) //GET
    public List<Guest> getGuests(){
        return this.reservationService.getGuestList();
    }

    @RequestMapping(path = "/rooms", method = RequestMethod.GET)
    public List<Room> getRooms(){
        return this.reservationService.getRoom();
    }
}
