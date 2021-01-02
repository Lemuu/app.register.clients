package info.lemuu.cadastrodeclientes.model.person;

import androidx.annotation.NonNull;

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

}
