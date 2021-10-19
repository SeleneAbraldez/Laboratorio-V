package com.seleneab.ppabraldezpractica;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogEditarNombre extends DialogFragment {

    private String mensaje;
    private String titulo;
    private Boolean negative;
    private Boolean positive;
    private int index;
    ProductoAdapter adapter;

    public DialogEditarNombre(ProductoAdapter adapter, String titulo, String mensaje, Boolean positive, Boolean negative, int index) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.positive = positive;
        this.negative = negative;
        this.index = index;
        this.adapter = adapter;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(this.titulo);
        builder.setMessage(this.mensaje);

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_editar_nombre, null);
        ClickDialogEditarNombreListener listener = new ClickDialogEditarNombreListener(this.index, view, this.adapter);

        builder.setView(view);

        if (this.positive) {
            builder.setPositiveButton(R.string.save, listener);
        }
        if (this.negative) {
            builder.setNegativeButton(R.string.cancel, listener);
        }

        return builder.create();
    }
}
