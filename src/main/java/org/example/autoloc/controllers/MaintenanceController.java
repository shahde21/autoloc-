package org.example.autoloc.controllers;

import org.example.autoloc.entities.Maintenance;
import org.example.autoloc.service.MaintenanceService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/maintenances")
public class MaintenanceController {

    private final MaintenanceService service;

    public MaintenanceController(MaintenanceService service) {
        this.service = service;
    }

    @PostMapping
    public Maintenance ajouter(@RequestBody Maintenance maintenance) {
        return service.ajouter(maintenance);
    }

    @GetMapping
    public List<Maintenance> afficherTous() {
        return service.afficherTous();
    }

    @GetMapping("/{id}")
    public Maintenance afficherParId(@PathVariable Long id) {
        return service.afficherParId(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Maintenance modifier(@PathVariable Long id,
                                @RequestBody Maintenance maintenance) {
        return service.modifier(id, maintenance);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        service.supprimer(id);
    }
}