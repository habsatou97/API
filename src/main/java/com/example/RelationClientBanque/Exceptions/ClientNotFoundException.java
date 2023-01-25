package com.example.RelationClientBanque.Exceptions;

import com.example.RelationClientBanque.models.Client;

public class ClientNotFoundException extends Exception{
    public ClientNotFoundException(Long id)
    {
        super("Could not find Client:  "+ id);
    }
}
