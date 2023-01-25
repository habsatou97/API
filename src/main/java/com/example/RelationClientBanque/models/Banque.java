package com.example.RelationClientBanque.models;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "banques")
public class Banque {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_banque;
    private String Bank_name;
    private String adresse;
    @ManyToMany
    private List<Client> clients=new ArrayList<>();

    @OneToMany(mappedBy = "banque")
    private List<CompteBancaire> comptes;

    public Banque() {
    }

    public Banque(Long id_banque) {
        this.id_banque = id_banque;
    }

    public Banque(Long id_banque, String bank_name, String adresse) {
        this.id_banque = id_banque;
        Bank_name = bank_name;
        this.adresse = adresse;
    }




    public Long getId_banque() {
        return id_banque;
    }

    public String getBank_name() {
        return Bank_name;
    }

    public String getAdresse() {
        return adresse;
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<CompteBancaire> getComptes() {
        return comptes;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void setComptes(List<CompteBancaire> comptes) {
        this.comptes = comptes;
    }

    public void setId_banque(Long id_banque) {
        this.id_banque = id_banque;
    }

    public void setBank_name(String bank_name) {
        Bank_name = bank_name;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void addClient(Client client)
    {
      clients.add(client);
    }

    public void addCompte(CompteBancaire compteBancaire)
   {
    comptes.add(compteBancaire);
   }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banque banque = (Banque) o;
        return Objects.equals(id_banque, banque.id_banque) && Objects.equals(Bank_name, banque.Bank_name) && Objects.equals(adresse, banque.adresse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_banque, Bank_name, adresse);
    }

    @Override
    public String toString() {
        return "Banque{" +
                "id_banque=" + id_banque +
                ", Bank_name='" + Bank_name + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
