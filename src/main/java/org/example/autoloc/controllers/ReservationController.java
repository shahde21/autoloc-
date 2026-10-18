package org.example.autoloc.controllers;

import org.example.autoloc.entities.Reservation;
import org.example.autoloc.service.ReservationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }

    @PostMapping
    public Reservation ajouter(@RequestBody Reservation reservation) {
        return service.ajouter(reservation);
    }

    @GetMapping
    public List<Reservation> afficherTous() {
        return service.afficherTous();
    }

    @GetMapping("/{id}")
    public Reservation afficherParId(@PathVariable Long id) {
        return service.afficherParId(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Reservation modifier(@PathVariable Long id,
                                @RequestBody Reservation reservation) {
        return service.modifier(id, reservation);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        service.supprimer(id);
    }
}