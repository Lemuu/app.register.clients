package info.lemuu.cadastrodeclientes.dao;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import info.lemuu.cadastrodeclientes.model.client.Client;

public class ClientDAO {

    private static final Set<Client> clients = new HashSet<>();

    public void save(Client client) {
        clients.add(client);
    }

    public void delete(Client client) {
        clients.remove(client);
    }

    public Set<Client> all() {
        return Collections.unmodifiableSet(clients);
    }

}
