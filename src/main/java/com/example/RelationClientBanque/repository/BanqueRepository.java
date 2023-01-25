package com.example.RelationClientBanque.repository;

import com.example.RelationClientBanque.models.Banque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BanqueRepository extends JpaRepository<Banque,Long> {
}
