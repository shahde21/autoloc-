package org.example.autoloc.service;

import org.example.autoloc.entities.Reservation;
import java.util.List;
import java.util.Optional;

public interface ReservationService {

    Reservation ajouter(Reservation reservation);

    List<Reservation> afficherTous();

    Optional<Reservation> afficherParId(Long id);

    Reservation modifier(Long id, Reservation reservation);

    void supprimer(Long id);
}