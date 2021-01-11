package info.lemuu.cadastrodeclientes.model.person;

import java.util.Objects;

public abstract class People implements IPeople {

    private String name;
    private CPF cpf;

    public People() {}

    public People(String name, CPF cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public CPF getCPF() {
        return this.cpf;
    }
    public void setCPF(CPF cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return Objects.equals(name, people.name) &&
                Objects.equals(cpf, people.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cpf);
    }
}
