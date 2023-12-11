package com.sdabbous.learningspring.business;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sdabbous.learningspring.data.*;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {


    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomReservation> getRoomReservationsForDate(Date date) {
        Iterable<Room> rooms = this.roomRepository.findAll();
        Map<Long, RoomReservation> roomReservationMap = new HashMap();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getId());
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservationMap.put(room.getId(), roomReservation);
        });
        Iterable<Reservation> reservations = this.reservationRepository.findReservationByReservationDate(new java.sql.Date(date.getTime()));
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
            roomReservation.setDate(date);
            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
            roomReservation.setGuestId(guest.getId());
        });
        List<RoomReservation> roomReservations = new ArrayList<>();
        for (Long id : roomReservationMap.keySet()) {
            roomReservations.add(roomReservationMap.get(id));
        }
        roomReservations.sort(new Comparator<RoomReservation>() {
            @Override
            public int compare(RoomReservation o1, RoomReservation o2) {
                if (o1.getRoomName().equals(o2.getRoomName())) {
                    return o1.getRoomNumber().compareTo(o2.getRoomNumber());
                }
                return o1.getRoomName().compareTo(o2.getRoomName());
            }
        });
        return roomReservations;
    }


    public List<GuestList> getGuestList() {
        Iterable<Guest> guests = this.guestRepository.findAll();
        Map<Long, GuestList> guestListMap = new HashMap<>();

        guests.forEach(guest -> {
            GuestList guestList = new GuestList();
            guestList.setGuestId(guest.getId());
            guestList.setGuestLastName(guest.getLastName());
            guestList.setGuestFirstName(guest.getLastName());
            guestList.setGuestEmail(guest.getEmail());
            guestList.setGuestPhoneNumber(guest.getPhoneNumber());
            guestListMap.put(guest.getId(), guestList);
        });

        List<GuestList> guestLists = new ArrayList<>();
        for(Long id : guestListMap.keySet()){
            guestLists.add(guestListMap.get(id));
        }

        return guestLists;
    }
}

