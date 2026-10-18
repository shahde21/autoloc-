package org.example.autoloc.services.impl;

import org.example.autoloc.entities.Equipement;
import org.example.autoloc.repositories.EquipementRepository;
import org.example.autoloc.service.EquipementService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipementServiceImpl implements EquipementService {

    private final EquipementRepository repository;

    public EquipementServiceImpl(EquipementRepository repository) {
        this.repository = repository;
    }

    @Override
    public Equipement ajouter(Equipement equipement) {
        return repository.save(equipement);
    }

    @Override
    public List<Equipement> afficherTous() {
        return repository.findAll();
    }

    @Override
    public Optional<Equipement> afficherParId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Equipement modifier(Long id, Equipement equipement) {
        Equipement existant = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipement introuvable"));

        equipement.setIdEquipement(existant.getIdEquipement());
        return repository.save(equipement);
    }

    @Override
    public void supprimer(Long id) {
        repository.deleteById(id);
    }
}