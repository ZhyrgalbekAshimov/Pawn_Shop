package services;

import exceptions.ClientNotFound;
import models.Client;
import services.impl.ClientServiceImpl;

public interface ClientService {

    ClientService INSTANCE = new ClientServiceImpl();

    Client createClient(String name, String idCard);
    Client findClientByIdCard(String idCard) throws ClientNotFound;
    boolean blockClient(String idCard) throws ClientNotFound;
    void showClients();
}
