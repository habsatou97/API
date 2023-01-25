package com.example.RelationClientBanque.controllers;

import com.example.RelationClientBanque.models.CompteBancaire;
import com.example.RelationClientBanque.services.ServiceCompteBancaire;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Transactional
public class CompteBancaireController {
    @Autowired
    ServiceCompteBancaire serviceCompteBancaire;

    public CompteBancaireController(ServiceCompteBancaire serviceCompteBancaire) {
        this.serviceCompteBancaire = serviceCompteBancaire;
    }

    @GetMapping("/comptesbancaires")
    public List<CompteBancaire> get()
    {
        return serviceCompteBancaire.getAllComptes();
    }
    @GetMapping("comptesbancaires/{id}")
    public Optional<Optional<CompteBancaire>> getById(@PathVariable Long id)
    {
        return serviceCompteBancaire.getCompteBancaireById(id);
    }
    @PostMapping("/comptesbancaires")
    public CompteBancaire create(CompteBancaire compteBancaire){
        return  serviceCompteBancaire.createCompteBancaire(compteBancaire);
    }
    @RequestMapping(value = "/comptesbancaires/{id}",method = RequestMethod.PUT)
    public CompteBancaire update(@RequestBody CompteBancaire compteBancaire,@PathVariable Long id)
    {
        return serviceCompteBancaire.updateCompteBancaire(compteBancaire,id);
    }

    @RequestMapping(value = "/comptesbancaires/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id)
    {
        serviceCompteBancaire.deleteCompteBancaireById(id);
    }
}
