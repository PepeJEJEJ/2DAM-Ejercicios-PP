package com.example.ej1_botoncontador;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView txtContador;
    Button btnContar;
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtContador = findViewById(R.id.txtContador);
        btnContar = findViewById(R.id.btnContar);

        btnContar.setOnClickListener(v -> {
            contador++;
            txtContador.setText(String.valueOf(contador));
        });
    }
}