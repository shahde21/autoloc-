package org.example.autoloc.service;

import org.example.autoloc.entities.Paiement;
import java.util.List;
import java.util.Optional;

public interface PaiementService {

    Paiement ajouter(Paiement paiement);

    List<Paiement> afficherTous();

    Optional<Paiement> afficherParId(Long id);

    Paiement modifier(Long id, Paiement paiement);

    void supprimer(Long id);
}