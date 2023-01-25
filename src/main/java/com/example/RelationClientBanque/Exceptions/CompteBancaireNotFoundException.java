package com.example.RelationClientBanque.Exceptions;

import com.example.RelationClientBanque.models.CompteBancaire;

public class CompteBancaireNotFoundException extends Exception{
    public CompteBancaireNotFoundException(Long id)
    {
        super("Could not find CompteBancaire:  "+ id);
    }
}
