package com.example.RelationClientBanque.services;

import com.example.RelationClientBanque.models.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ServiceClient {
    public List<Client> getAllClients();
    public Optional<Optional<Client>> getClientById(Long id);
    public Client createClient(Client client);
    public Client updateClient(Client client,Long id);
    public void deleteClientById(Long id);
}
