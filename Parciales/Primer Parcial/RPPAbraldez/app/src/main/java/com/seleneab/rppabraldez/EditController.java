package com.seleneab.rppabraldez;

import android.util.Log;
import android.view.View;

public class EditController implements View.OnClickListener {
    private EditView editView;
    private EditActivity editActivity;
    private ProductoModel productoModel;
    private int index;

    public EditController(EditActivity activity, ProductoModel modelo, int index, EditView view) {
        this.editActivity = activity;
        this.productoModel = modelo;
        this.index = index;
        this.editView = view;
    }

    @Override
    public void onClick(View v) {
        editView.refrescarModelo();
        editActivity.finish();
    }

}
