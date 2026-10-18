package org.example.autoloc.services.impl;

import org.example.autoloc.entities.Paiement;
import org.example.autoloc.repositories.PaiementRepository;
import org.example.autoloc.service.PaiementService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaiementServiceImpl implements PaiementService {

    private final PaiementRepository repository;

    public PaiementServiceImpl(PaiementRepository repository) {
        this.repository = repository;
    }

    @Override
    public Paiement ajouter(Paiement paiement) {
        return repository.save(paiement);
    }

    @Override
    public List<Paiement> afficherTous() {
        return repository.findAll();
    }

    @Override
    public Optional<Paiement> afficherParId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Paiement modifier(Long id, Paiement paiement) {
        Paiement existant = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paiement introuvable"));

        paiement.setIdPaiement(existant.getIdPaiement());
        return repository.save(paiement);
    }

    @Override
    public void supprimer(Long id) {
        repository.deleteById(id);
    }
}