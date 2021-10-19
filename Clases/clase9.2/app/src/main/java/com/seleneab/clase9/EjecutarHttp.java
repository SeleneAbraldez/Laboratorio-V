package com.seleneab.clase9;

import android.os.Handler;
import android.os.Message;
import android.util.Xml;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class EjecutarHttp extends Thread {

    private String url;
    Handler handler;
    boolean isImg;

    public EjecutarHttp(String url, Handler handler, boolean isImg) {
        this.url = url;
        this.handler = handler;
        this.isImg = isImg;
    }

    @Override
    public void run() {
        ConexionHttp conexionHttp = new ConexionHttp();

        if (isImg) {
            byte[] imagen = conexionHttp.obtenerRespuestaImg(url);
            Message message = new Message();
            message.arg1 = 3;
            message.obj = imagen;
            this.handler.sendMessage(message);

        } else {

            String s = conexionHttp.obtenerRespuesta(url);

            Message mensaje = new Message();
            mensaje.arg1 = 2;
            mensaje.obj = parserNoticiaByXML((s));
            this.handler.sendMessage(mensaje);
        }

    }

    private List<Noticia> parserNoticiaByXML(String xml) {
        List<Noticia> noticias = new ArrayList<>();
        XmlPullParser parser = Xml.newPullParser();

        try {
            parser.setInput((new StringReader((xml))));
            int evento = parser.getEventType();
            //tenemos el string descargadom, lo conectamos con el parser
            // /el primer evento que vamos a encontrar es el comienxo
            Noticia n = null;
            while (evento != XmlPullParser.END_DOCUMENT) {

                if (evento == XmlPullParser.START_TAG) {
                    String tag = parser.getName();
                    if ("title".equals(tag) && n != null) {
                        n.titulo = parser.nextText();
                    } else if ("item".equals(tag)) {
                        n = new Noticia();
                    } else if ("enclosure".equals(tag)) {
                        n.urlImg = parser.getAttributeValue(null, "url");
                    }

                } else if (evento == XmlPullParser.END_TAG) {
                    String tag = parser.getName();
                    if ("item".equals(tag)) {
                        noticias.add(n);
                    }
                }
                evento = parser.next();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        return noticias;
    }

    private List<String> generarListaStrng(String json) throws JSONException {
        List<String> paises = new ArrayList<>();

        JSONArray jsonArray = new JSONArray(json);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            paises.add(object.getString("name"));
        }

        return paises;
    }

}
