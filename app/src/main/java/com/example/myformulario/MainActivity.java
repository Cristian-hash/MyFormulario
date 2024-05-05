package com.example.myformulario;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    EditText nombre,apellidos,edad,correo;
    Button aceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        nombre      = (EditText)findViewById(R.id.editNombre);
        apellidos   = (EditText)findViewById(R.id.editApellidos);
        edad        = (EditText)findViewById(R.id.editEdad);
        correo      = (EditText)findViewById(R.id.editCorreo);
        aceptar     = (Button)findViewById(R.id.btnAceptar);

 aceptar.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         String name = nombre.getText().toString();
         String ape = apellidos.getText().toString();
         String age = edad.getText().toString();
         String email = correo.getText().toString();

         Intent i = new Intent(MainActivity.this, MostrarDatos.class);

         i.putExtra("name",name);
         i.putExtra("ape",ape);
         i.putExtra("age",age);
         i.putExtra("email",email);

         startActivity(i);
     }
 });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}