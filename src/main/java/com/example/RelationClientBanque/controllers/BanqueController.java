package com.example.RelationClientBanque.controllers;

import com.example.RelationClientBanque.models.Banque;
import com.example.RelationClientBanque.services.ServiceBanque;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Transactional
public class BanqueController {
    @Autowired
    private ServiceBanque serviceBanque;

    public BanqueController(ServiceBanque serviceBanque) {
        this.serviceBanque = serviceBanque;
    }

    @RequestMapping
    @GetMapping("/banques")
    public List<Banque> get(){
        return serviceBanque.getAllBanques();
    }
    @GetMapping("/banques/{id}")
    public Optional<Banque> getById(@PathVariable Long id)
    {
        return serviceBanque.getBanqueById(id);
    }
    @PostMapping("/banques")
    public Banque create(@RequestBody Banque banque)
    {
        return serviceBanque.createBanque(banque);
    }
    @RequestMapping(value = "/banques/{id}",method = RequestMethod.PUT)
    public Banque update(@RequestBody Banque banque,@PathVariable Long id)
    {
        return serviceBanque.updateBanque(banque,id);
    }
    @RequestMapping(value = "/banques/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id)
    {
        serviceBanque.deleteBanqueById(id);
    }


}
