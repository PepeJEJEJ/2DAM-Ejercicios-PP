package com.example.qizz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText edtNombre;
    private Button btnJugar;
    private Button btnRanking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtNombre = findViewById(R.id.edtNombre);
        btnJugar = findViewById(R.id.btnJugar);
        btnRanking = findViewById(R.id.btnRanking);

        btnJugar.setOnClickListener(v -> {
            String nombre = edtNombre.getText().toString().trim();
            if (nombre.isEmpty()) {
                nombre = "Jugador";
            }
            Intent i = new Intent(MainActivity.this, JuegoActivity.class);
            i.putExtra("NOMBRE", nombre);
            startActivity(i);
        });

        btnRanking.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, RankingActivity.class);
            startActivity(i);
        });
    }
}
