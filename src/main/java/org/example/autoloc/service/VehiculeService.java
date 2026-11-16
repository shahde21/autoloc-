package org.example.autoloc.service;

import org.example.autoloc.entities.Vehicule;
import java.util.List;
import java.util.Optional;

public interface VehiculeService {
    Vehicule affecterEquipement(Long idVehicule, Long idEquipement);

    Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement);

    Vehicule ajouter(Vehicule vehicule);

    List<Vehicule> afficherTous();

    Optional<Vehicule> afficherParId(Long id);

    Vehicule modifier(Long id, Vehicule vehicule);

    void supprimer(Long id);
}