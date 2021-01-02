package info.lemuu.cadastrodeclientes.ui.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import info.lemuu.cadastrodeclientes.R;
import info.lemuu.cadastrodeclientes.dao.ClientDAO;
import info.lemuu.cadastrodeclientes.model.client.Client;

public class ListClientsActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Lista de clientes";
    private final ClientDAO dao = new ClientDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_clients);
        setTitle(ListClientsActivity.TITLE_APPBAR);

        this.showClients();
    }

    private void showClients() {
        List<Client> list = new ArrayList<>(dao.all());
        ListView listView = findViewById(R.id.activity_list_clients_list_view);

        listView.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                list)
        );
    }

}