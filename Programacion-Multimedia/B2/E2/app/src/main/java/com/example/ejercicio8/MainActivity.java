package com.example.tuapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText txtNombre, txtApellido;
    Button btnIr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        btnIr = findViewById(R.id.btnIr);

        btnIr.setOnClickListener(v -> {

            String nombre = txtNombre.getText().toString();
            String apellido = txtApellido.getText().toString();

            Intent intent = new Intent(
                    MainActivity.this,
                    SegundaActivity.class
            );

            intent.putExtra("nombre", nombre);
            intent.putExtra("apellido", apellido);

            startActivity(intent);
        });
    }
}