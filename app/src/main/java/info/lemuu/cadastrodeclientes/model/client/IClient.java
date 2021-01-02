package info.lemuu.cadastrodeclientes.model.client;

import info.lemuu.cadastrodeclientes.model.person.IPeople;

public interface IClient extends IPeople {

    String getPhone();

    String getEmail();

}
