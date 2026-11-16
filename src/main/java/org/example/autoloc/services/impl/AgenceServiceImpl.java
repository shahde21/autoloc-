
package org.example.autoloc.services.impl;

import org.example.autoloc.entities.Agence;
import org.example.autoloc.entities.Vehicule;
import org.example.autoloc.repositories.AgenceRepository;
import org.example.autoloc.repositories.VehiculeRepository;
import org.example.autoloc.service.AgenceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AgenceServiceImpl implements AgenceService {

    private final AgenceRepository repository;
    private final VehiculeRepository vehiculeRepository;

    public AgenceServiceImpl(
            AgenceRepository repository,
            VehiculeRepository vehiculeRepository) {

        this.repository = repository;
        this.vehiculeRepository = vehiculeRepository;
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
                .orElseThrow(() ->
                        new RuntimeException("Agence introuvable"));

        agence.setIdAgence(existante.getIdAgence());
        return repository.save(agence);
    }

    @Override
    public void supprimer(Long id) {
        repository.deleteById(id);
    }

    // SCENARIO 2 : Ajouter une agence avec ses véhicules

    @Override
    @Transactional
    public Agence ajouterAgenceEtAffecterVehicules(Agence agence) {

        List<Vehicule> vehicules = agence.getVehicules();

        agence.setVehicules(null);

        Agence agenceEnregistree = repository.save(agence);

        if (vehicules != null) {
            for (Vehicule vehicule : vehicules) {

                vehicule.setAgence(agenceEnregistree);

                vehiculeRepository.save(vehicule);
            }
        }

        return repository.findById(
                agenceEnregistree.getIdAgence()
        ).orElseThrow();
    }
}
