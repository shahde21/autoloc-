package org.example.autoloc.service;

import org.example.autoloc.entities.Equipement;
import java.util.List;
import java.util.Optional;

public interface EquipementService {

    Equipement ajouter(Equipement equipement);

    List<Equipement> afficherTous();

    Optional<Equipement> afficherParId(Long id);

    Equipement modifier(Long id, Equipement equipement);

    void supprimer(Long id);
}