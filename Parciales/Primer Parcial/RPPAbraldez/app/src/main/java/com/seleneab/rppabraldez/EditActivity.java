package com.seleneab.rppabraldez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {
    EditView editView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edit);

        ActionBar actionBar = super.getSupportActionBar();
        actionBar.setTitle(R.string.modificarTitle);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Bundle bundle = super.getIntent().getExtras();

        ProductoModel producto = MainActivity.getLista().get(bundle.getInt("index"));
        editView = new EditView(this, producto, bundle.getInt("index"));
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