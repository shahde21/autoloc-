package org.example.autoloc.service;

import org.example.autoloc.entities.Contrat;
import java.util.List;
import java.util.Optional;

public interface ContratService {

    Contrat ajouter(Contrat contrat);

    List<Contrat> afficherTous();

    Optional<Contrat> afficherParId(Long id);

    Contrat modifier(Long id, Contrat contrat);

    void supprimer(Long id);
}