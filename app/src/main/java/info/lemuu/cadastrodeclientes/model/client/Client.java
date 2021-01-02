package info.lemuu.cadastrodeclientes.model.client;

import java.util.Objects;

import info.lemuu.cadastrodeclientes.model.person.CPF;
import info.lemuu.cadastrodeclientes.model.person.People;

public class Client extends People implements IClient {

    private String phone, email;

    public Client(String name, CPF cpf, String phone, String email) {
        super(name, cpf);
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return Objects.equals(phone, client.phone) &&
                Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), phone, email);
    }

}
