package info.lemuu.cadastrodeclientes.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import info.lemuu.cadastrodeclientes.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.onClickButtons();
    }

    private void onClickButtons() {
        this.onClickButtonListClients();
        this.onClickButtonCreateClients();
    }

    private void onClickButtonListClients() {
        Button button = findViewById(R.id.button_list_clients);
        button.setOnClickListener(view -> {
            startActivity(new Intent(this, ListClientsActivity.class));
        });
    }

    private void onClickButtonCreateClients() {
        Button button = findViewById(R.id.button_create_client);
        button.setOnClickListener(view -> {
            startActivity(new Intent(this, CreateClientActivity.class));
        });
    }

}