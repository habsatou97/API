package com.example.RelationClientBanque.services;

import com.example.RelationClientBanque.models.Client;
import com.example.RelationClientBanque.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ServiceClientImpl implements ServiceClient {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Optional<Client>> getClientById(Long id) {
        return Optional.of(clientRepository.findById(id));
    }

    @Override
    public Client createClient(Client client) {
        Client client1 = new Client(client.getId_client());
        client1.setAge(client.getAge());
        client1.setFirtsname(client.getFirtsname());
        client1.setLastname(client.getLastname());
        client1.setComptes(client.getComptes());
        client1.setBanques(client.getBanques());
        return clientRepository.save(client1);
    }

    @Override
    public Client updateClient(Client client, Long id) {
        Optional<Client> existingClient = clientRepository.findById(id);
        if (existingClient.isPresent()) {
            Client monclient = new Client(existingClient.get().getId_client());
            monclient.setAge(client.getAge());
            monclient.setFirtsname(client.getFirtsname());
            monclient.setLastname(client.getFirtsname());
            monclient.setBanques(client.getBanques());
            monclient.setComptes(client.getComptes());
            clientRepository.save(monclient);
            return monclient;
        }
        return null;
    }

    @Override
    public void deleteClientById(Long id) {
        Optional<Client> existingClient = clientRepository.findById(id);
        if (existingClient.isPresent())
            clientRepository.delete(existingClient.get());
        else
            System.out.println("Client not present id: " + id);

    }
}
