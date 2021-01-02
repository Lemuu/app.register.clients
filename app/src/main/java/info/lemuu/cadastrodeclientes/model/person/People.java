package info.lemuu.cadastrodeclientes.model.person;

import java.util.Objects;

public abstract class People implements IPeople {

    private final String name;
    private final CPF cpf;

    public People(String name, CPF cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public CPF getCPF() {
        return this.cpf;
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
