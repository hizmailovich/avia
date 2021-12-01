package com.example.avia;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientList {
    private final List<Client> clientList = new ArrayList<>();
    public void addClient(Client client)
    {
        clientList.add(client);
    }
    public List<Client> getClientList(){
        return clientList;
    }
}
