package com.seleneab.rppabraldez;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class EjecutarHttp extends Thread {

    private String url;
    Handler handler;

    public EjecutarHttp(String url, Handler handler) {
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
            mensaje.obj = generarListaDatos(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.handler.sendMessage(mensaje);

    }


    private List<AutoModel> generarListaDatos(String json) throws JSONException {
        JSONArray jsonArray = new JSONArray(json);
        List<AutoModel> lista = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            if (object.getString("model") != "null" && object.getString("make") != "null" && object.getString("year") != "null") {
                AutoModel auto = new AutoModel();
                auto.setModelo(object.getString("model"));
                auto.setMarca(object.getString("make"));
                auto.setAnio(Integer.valueOf(object.getString("year")));
                lista.add(auto);
            }
        }

        return lista;
    }

}
