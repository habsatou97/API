package com.example.RelationClientBanque.repository;

import com.example.RelationClientBanque.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
