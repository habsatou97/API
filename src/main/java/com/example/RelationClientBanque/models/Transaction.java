package com.example.RelationClientBanque.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime date;
    private double montant;
    @ManyToOne
    @JoinColumn(name = "destinataire_id_client")
    private Client Destinataire;

    public Client getDestinataire() {
        return Destinataire;
    }

    public void setDestinataire(Client Destinataire) {
        this.Destinataire = Destinataire;
    }

    public Transaction(int id) {
        this.id = id;
    }

    public Transaction(int id, LocalDateTime date, double montant, Client destinataire) {
        this.id = id;
        this.date = date;
        this.montant = montant;
        Destinataire = destinataire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
