package org.example.autoloc.service;

import org.example.autoloc.entities.Maintenance;
import java.util.List;
import java.util.Optional;

public interface MaintenanceService {

    Maintenance ajouter(Maintenance maintenance);

    List<Maintenance> afficherTous();

    Optional<Maintenance> afficherParId(Long id);

    Maintenance modifier(Long id, Maintenance maintenance);

    void supprimer(Long id);
}