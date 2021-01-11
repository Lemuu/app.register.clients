package info.lemuu.cadastrodeclientes.model.client;

import androidx.annotation.NonNull;

import info.lemuu.cadastrodeclientes.model.person.CPF;
import info.lemuu.cadastrodeclientes.model.person.People;

public class Client extends People implements IClient {

    private int id = 0;
    private String phone, email;

    public Client() {}

    public Client(String name, CPF cpf, String phone, String email) {
        super(name, cpf);
        this.phone = phone;
        this.email = email;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public boolean hasId() {
        return this.id > 0;
    }

    @Override
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @NonNull
    @Override
    public String toString() {
        String name = super.getName().split(" ")[0];
        return name + ", CPF: " + super.getCPF().toString();
    }

}
