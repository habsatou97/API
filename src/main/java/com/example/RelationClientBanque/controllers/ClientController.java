package com.example.RelationClientBanque.controllers;

import com.example.RelationClientBanque.models.Client;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.RelationClientBanque.services.ServiceClient;

import java.util.List;
import java.util.Optional;

@RestController
@Transactional

public class ClientController {
    @Autowired
    private  ServiceClient serviceClient;

    public ClientController(ServiceClient serviceClient) {
        this.serviceClient = serviceClient;
    }

    @GetMapping("/clients")
    public List<Client> get(){
        return serviceClient.getAllClients();
    }
    @GetMapping("/clients/{id}")
    public Optional<Optional<Client>> getById(@PathVariable Long id)
    {
        return serviceClient.getClientById(id);
    }
    @PostMapping("/clients")
    public  Client create(Client client)
    {
        return serviceClient.createClient(client);
    }
    @RequestMapping (value = "/clients/{id}", method=RequestMethod.PUT)
    public Client update(@RequestBody Client client,@PathVariable Long id)
    {

        return serviceClient.updateClient(client,id);
    }
    @RequestMapping(value ="/clients/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id)
    {
        serviceClient.deleteClientById(id);
    }
}
