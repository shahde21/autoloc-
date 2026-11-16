package org.example.autoloc.service;

import org.example.autoloc.entities.Employe;
import java.util.List;
import java.util.Optional;

public interface EmployeService {
    Employe desaffecterEmploye(Long idEmploye);

    Employe ajouter(Employe employe);

    List<Employe> afficherTous();

    Optional<Employe> afficherParId(Long id);

    Employe modifier(Long id, Employe employe);
    Employe affecterEmploye(Long idEmploye, Long idAgence);

    void supprimer(Long id);
}