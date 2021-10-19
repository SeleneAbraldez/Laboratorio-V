package com.seleneab.ppabraldezpractica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final List<Producto> productos = new ArrayList<Producto>();
    private ProductoAdapter productoAdapter;

    public static List<Producto> getLista() {
        return productos;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productos.add(new Producto("Lapicera", 4, (float) 30.50));
//        productos.add(new Producto("Goma", 8, (float) 6.50));
//        productos.add(new Producto("Cuaderno", 2, (float) 100.0));

        productoAdapter = new ProductoAdapter(productos, this);
        RecyclerView rc = super.findViewById(R.id.recycler);
        rc.setAdapter(productoAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rc.setLayoutManager(linearLayoutManager);

        ActionBar actionBar = super.getSupportActionBar();
        actionBar.setTitle(R.string.title);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        productoAdapter.setProductos(productos);
        this.productoAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btnAgregar:
                Intent intent = new Intent(this, AgregarProductoActivity.class);
                startActivity(intent);
                break;

            case android.R.id.home:
                super.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void controlStock(int accion, int index) {
        List<Producto> productos = MainActivity.getLista();
        Producto producto;

        switch (accion) {
            case R.id.btmas:
                producto = productos.get(index);
                producto.setCantidad(producto.getCantidad() + 1);
                productos.set(index, producto);
                break;

            case R.id.btmenos:
                producto = productos.get(index);
                producto.setCantidad(producto.getCantidad() - 1);
                productos.set(index, producto);
                break;

            case R.id.btEditar:
                DialogEditarNombre dialog = new DialogEditarNombre(productoAdapter, getString(R.string.editName) + (index + 1), getString(R.string.enterNew), true, true, index);
                dialog.show(getSupportFragmentManager(), "editado");
                break;
        }

        productoAdapter.setProductos(productos);
        productoAdapter.notifyDataSetChanged();

    }


}