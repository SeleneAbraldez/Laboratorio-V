package com.seleneab.rppabraldez;

import android.view.View;

public class EditController implements View.OnClickListener {
    private EditView editView;
    private EditActivity editActivity;
    private AutoModel autoModel;
    private int index;

    public EditController(EditActivity activity, AutoModel modelo, int index, EditView view) {
        this.editActivity = activity;
        this.autoModel = modelo;
        this.index = index;
        this.editView = view;
    }

    @Override
    public void onClick(View v) {
        editView.refrescarModelo();
        editActivity.finish();
    }

}
