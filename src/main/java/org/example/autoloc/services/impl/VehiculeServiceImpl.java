
package org.example.autoloc.services.impl;

import org.example.autoloc.entities.Vehicule;
import org.example.autoloc.entities.Equipement;
import org.example.autoloc.repositories.VehiculeRepository;
import org.example.autoloc.repositories.EquipementRepository;
import org.example.autoloc.service.VehiculeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculeServiceImpl implements VehiculeService {

    private final VehiculeRepository repository;
    private final EquipementRepository equipementRepository;

    public VehiculeServiceImpl(
            VehiculeRepository repository,
            EquipementRepository equipementRepository) {

        this.repository = repository;
        this.equipementRepository = equipementRepository;
    }

    // CRUD EXISTANT

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
                .orElseThrow(() ->
                        new RuntimeException("Vehicule introuvable"));

        vehicule.setIdVehicule(existant.getIdVehicule());
        return repository.save(vehicule);
    }

    @Override
    public void supprimer(Long id) {
        repository.deleteById(id);
    }

    // SCENARIO 3 : AFFECTER UN EQUIPEMENT

    @Override
    @Transactional
    public Vehicule affecterEquipement(
            Long idVehicule, Long idEquipement) {

        Vehicule vehicule = repository.findById(idVehicule)
                .orElseThrow(() ->
                        new RuntimeException("Vehicule introuvable"));

        Equipement equipement = equipementRepository.findById(idEquipement)
                .orElseThrow(() ->
                        new RuntimeException("Equipement introuvable"));

        boolean dejaAffecte = vehicule.getEquipements()
                .stream()
                .anyMatch(e -> idEquipement.equals(e.getIdEquipement()));

        if (!dejaAffecte) {
            vehicule.getEquipements().add(equipement);
        }

        return repository.save(vehicule);
    }

    // SCENARIO 3 : DESAFFECTER UN EQUIPEMENT

    @Override
    @Transactional
    public Vehicule desaffecterEquipement(
            Long idVehicule, Long idEquipement) {

        Vehicule vehicule = repository.findById(idVehicule)
                .orElseThrow(() ->
                        new RuntimeException("Vehicule introuvable"));

        equipementRepository.findById(idEquipement)
                .orElseThrow(() ->
                        new RuntimeException("Equipement introuvable"));

        vehicule.getEquipements()
                .removeIf(e -> idEquipement.equals(e.getIdEquipement()));

        return repository.save(vehicule);
    }
}
