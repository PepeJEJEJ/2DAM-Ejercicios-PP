package com.davante.pmdp.ejercicio14_clientephp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    // ==== Dirección del servidor ====
    // Emulador: 10.0.2.2 es la dirección que el emulador usa para llegar al localhost del PC.
    // Móvil físico: la IP privada del PC (ipconfig), con el móvil en la misma wifi.
    // Para una app real: https://... y se quita usesCleartextTraffic del manifiesto
    private static final String BASE = "http://10.0.2.2:8080/";
    private static final String URL_LISTAR = BASE + "listar.php";
    private static final String URL_INSERTAR = BASE + "insertar.php";
    private static final String URL_BUSCAR = BASE + "buscar.php";

    private EditText etNombre, etPuntuacion, etBuscar;
    private Button btnEnviar, btnActualizar, btnBuscar;
    private ListView lvRanking;

    // Cola de peticiones de Volley: se crea una y se reutiliza para todas
    private RequestQueue queue;

    private final List<String> filas = new ArrayList<>();
    private ArrayAdapter<String> adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        etPuntuacion = findViewById(R.id.etPuntuacion);
        etBuscar = findViewById(R.id.etBuscar);
        btnEnviar = findViewById(R.id.btnEnviar);
        btnActualizar = findViewById(R.id.btnActualizar);
        btnBuscar = findViewById(R.id.btnBuscar);
        lvRanking = findViewById(R.id.lvRanking);

        queue = Volley.newRequestQueue(this);

        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, filas);
        lvRanking.setAdapter(adaptador);

        btnEnviar.setOnClickListener(v -> insertar());
        btnActualizar.setOnClickListener(v -> listar());
        btnBuscar.setOnClickListener(v -> buscarPorNombre());

        // Al abrir la pantalla se pide el ranking
        listar();
    }


    // ==== Paso 2: GET listar.php -> JSONArray -> ListView ====
    private void listar() {
        JsonArrayRequest req = new JsonArrayRequest(
                Request.Method.GET,
                URL_LISTAR,
                null,   // un GET no lleva cuerpo
                response -> {
                    // OJO: este código se ejecuta cuando llega la respuesta, no al hacer la petición.
                    // La petición es asíncrona: listar() termina antes de que llegue nada
                    filas.clear();
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject u = response.optJSONObject(i);
                        if (u == null) continue;   // por si llega algo que no es un objeto
                        String nombre = u.optString("nombre");
                        int puntos = u.optInt("puntuacion");
                        filas.add((i + 1) + ". " + nombre + " — " + puntos + " puntos");
                    }
                    adaptador.notifyDataSetChanged();
                },
                error -> {
                    Log.e("VOLLEY", "Error al listar: " + error);
                    toast("No se puede conectar con el servidor");
                }
        );

        queue.add(req);
    }


    // ==== Paso 3: POST insertar.php con los datos del formulario ====
    private void insertar() {
        String nombre = etNombre.getText().toString().trim();
        String puntuacion = etPuntuacion.getText().toString().trim();

        if (nombre.isEmpty() || puntuacion.isEmpty()) {
            toast("Rellena el nombre y la puntuación");
            return;
        }

        StringRequest req = new StringRequest(
                Request.Method.POST,
                URL_INSERTAR,
                response -> {
                    // Volley solo llega aquí si el servidor responde con un código 2xx. El PHP
                    // responde 200 con {"resultado":"OK","id":3} si ha guardado, y 400 o 500
                    // si no (datos que faltan, base de datos caída): eso va al de error
                    toast("Puntuación enviada");
                    etNombre.setText("");
                    etPuntuacion.setText("");
                    listar();   // se vuelve a pedir el ranking para que aparezca la nueva
                },
                error -> {
                    // Se ve en Logcat filtrando por VOLLEY. error.networkResponse es null si no
                    // hubo respuesta (servidor apagado, dirección mal); si no, trae el código
                    Log.e("VOLLEY", "Error al insertar: " + error);
                    toast("Error al enviar la puntuación");
                }
        ) {
            // Los parámetros del POST: es lo que en PHP se lee con $_POST['nombre']
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> p = new HashMap<>();
                p.put("nombre", nombre);
                p.put("puntuacion", puntuacion);
                return p;
            }
        };

        queue.add(req);
    }


    // ==== Ampliación: GET buscar.php?nombre=... -> un solo JSONObject ====
    private void buscarPorNombre() {
        String buscado = etBuscar.getText().toString().trim();
        if (buscado.isEmpty()) {
            toast("Escribe un nombre para buscar");
            return;
        }

        String url;
        try {
            // URLEncoder: un nombre con espacios o tildes ("José Luis") no puede ir tal cual en la URL
            url = URL_BUSCAR + "?nombre=" + URLEncoder.encode(buscado, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return;
        }

        // JsonObjectRequest porque esperamos UN objeto, no un array
        JsonObjectRequest req = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                response -> toast(buscado + " tiene " + response.optInt("puntuacion") + " puntos"),
                error -> {
                    // buscar.php responde 404 si no existe; sin respuesta = no hay conexión
                    if (error.networkResponse != null && error.networkResponse.statusCode == 404) {
                        toast(buscado + " no está en el ranking");
                    } else {
                        Log.e("VOLLEY", "Error al buscar: " + error);
                        toast("No se puede conectar con el servidor");
                    }
                }
        );

        queue.add(req);
    }


    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
