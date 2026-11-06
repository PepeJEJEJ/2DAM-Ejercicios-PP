package com.davante.pmdp.ejercicio8_sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText apellido;
    private Button botonGuardar;
    private Button botonComprobar;
    private Button botonCancelar;
    private TextView resultado;
    private ListView lista;

    private DatabaseHelper dbHelper; //Instancia de la bbdd

    // La lista que pinta el ListView. El adaptador guarda una referencia a ESTA lista:
    // si se cambia su contenido, hay que avisarle con notifyDataSetChanged()
    private final List<Profesor> profesores = new ArrayList<>();
    private ArrayAdapter<Profesor> adaptador;

    // -1 = estamos dando de alta; otro valor = id del profesor que se está editando
    private int idSeleccionado = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.editTextNombre);
        apellido = findViewById(R.id.editTextApellido);
        botonGuardar = findViewById(R.id.buttonGuardar);
        botonComprobar = findViewById(R.id.buttonComprobar);
        botonCancelar = findViewById(R.id.buttonCancelar);
        resultado = findViewById(R.id.textViewResultado);
        lista = findViewById(R.id.listViewProfesores);

        // Inicializar el helper de base de datos
        dbHelper = new DatabaseHelper(this);

        // Adaptador: une la lista de objetos con el ListView.
        // simple_list_item_1 es un layout de fila que ya trae Android (un solo TextView),
        // y el texto de cada fila sale del toString() de Profesor
        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, profesores);
        lista.setAdapter(adaptador);
        cargarLista();


        // ==== Paso 1: comprobar si existe ====
        botonComprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Paso 1: leer los dos campos, llamar a dbHelper.existeProfesor(...)
                //  y escribir el resultado en el TextView "resultado"
            }
        });


        // ==== Pasos 3 y 5: alta o modificación, según haya uno seleccionado ====
        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tNombre = nombre.getText().toString().trim();
                String tApellido = apellido.getText().toString().trim();

                // TODO Paso 3: si algún campo está vacío, avisar con un Toast y no seguir (return)

                // TODO Paso 3: si idSeleccionado == -1, insertar con dbHelper.insertar(...)
                // TODO Paso 5: si no, actualizar con dbHelper.actualizar(idSeleccionado, ...)

                // TODO Paso 3: después, limpiar el formulario y recargar la lista
            }
        });

        botonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiarFormulario();
            }
        });


        // ==== Paso 5: pulsar una fila la carga en el formulario para editarla ====
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Profesor p = profesores.get(position);

                // TODO Paso 5: guardar p.getId() en idSeleccionado, pasar su nombre y apellido
                //  a los EditText, cambiar el texto de botonGuardar a "Guardar cambios"
                //  y hacer visible botonCancelar (setVisibility(View.VISIBLE))
            }
        });


        // ==== Paso 4: mantener pulsada una fila pide confirmación y la borra ====
        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final Profesor p = profesores.get(position);

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Borrar profesor")
                        .setMessage("¿Seguro que quieres borrar a " + p + "?")
                        .setPositiveButton("Borrar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Paso 4: borrar p de la base de datos y recargar la lista.
                                //  Si justo se estaba editando ese profesor, limpiar el formulario
                            }
                        })
                        .setNegativeButton("Cancelar", null) // null = solo cierra el diálogo
                        .show();

                // true = "evento consumido": así no se lanza también el clic normal
                return true;
            }
        });
    }


    // ==== Paso 2: volcar la tabla en la lista ====
    private void cargarLista() {
        // TODO Paso 2: vaciar "profesores", añadirle todo lo que devuelve dbHelper.obtenerTodos()
        //  y avisar al adaptador con notifyDataSetChanged()
    }

    private void limpiarFormulario() {
        idSeleccionado = -1;
        nombre.setText("");
        apellido.setText("");
        botonGuardar.setText("Añadir");
        botonCancelar.setVisibility(View.GONE);
    }

}
