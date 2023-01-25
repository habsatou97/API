package com.example.RelationClientBanque.services;

import com.example.RelationClientBanque.Exceptions.BanqueNotFoundException;
import com.example.RelationClientBanque.models.Banque;
import com.example.RelationClientBanque.repository.BanqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ServiceBanqueImpl implements ServiceBanque{

@Autowired
private BanqueRepository banqueRepository;
    @Override
    public List<Banque> getAllBanques() {
        return banqueRepository.findAll();
    }

    @Override
    public Optional<Banque> getBanqueById(Long id)  {
        return banqueRepository.findById(id);

    }
    @Override
    public Banque createBanque(Banque banque) {
        Banque banque1= new Banque();
        banque1.setBank_name(banque.getBank_name());
        banque1.setAdresse(banque.getAdresse());
        banque1.setClients(banque.getClients());
        banque1.setComptes(banque.getComptes());
        return banqueRepository.save(banque1);
    }

    @Override
    public Banque updateBanque(Banque banque, Long id) {
        Optional<Banque> existingbanque=banqueRepository.findById(id);
        if(existingbanque.isPresent())
        {
          Banque bnk=new Banque(existingbanque.get().getId_banque());
          bnk.setBank_name(banque.getBank_name());
          bnk.setAdresse(banque.getAdresse());
          bnk.setComptes(banque.getComptes());
          bnk.setClients(banque.getClients());
          return banqueRepository.save(bnk);
        }
        System.out.println("Id introuvable: "+id);
        return null;
    }

    @Override
    public void deleteBanqueById(Long id) {
        Optional<Banque> existingbanque=banqueRepository.findById(id);
        if(existingbanque!=null)
        {
          banqueRepository.deleteById(id);
        }
    }

}
