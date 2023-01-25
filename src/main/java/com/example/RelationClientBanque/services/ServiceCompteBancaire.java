package com.example.RelationClientBanque.services;

import com.example.RelationClientBanque.models.CompteBancaire;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ServiceCompteBancaire {
    public List<CompteBancaire> getAllComptes();
    public Optional<Optional<CompteBancaire>> getCompteBancaireById(Long id);
    public CompteBancaire createCompteBancaire(CompteBancaire compteBancaire);
    public CompteBancaire updateCompteBancaire(CompteBancaire compteBancaire,Long id);
    public void deleteCompteBancaireById(Long id);
}
