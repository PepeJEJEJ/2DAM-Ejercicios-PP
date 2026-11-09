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

        EditText edtNombre = findViewById(R.id.edtNombre);
        Button btnJugar = findViewById(R.id.btnJugar);
        Button btnRanking = findViewById(R.id.btnRanking);

        btnJugar.setOnClickListener(v -> {
            String nombre = edtNombre.getText().toString().trim();
            if (nombre.isEmpty()) {
                edtNombre.setError(getString(R.string.error_nombre));
                edtNombre.requestFocus();
                return;
            }
            Intent i = new Intent(this, JuegoActivity.class);
            i.putExtra("NOMBRE", nombre);
            startActivity(i);
        });

        btnRanking.setOnClickListener(v ->
                startActivity(new Intent(this, RankingActivity.class)));
    }
}