package org.example.autoloc.services.impl;

import org.example.autoloc.entities.Maintenance;
import org.example.autoloc.repositories.MaintenanceRepository;
import org.example.autoloc.service.MaintenanceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    private final MaintenanceRepository repository;

    public MaintenanceServiceImpl(MaintenanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Maintenance ajouter(Maintenance maintenance) {
        return repository.save(maintenance);
    }

    @Override
    public List<Maintenance> afficherTous() {
        return repository.findAll();
    }

    @Override
    public Optional<Maintenance> afficherParId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Maintenance modifier(Long id, Maintenance maintenance) {
        Maintenance existante = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Maintenance introuvable"));

        maintenance.setIdMaintenance(existante.getIdMaintenance());
        return repository.save(maintenance);
    }

    @Override
    public void supprimer(Long id) {
        repository.deleteById(id);
    }
}