package org.example.autoloc.services.impl;

import org.example.autoloc.entities.Client;
import org.example.autoloc.repositories.ClientRepository;
import org.example.autoloc.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Client ajouter(Client client) {
        return repository.save(client);
    }

    @Override
    public List<Client> afficherTous() {
        return repository.findAll();
    }

    @Override
    public Optional<Client> afficherParId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Client modifier(Long id, Client client) {
        Client existant = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        client.setIdClient(existant.getIdClient());
        return repository.save(client);
    }

    @Override
    public void supprimer(Long id) {
        repository.deleteById(id);
    }
}