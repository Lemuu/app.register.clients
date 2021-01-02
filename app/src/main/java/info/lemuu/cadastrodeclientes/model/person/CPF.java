package info.lemuu.cadastrodeclientes.model.person;

import androidx.annotation.NonNull;

import java.util.Objects;

public class CPF {

    private final String cpf;

    public CPF(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    @NonNull
    @Override
    public String toString() {
        return this.cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CPF cpf1 = (CPF) o;
        return Objects.equals(cpf, cpf1.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
