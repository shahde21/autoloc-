
package org.example.autoloc.services.impl;

import org.example.autoloc.entities.Agence;
import org.example.autoloc.entities.Employe;
import org.example.autoloc.repositories.AgenceRepository;
import org.example.autoloc.repositories.EmployeRepository;
import org.example.autoloc.service.EmployeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeServiceImpl implements EmployeService {

    private final EmployeRepository repository;
    private final AgenceRepository agenceRepository;

    public EmployeServiceImpl(
            EmployeRepository repository,
            AgenceRepository agenceRepository) {

        this.repository = repository;
        this.agenceRepository = agenceRepository;
    }

    @Override
    public Employe ajouter(Employe employe) {
        return repository.save(employe);
    }

    @Override
    public List<Employe> afficherTous() {
        return repository.findAll();
    }

    @Override
    public Optional<Employe> afficherParId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Employe modifier(Long id, Employe employe) {
        Employe existant = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Employe introuvable"));

        employe.setIdEmploye(existant.getIdEmploye());
        return repository.save(employe);
    }

    @Override
    public void supprimer(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Employe desaffecterEmploye(Long idEmploye) {

        Employe employe = repository.findById(idEmploye)
                .orElseThrow(() ->
                        new RuntimeException("Employe introuvable"));

        employe.setAgence(null);

        return repository.save(employe);
    }

    @Override
    public Employe affecterEmploye(Long idEmploye, Long idAgence) {

        Employe employe = repository.findById(idEmploye)
                .orElseThrow(() ->
                        new RuntimeException("Employe introuvable"));

        Agence agence = agenceRepository.findById(idAgence)
                .orElseThrow(() ->
                        new RuntimeException("Agence introuvable"));

        employe.setAgence(agence);

        return repository.save(employe);
    }
}
