package org.example.autoloc.services.impl;

import org.example.autoloc.entities.Reservation;
import org.example.autoloc.repositories.ReservationRepository;
import org.example.autoloc.service.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository;

    public ReservationServiceImpl(ReservationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Reservation ajouter(Reservation reservation) {
        return repository.save(reservation);
    }

    @Override
    public List<Reservation> afficherTous() {
        return repository.findAll();
    }

    @Override
    public Optional<Reservation> afficherParId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Reservation modifier(Long id, Reservation reservation) {
        Reservation existante = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation introuvable"));

        reservation.setIdReservation(existante.getIdReservation());
        return repository.save(reservation);
    }

    @Override
    public void supprimer(Long id) {
        repository.deleteById(id);
    }
}