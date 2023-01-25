package com.example.RelationClientBanque.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "comptes_bancaires")
public class CompteBancaire {
    @Id
    @GeneratedValue
    private Long id_compte;
    private LocalDateTime date;
    private Double solde;
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_banque")
    private Banque banque;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public CompteBancaire() {
    }

    public CompteBancaire(Long id_compte) {
        this.id_compte = id_compte;
    }

    public CompteBancaire(Long id_compte, LocalDateTime date, Double solde) {
        this.id_compte = id_compte;
        this.date = date;
        this.solde = solde;
    }

    public Long getId_compte() {
        return id_compte;
    }

    public void setId_compte(Long id_compte) {
        this.id_compte = id_compte;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompteBancaire that = (CompteBancaire) o;
        return Objects.equals(id_compte, that.id_compte) && Objects.equals(date, that.date) && Objects.equals(solde, that.solde);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_compte, date, solde);
    }

    @Override
    public String toString() {
        return "CompteBancaire{" +
                "id_compte=" + id_compte +
                ", date=" + date +
                ", solde=" + solde +
                '}';
    }

}
