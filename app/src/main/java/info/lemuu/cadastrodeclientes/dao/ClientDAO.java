package info.lemuu.cadastrodeclientes.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import info.lemuu.cadastrodeclientes.model.client.Client;

public class ClientDAO {

    private static int IDs = 1;
    private static final List<Client> clients = new ArrayList<>();

    public void save(Client client) {
        if (client.hasId()) {
            this.update(client);
            return;
        }
        this.insert(client);
    }

    private void insert(Client client) {
        client.setId(IDs);
        clients.add(client);
        incrementId();
    }

    private void update(Client client) {
        Client clientId = this.findClient(client);
        int i = clients.indexOf(clientId);
        clients.set(i, client);
    }

    public void delete(Client client) {
        Client clientById = this.findClient(client);
        if (clientById == null) return;
        clients.remove(clientById);
    }

    public Client findClient(Client client) {
        for (Client o : clients) {
            if (o == null) continue;
            if (o.getId() != client.getId()) continue;

            return o;
        }
        return null;
    }

    public Client findClientById(int id) {
        for (Client o : clients) {
            if (o == null) continue;
            if (o.getId() != id) continue;

            return o;
        }
        return null;
    }

    public List<Client> all() {
        return Collections.unmodifiableList(clients);
    }

    private void incrementId() {
        IDs++;
    }

}
