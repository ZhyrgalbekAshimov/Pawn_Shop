package services.impl;

import exceptions.ClientNotFound;
import models.Client;
import services.ClientService;
import java.util.ArrayList;

public class ClientServiceImpl implements ClientService {

    private ArrayList<Client> clients = new ArrayList<>();

    public Client createClient(String name, String idCard) {
        Client client = new Client(name, idCard);
        clients.add(client);
        return client;
    }


    public Client findClientByIdCard(String idCard) throws ClientNotFound {

        for (Client client: clients) {
            if (client.getIdCard().equals(idCard)){
                return client;
            }
        }

        throw new ClientNotFound("Клиент не найден. ID Card = " + idCard);
    }


    public boolean blockClient(String idCard) throws ClientNotFound {
        Client client = findClientByIdCard(idCard);
        client.setBlocked(true);
        return true;
    }


    public void showClients() {
        for (Client client: clients) {

            System.out.println("ID = " + client.getId() +". NAME = " + client.getName() + ". ID CARD = " + client.getIdCard() + ". BLOCKED = " + client.isBlocked());

        }
    }

}
