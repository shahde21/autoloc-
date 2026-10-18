package org.example.autoloc.service;

import org.example.autoloc.entities.Agence;
import java.util.List;
import java.util.Optional;

public interface AgenceService {

    Agence ajouter(Agence agence);

    List<Agence> afficherTous();

    Optional<Agence> afficherParId(Long id);

    Agence modifier(Long id, Agence agence);

    void supprimer(Long id);
}