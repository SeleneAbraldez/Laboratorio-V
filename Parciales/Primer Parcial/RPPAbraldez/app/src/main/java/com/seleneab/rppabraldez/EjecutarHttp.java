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


    private List<ProductoModel> generarListaDatos(String json) throws JSONException {
        JSONArray jsonArray = new JSONArray(json);
        List<ProductoModel> lista = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            if (object.getString("name") != "null" && object.getString("population") != "null" && object.getString("area") != "null") {
                ProductoModel producto = new ProductoModel();
                producto.setNombre(object.getString("name"));
                producto.setCantidad(Integer.valueOf(object.getString("population")));
                producto.setPrecio(Float.valueOf(object.getString("area")));
                lista.add(producto);
            }
        }
        return lista;
    }

}
