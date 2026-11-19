package com.example.qizz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class JuegoActivity extends AppCompatActivity implements View.OnClickListener {

    private static final long TIEMPO_POR_PREGUNTA_MS = 10000; // 10 segundos por pregunta

    private String nombre;
    private List<Pregunta> preguntas;
    private int indiceActual = 0;
    private int puntuacion = 0;
    private CountDownTimer temporizador;

    private TextView txtContador;
    private TextView txtPuntos;
    private TextView txtTiempo;
    private TextView txtPregunta;
    private Button btnResp1;
    private Button btnResp2;
    private Button btnResp3;
    private Button btnResp4;

    private boolean respondiendo = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_juego);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rootJuego), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nombre = getIntent().getStringExtra("NOMBRE");
        if (nombre == null) nombre = "Jugador";
        preguntas = Preguntas.getTodas();

        txtContador = findViewById(R.id.txtContador);
        txtPuntos = findViewById(R.id.txtPuntos);
        txtTiempo = findViewById(R.id.txtTiempo);
        txtPregunta = findViewById(R.id.txtPregunta);
        btnResp1 = findViewById(R.id.btnResp1);
        btnResp2 = findViewById(R.id.btnResp2);
        btnResp3 = findViewById(R.id.btnResp3);
        btnResp4 = findViewById(R.id.btnResp4);
        btnResp1.setOnClickListener(this);
        btnResp2.setOnClickListener(this);
        btnResp3.setOnClickListener(this);
        btnResp4.setOnClickListener(this);

        mostrarPregunta();
    }

    private void mostrarPregunta() {
        respondiendo = false;
        Pregunta p = preguntas.get(indiceActual);
        txtContador.setText(getString(R.string.contador_pregunta, indiceActual + 1, preguntas.size()));
        txtPregunta.setText(p.getTexto());
        String[] opciones = p.getOpciones();
        btnResp1.setText(opciones[0]);
        btnResp2.setText(opciones[1]);
        btnResp3.setText(opciones[2]);
        btnResp4.setText(opciones[3]);
        btnResp1.setEnabled(true);
        btnResp2.setEnabled(true);
        btnResp3.setEnabled(true);
        btnResp4.setEnabled(true);
        actualizarPuntos();
        iniciarTemporizador();
    }

    private void iniciarTemporizador() {
        if (temporizador != null) temporizador.cancel();
        temporizador = new CountDownTimer(TIEMPO_POR_PREGUNTA_MS, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                txtTiempo.setText(getString(R.string.tiempo_restante, millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                txtTiempo.setText(getString(R.string.tiempo_restante, 0));
                tiempoAgotado();
            }
        };
        temporizador.start();
    }

    private void cancelarTemporizador() {
        if (temporizador != null) {
            temporizador.cancel();
            temporizador = null;
        }
    }

    private void actualizarPuntos() {
        txtPuntos.setText(getString(R.string.puntos, puntuacion));
    }

    @Override
    public void onClick(View v) {
        if (respondiendo) return;
        respondiendo = true;
        cancelarTemporizador();

        int opcionElegida;
        if (v == btnResp1) opcionElegida = 0;
        else if (v == btnResp2) opcionElegida = 1;
        else if (v == btnResp3) opcionElegida = 2;
        else opcionElegida = 3;

        Pregunta p = preguntas.get(indiceActual);
        boolean correcta = (opcionElegida == p.getIndiceCorrecta());
        if (correcta) {
            puntuacion++;
            Toast.makeText(this, R.string.respuesta_correcta, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.respuesta_incorrecta, Toast.LENGTH_SHORT).show();
        }
        actualizarPuntos();

        if (indiceActual == preguntas.size() - 1) {
            terminarPartida();
        } else {
            indiceActual++;
            mostrarPregunta();
        }
    }

    private void tiempoAgotado() {
        if (respondiendo) return;
        respondiendo = true;
        cancelarTemporizador();
        Toast.makeText(this, getString(R.string.respuesta_incorrecta) + " (tiempo agotado)", Toast.LENGTH_SHORT).show();
        actualizarPuntos();
        if (indiceActual == preguntas.size() - 1) {
            terminarPartida();
        } else {
            indiceActual++;
            mostrarPregunta();
        }
    }

    private void terminarPartida() {
        cancelarTemporizador();
        Intent i = new Intent(this, ResultadoActivity.class);
        i.putExtra("NOMBRE", nombre);
        i.putExtra("PUNTUACION", puntuacion);
        startActivity(i);
        finish(); // Al volver atrás desde el resultado no se regresa a la partida
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cancelarTemporizador();
    }
}
