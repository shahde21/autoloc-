package org.example.autoloc.services.impl;

import org.example.autoloc.entities.Vehicule;
import org.example.autoloc.repositories.VehiculeRepository;
import org.example.autoloc.service.VehiculeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculeServiceImpl implements VehiculeService {

    private final VehiculeRepository repository;

    public VehiculeServiceImpl(VehiculeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Vehicule ajouter(Vehicule vehicule) {
        return repository.save(vehicule);
    }

    @Override
    public List<Vehicule> afficherTous() {
        return repository.findAll();
    }

    @Override
    public Optional<Vehicule> afficherParId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Vehicule modifier(Long id, Vehicule vehicule) {
        Vehicule existant = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicule introuvable"));

        vehicule.setIdVehicule(existant.getIdVehicule());
        return repository.save(vehicule);
    }

    @Override
    public void supprimer(Long id) {
        repository.deleteById(id);
    }
}