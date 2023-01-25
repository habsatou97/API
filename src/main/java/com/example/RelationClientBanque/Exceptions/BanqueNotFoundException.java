package com.example.RelationClientBanque.Exceptions;

import com.example.RelationClientBanque.models.Banque;

public class BanqueNotFoundException extends Exception {
    public BanqueNotFoundException(Long id)
    {
        super("Could not find Banque:  "+ id);
    }
}
