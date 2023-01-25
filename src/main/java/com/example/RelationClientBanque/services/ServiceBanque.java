package com.example.RelationClientBanque.services;

import com.example.RelationClientBanque.Exceptions.BanqueNotFoundException;
import com.example.RelationClientBanque.models.Banque;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ServiceBanque {
    public List<Banque> getAllBanques();
    public Optional<Banque> getBanqueById(Long id) ;
    public Banque createBanque(Banque banque);
    public Banque updateBanque(Banque banque,Long id);
    public void deleteBanqueById(Long id);

}
