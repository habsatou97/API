package com.example.RelationClientBanque.repository;

import com.example.RelationClientBanque.models.CompteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CompteBancaireRepository extends JpaRepository<CompteBancaire,Long> {
}
