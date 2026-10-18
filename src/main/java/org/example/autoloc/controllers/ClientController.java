package org.example.autoloc.controllers;

import org.example.autoloc.entities.Client;
import org.example.autoloc.service.ClientService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    public Client ajouter(@RequestBody Client client) {
        return service.ajouter(client);
    }

    @GetMapping
    public List<Client> afficherTous() {
        return service.afficherTous();
    }

    @GetMapping("/{id}")
    public Client afficherParId(@PathVariable Long id) {
        return service.afficherParId(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Client modifier(@PathVariable Long id,
                           @RequestBody Client client) {
        return service.modifier(id, client);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        service.supprimer(id);
    }
}