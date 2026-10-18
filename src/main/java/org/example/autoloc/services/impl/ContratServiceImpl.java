package org.example.autoloc.services.impl;

import org.example.autoloc.entities.Contrat;
import org.example.autoloc.repositories.ContratRepository;
import org.example.autoloc.service.ContratService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratServiceImpl implements ContratService {

    private final ContratRepository repository;

    public ContratServiceImpl(ContratRepository repository) {
        this.repository = repository;
    }

    @Override
    public Contrat ajouter(Contrat contrat) {
        return repository.save(contrat);
    }

    @Override
    public List<Contrat> afficherTous() {
        return repository.findAll();
    }

    @Override
    public Optional<Contrat> afficherParId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Contrat modifier(Long id, Contrat contrat) {
        Contrat existant = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrat introuvable"));

        contrat.setIdContrat(existant.getIdContrat());
        return repository.save(contrat);
    }

    @Override
    public void supprimer(Long id) {
        repository.deleteById(id);
    }
}