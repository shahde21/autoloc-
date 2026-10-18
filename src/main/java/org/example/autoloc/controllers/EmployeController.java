package org.example.autoloc.controllers;

import org.example.autoloc.entities.Employe;
import org.example.autoloc.service.EmployeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employes")
public class EmployeController {

    private final EmployeService service;

    public EmployeController(EmployeService service) {
        this.service = service;
    }

    @PostMapping
    public Employe ajouter(@RequestBody Employe employe) {
        return service.ajouter(employe);
    }

    @GetMapping
    public List<Employe> afficherTous() {
        return service.afficherTous();
    }

    @GetMapping("/{id}")
    public Employe afficherParId(@PathVariable Long id) {
        return service.afficherParId(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Employe modifier(@PathVariable Long id,
                            @RequestBody Employe employe) {
        return service.modifier(id, employe);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        service.supprimer(id);
    }
}