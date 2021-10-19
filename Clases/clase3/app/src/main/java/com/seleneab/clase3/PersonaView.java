package com.seleneab.clase3;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

//setee para escribir y recibir datos
//cargar d elo que esta en pantalla, el modelo de datos y lo que esta en pantalla
//la view es el que carga y presenta del modelo a la pantalla
public class PersonaView {
    MainActivity activity;
    PersonaModel modelo;

    public PersonaView(MainActivity activity, PersonaModel modelo) {
        this.activity = activity;
        this.modelo = modelo;
    }

    public void cargarModelo() {
        EditText etNombre = activity.findViewById(R.id.nombre);
        EditText etApellido = activity.findViewById(R.id.apellido);
        EditText etDNI = activity.findViewById(R.id.dni);
        RadioGroup rgGenero = activity.findViewById(R.id.genero);

        String nombre = etNombre.getText().toString();
        String apellido = etApellido.getText().toString();
        String DNI = etDNI.getText().toString();
        int generoInt = rgGenero.getCheckedRadioButtonId();
        RadioButton genero = rgGenero.findViewById(generoInt);


        modelo.setNombre(nombre);
        modelo.setApellido(apellido);
        modelo.setDNI(DNI);
        modelo.setGenero((String) genero.getText());
    }

    public void cargarPantalla() {
        EditText etNombre = activity.findViewById(R.id.nombre);
        EditText etApellido = activity.findViewById(R.id.apellido);
        EditText etDNI = activity.findViewById(R.id.dni);
        EditText etGenero = activity.findViewById(R.id.genero);
        etNombre.setText(modelo.getNombre());
        etApellido.setText(modelo.getApellido());
        etDNI.setText(modelo.getDNI());
        etGenero.setText(modelo.getGenero());
    }
}
