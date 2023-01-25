package com.example.RelationClientBanque.models;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_client;
    private String firtsname;
    private String lastname;
    private Integer age;

    @OneToMany(mappedBy = "client")
    private List<CompteBancaire> comptes=new ArrayList<>();
    @ManyToMany(mappedBy = "clients")
       private List<Banque> banques=new ArrayList<>();
    public Client() {
    }

    public Client(Long id_client) {
        this.id_client = id_client;
    }

    public Client(Long id_client, String firtsname, String lastname, Integer age) {
        this.id_client = id_client;
        this.firtsname = firtsname;
        this.lastname = lastname;
        this.age = age;
    }


    public Long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
    }

    public String getFirtsname() {
        return firtsname;
    }

    public void setFirtsname(String firtsname) {
        this.firtsname = firtsname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<CompteBancaire> getComptes() {
        return comptes;
    }


    public List<Banque> getBanques() {
        return banques;
    }

    public void setComptes(List<CompteBancaire> comptes) {
        this.comptes = comptes;
    }

    public void setBanques(List<Banque> banques) {
        this.banques = banques;
    }

    @Transactional
    public void addBanque(Banque banque)
    {
        banques.add(banque);
    }
    @Transactional
    public void addCompte(CompteBancaire compteBancaire)
    {
        comptes.add(compteBancaire);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id_client, client.id_client) && Objects.equals(firtsname, client.firtsname) && Objects.equals(lastname, client.lastname) && Objects.equals(age, client.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_client, firtsname, lastname, age);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id_client=" + id_client +
                ", firtsname='" + firtsname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }
}
