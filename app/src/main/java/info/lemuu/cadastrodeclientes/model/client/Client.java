package info.lemuu.cadastrodeclientes.model.client;

import androidx.annotation.NonNull;

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

    @NonNull
    @Override
    public String toString() {
        String name = super.getName().split(" ")[0];
        return name + ", CPF: " + super.getCPF().toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
