package info.lemuu.cadastrodeclientes.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import info.lemuu.cadastrodeclientes.R;
import info.lemuu.cadastrodeclientes.dao.ClientDAO;
import info.lemuu.cadastrodeclientes.model.client.Client;
import info.lemuu.cadastrodeclientes.model.person.CPF;

public class CreateClientActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Cadastrar um cliente";

    private final ClientDAO dao = new ClientDAO();
    private EditText name, cpf, phone, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_client);
        setTitle(CreateClientActivity.TITLE_APPBAR);

        this.initFields();
        this.onClickButtonSave();
    }

    private void initFields() {
        this.name = findViewById(R.id.activity_create_client_name);
        this.cpf = findViewById(R.id.activity_create_client_cpf);
        this.phone = findViewById(R.id.activity_create_client_phone);
        this.email = findViewById(R.id.activity_create_client_email);
    }

    private void onClickButtonSave() {
        Button button = findViewById(R.id.activity_create_client_button_save);
        button.setOnClickListener(view -> {
            if (this.validFieldsEmpty()) return;

            Client client = createClient();
            if (this.validExistClient(client)) {
                Toast.makeText(this, "Este cliente já está cadastrado.", Toast.LENGTH_LONG).show();
                return;
            }

            dao.save(client);
            Toast.makeText(this, "Cliente cadastrado com sucesso.", Toast.LENGTH_LONG).show();
            finish();
        });
    }

    private boolean validExistClient(Client client) {
        return dao.all().contains(client);
    }

    private boolean validFieldsEmpty() {
        for (EditText field : this.getFields()) {
            String text = field.getText().toString();

            if (text == null || text.isEmpty() ||
                    text.equalsIgnoreCase("null") ||
                    text.equalsIgnoreCase("")) {
                field.setError("Este campo é obrigatório.");
                return true;
            }
        }

        return false;
    }

    private Client createClient() {
        return new Client(
                this.name.getText().toString(),
                new CPF(this.cpf.getText().toString()),
                this.phone.getText().toString(),
                this.email.getText().toString());
    }

    private List<EditText> getFields() {
        return new ArrayList<>(Arrays.asList(this.name, this.cpf, this.phone, this.email));
    }

}