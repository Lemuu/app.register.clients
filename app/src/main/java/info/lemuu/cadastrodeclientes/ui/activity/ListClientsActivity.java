package info.lemuu.cadastrodeclientes.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import info.lemuu.cadastrodeclientes.R;
import info.lemuu.cadastrodeclientes.dao.ClientDAO;
import info.lemuu.cadastrodeclientes.model.client.Client;

public class ListClientsActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Lista de clientes";
    private final ClientDAO dao = new ClientDAO();

    private ArrayAdapter<Client> adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_clients);
        setTitle(ListClientsActivity.TITLE_APPBAR);

        this.initFields();

        this.configureList();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.updateListAdapter();
    }

    private void updateListAdapter() {
        this.adapter.clear();
        this.adapter.addAll(dao.all());
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.activity_list_form, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        int id = item.getItemId();

        if (id == R.id.activity_form_menu_remove) {
            Client client = this.adapter.getItem(menuInfo.position);
            this.remove(client);
        }

        return super.onContextItemSelected(item);
    }

    private void onClickItemListView() {
        this.listView.setOnItemClickListener((adapter,view,index,id) ->
                openFormClientModeEdit((Client) adapter.getItemAtPosition(index)));
    }

    private void openFormClientModeEdit(Client client) {
        Intent intentFormClient = new Intent(this, FormClientActivity.class);
        intentFormClient.putExtra(ConstActivities.KEY_CLIENT_EXTRA, client.getId());
        startActivity(intentFormClient);
    }

    private void remove(Client client) {
        this.dao.delete(client);
        this.adapter.remove(client);
    }

    private void configureList() {
        this.showClients();
        this.onClickItemListView();
        registerForContextMenu(this.listView);
    }

    private void showClients() {
        this.listView.setAdapter(this.adapter);
    }

    private void initFields() {
        this.listView = findViewById(R.id.activity_list_clients_list_view);
        this.adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
    }

}