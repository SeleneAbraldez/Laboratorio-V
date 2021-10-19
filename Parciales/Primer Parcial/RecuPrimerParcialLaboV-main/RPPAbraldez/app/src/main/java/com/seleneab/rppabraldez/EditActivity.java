package com.seleneab.rppabraldez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

public class EditActivity extends AppCompatActivity {
    EditView editView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_editar);

        ActionBar actionBar = super.getSupportActionBar();
        actionBar.setTitle(R.string.modificarTitle);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Bundle bundle = super.getIntent().getExtras();

        AutoModel auto = MainActivity.getLista().get(bundle.getInt("index"));
        editView = new EditView(this, auto, bundle.getInt("index"));
        editView.cargarModelo();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}