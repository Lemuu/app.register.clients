package info.lemuu.cadastrodeclientes.model.client;

import info.lemuu.cadastrodeclientes.model.person.IPeople;

public interface IClient extends IPeople {

    int getId();

    String getPhone();

    String getEmail();

}
