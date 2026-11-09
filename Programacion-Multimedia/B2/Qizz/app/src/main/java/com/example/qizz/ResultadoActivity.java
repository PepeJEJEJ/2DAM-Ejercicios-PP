package com.example.qizz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String nombre = getIntent().getStringExtra("NOMBRE");
        int puntuacion = getIntent().getIntExtra("PUNTUACION", 0);
        if (nombre == null) nombre = "Jugador";

        TextView txtNombre = findViewById(R.id.txtNombreResultado);
        TextView txtPuntuacion = findViewById(R.id.txtPuntuacionResultado);
        txtNombre.setText(getString(R.string.lbl_nombre, nombre));
        txtPuntuacion.setText(getString(R.string.lbl_puntuacion, puntuacion));

        // Guarda la partida en el ranking nada más abrirse, sin pulsar nada
        RankingDB db = new RankingDB(this);
        db.insertar(nombre, puntuacion);

        // Sonido al llegar al resultado (MediaPlayer, se libera al terminar)
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.fin_partida);
        if (mediaPlayer != null) {
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(mp -> mp.release());
        }

        Button btnVerRanking = findViewById(R.id.btnVerRanking);
        Button btnVolverInicio = findViewById(R.id.btnVolverInicio);
        btnVerRanking.setOnClickListener(v ->
                startActivity(new Intent(this, RankingActivity.class)));
        btnVolverInicio.setOnClickListener(v -> {
            Intent i = new Intent(this, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(i);
            finish();
        });
    }
}
