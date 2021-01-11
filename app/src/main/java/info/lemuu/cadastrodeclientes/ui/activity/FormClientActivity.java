package info.lemuu.cadastrodeclientes.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import info.lemuu.cadastrodeclientes.R;
import info.lemuu.cadastrodeclientes.dao.ClientDAO;
import info.lemuu.cadastrodeclientes.model.client.Client;
import info.lemuu.cadastrodeclientes.model.person.CPF;

public class FormClientActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR_MODE_INSERT = "Cadastrar um cliente";
    public static final String TITLE_APPBAR_MODE_UPDATE = "Atualizar um cliente";

    private final ClientDAO dao = new ClientDAO();
    private EditText name, cpf, phone, email;
    private Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_client);

        this.initFields();

        this.loadClient();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_form_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.activity_form_student_menu_save && !this.validFieldsEmpty()) {
            this.finishForm();
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadClient() {
        Intent intent = getIntent();
        if (!intent.hasExtra(ConstActivities.KEY_CLIENT_EXTRA)) {
            this.client = new Client();
            setTitle(TITLE_APPBAR_MODE_INSERT);
            return;
        }

        setTitle(TITLE_APPBAR_MODE_UPDATE);
        this.client = this.dao.findClientById(intent.getIntExtra(ConstActivities.KEY_CLIENT_EXTRA, 0));
        fillFieldsActivity();
    }

    private void fillFieldsActivity() {
        name.setText(this.client.getName());

        CPF cpf = client.getCPF();
        if (cpf != null) {
            this.cpf.setText(cpf.toString());
        }

        phone.setText(this.client.getPhone());
        email.setText(this.client.getEmail());
    }

    private boolean validExistClient(Client client) {
        for (Client object : dao.all()) {
            if (!object.getCPF().getCpf()
                    .equalsIgnoreCase(client.getCPF().getCpf())) continue;
            return true;
        }
        return false;
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

    private void finishForm() {
        Client client = fillClient();

        if (this.validExistClient(client)) {
            Toast.makeText(this, "Cliente atualizado com sucesso.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Cliente cadastrado com sucesso.", Toast.LENGTH_LONG).show();
        }

        this.save(client);
    }

    private void save(Client client) {
        dao.save(client);
        finish();
    }

    private Client fillClient() {
        this.client.setName(this.name.getText().toString());
        this.client.setCPF(new CPF(this.cpf.getText().toString()));
        this.client.setPhone(this.phone.getText().toString());
        this.client.setEmail(this.email.getText().toString());

        return this.client;
    }

    private void initFields() {
        this.name = findViewById(R.id.activity_create_client_name);
        this.cpf = findViewById(R.id.activity_create_client_cpf);
        this.phone = findViewById(R.id.activity_create_client_phone);
        this.email = findViewById(R.id.activity_create_client_email);
    }

    private List<EditText> getFields() {
        return new ArrayList<>(Arrays.asList(this.name, this.cpf, this.phone, this.email));
    }

}