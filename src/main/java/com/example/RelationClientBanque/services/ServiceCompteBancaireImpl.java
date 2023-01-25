package com.example.RelationClientBanque.services;

import com.example.RelationClientBanque.models.CompteBancaire;
import com.example.RelationClientBanque.repository.CompteBancaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ServiceCompteBancaireImpl implements ServiceCompteBancaire {
    @Autowired
    private CompteBancaireRepository compteBancaireRepository;
    @Override
    public List<CompteBancaire> getAllComptes() {
        return compteBancaireRepository.findAll();
    }

    @Override
    public Optional<Optional<CompteBancaire>> getCompteBancaireById(Long id) {
        return Optional.of(compteBancaireRepository.findById(id));
    }

    @Override
    public CompteBancaire createCompteBancaire(CompteBancaire compteBancaire) {
        CompteBancaire compte1=new CompteBancaire();
        compte1.setSolde(compteBancaire.getSolde());
        compte1.setDate(compteBancaire.getDate());
        compte1.setClient(compteBancaire.getClient());
        return compteBancaireRepository.save(compte1);
    }

    @Override
    public CompteBancaire updateCompteBancaire(CompteBancaire compteBancaire, Long id) {
        Optional<CompteBancaire> existingCompte=compteBancaireRepository.findById(id);
        if(existingCompte.isPresent())
        {
            existingCompte.get().setSolde(compteBancaire.getSolde());
            existingCompte.get().setDate(compteBancaire.getDate());
            existingCompte.get().setBanque(compteBancaire.getBanque());
            existingCompte.get().setClient(compteBancaire.getClient());
            return compteBancaireRepository.save(existingCompte.get());
        }
        return null;
    }

    @Override
    public void deleteCompteBancaireById(Long id) {
        Optional<CompteBancaire> existingCompte=compteBancaireRepository.findById(id);
        if(existingCompte.isPresent())
        {
            compteBancaireRepository.deleteById(id);
        }

    }
}
