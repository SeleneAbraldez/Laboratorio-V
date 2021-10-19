package com.seleneab.clase1;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MyListener implements View.OnClickListener{

    MainActivity activity;
    TextView tv;
    public MyListener(MainActivity activity, TextView tv){
        this.activity = activity;
        this.tv=tv;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn){
            EditText ed = activity.findViewById(R.id.ed);
            tv.setText(("Hola " + ed.getText()));
//        Log.d("Click","Hola " + ed.getText());
        }else{
            tv.setText("Chauu");
        }

    }
}
