package com.example.practicaprimerparcial;

import android.util.Log;
import android.view.View;

import java.util.List;

public class ClickBtnItem implements View.OnClickListener {
    private MainActivity activity;
    private int idBtn;
    private int indice;

    public ClickBtnItem(MainActivity activity, int idBtn, int indice) {
        this.activity = activity;
        this.idBtn=idBtn;
        this.indice=indice;
    }
    @Override
    public void onClick(View v) {
        activity.controlDeStock(this.indice,idBtn);

    }
}
