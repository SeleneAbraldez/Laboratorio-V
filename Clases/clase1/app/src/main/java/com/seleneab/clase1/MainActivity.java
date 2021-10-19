package com.seleneab.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = super.findViewById(R.id.tv);
        Button btn = super.findViewById(R.id.btn);
        Button btnC = super.findViewById(R.id.btnC);

        MyListener listener = new MyListener(this, tv);
        btn.setOnClickListener(listener);
        btnC.setOnClickListener(listener);

        String s = tv.getText().toString();
        tv.setText(s + " \n Ingrese su nombre: \n");

    }
}