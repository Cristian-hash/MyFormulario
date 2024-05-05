package com.example.myformulario;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MostrarDatos extends AppCompatActivity {
    TextView tvnombre,tvapellidos,tvedad,tvcorreo;
    Button btnOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mostrar_datos);

        tvnombre = (TextView)findViewById(R.id.tvNombre);
        tvapellidos = (TextView)findViewById(R.id.tvApellidos);
        tvedad = (TextView)findViewById(R.id.tvEdad);
        tvcorreo = (TextView)findViewById(R.id.tvCorreo);
        btnOk = (Button)findViewById(R.id.btnOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MostrarDatos.this,MainActivity.class);
                startActivity(intent);
            }
        });

        mostrarDato();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void mostrarDato() {
        Bundle datos = this.getIntent().getExtras();
        String nombre = datos.getString("name");
        String apellidos = datos.getString("ape");
        String edad = datos.getString("age");
        String correo = datos.getString("email");
        tvnombre.setText(nombre);
        tvapellidos.setText(apellidos);
        tvedad.setText(edad);
        tvcorreo.setText(correo);
    }
}