package com.seleneab.clase7;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class EjecutarHttp extends Thread {

    private String url;
    Handler handler;

    public EjecutarHttp(String url, Handler handler){
          this.url = url;
          this.handler = handler;
    }

    @Override
    public void run() {
        //si sale de run el hilo muere, si se hace un while sobrevive pero noi es nada recomendable
        ConexionHttp conexionHttp = new ConexionHttp();
        String s = conexionHttp.obtenerRespuesta(url);

        Message mensaje = new Message();
        try {
            mensaje.obj = generarListaStrng(s);
        }catch (JSONException e){
            e.printStackTrace();
        }
        mensaje.arg1 = 2;
        this.handler.sendMessage(mensaje);

    }

    private List<String> generarListaStrng(String json) throws JSONException {
        List<String> paises = new ArrayList<>();

        JSONArray jsonArray = new JSONArray(json);
        for (int i=0; i<jsonArray.length();i++){
            JSONObject object = jsonArray.getJSONObject(i);
            paises.add(object.getString("name"));
        }

        return paises;
    }

}
