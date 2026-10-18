package org.example.autoloc.service;

import org.example.autoloc.entities.Client;
import java.util.List;
import java.util.Optional;

public interface ClientService {

    Client ajouter(Client client);

    List<Client> afficherTous();

    Optional<Client> afficherParId(Long id);

    Client modifier(Long id, Client client);

    void supprimer(Long id);
}