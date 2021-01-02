package info.lemuu.cadastrodeclientes.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import info.lemuu.cadastrodeclientes.R;

public class ListClientsActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Lista de clientes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_clients);
        setTitle(ListClientsActivity.TITLE_APPBAR);
    }

}