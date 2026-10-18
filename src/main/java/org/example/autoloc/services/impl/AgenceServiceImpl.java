package org.example.autoloc.services.impl;

import org.example.autoloc.entities.Agence;
import org.example.autoloc.repositories.AgenceRepository;
import org.example.autoloc.service.AgenceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgenceServiceImpl implements AgenceService {

    private final AgenceRepository repository;

    public AgenceServiceImpl(AgenceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Agence ajouter(Agence agence) {
        return repository.save(agence);
    }

    @Override
    public List<Agence> afficherTous() {
        return repository.findAll();
    }

    @Override
    public Optional<Agence> afficherParId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Agence modifier(Long id, Agence agence) {
        Agence existante = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agence introuvable"));

        agence.setIdAgence(existante.getIdAgence());
        return repository.save(agence);
    }

    @Override
    public void supprimer(Long id) {
        repository.deleteById(id);
    }
}