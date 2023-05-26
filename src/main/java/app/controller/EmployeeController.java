package app.controller;

import app.model.Fee;
import app.model.Floor;
import app.model.Reservation;
import app.model.dto.ReservationAddForm;
import app.model.dto.ReservationEditForm;
import app.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/user/employee")
public class EmployeeController {
    private final ReservationService reservationService;

    public EmployeeController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    //check in
    @PostMapping(path = "/check-in-car", consumes = {"application/json"})
    public ResponseEntity<?> createReservation(@RequestBody final ReservationAddForm reservationAddForm) {
        this.reservationService.saveReservation(reservationAddForm);
        return new ResponseEntity<>("reservation created", HttpStatus.CREATED);
    }

    // check out -> sets exitDate to currentDate()
    @PutMapping(path = "/check-out-car/{reservationId}")
    public ResponseEntity<?> endReservation(@RequestBody ReservationEditForm reservationEditForm, @PathVariable Long reservationId){
        this.reservationService.updateReservation(reservationEditForm, reservationId);
        return new ResponseEntity<>("checkout successful", HttpStatus.OK);
    }

    @GetMapping(path = "panel-reservations/{parkingId}")
    public List<Reservation> getAllReservations(@PathVariable Long parkingId){
        return this.reservationService.findAllCurrentReservations(parkingId);
    }

    @GetMapping(path = "fees/{parkingId}")
    public List<Fee> getAllFees(@PathVariable Long parkingId){
        return this.reservationService.findAllFees(parkingId);
    }

    @GetMapping(path = "floors/{parkingId}")
    public List<Floor> getAllFloors(@PathVariable Long parkingId){
        return this.reservationService.findAllFloors(parkingId);
    }
}