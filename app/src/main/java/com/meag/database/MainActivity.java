package com.meag.database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.meag.database.entidades.DBHelper;

public class MainActivity extends AppCompatActivity {

    private Button btn_registrar,btn_modificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarControles();
        DBHelper.getInstance(this);

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),RegistrarActivity.class);
                startActivity(intent);
            }
        });
        btn_modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ModificarActivity.class);
                startActivity(intent);
            }
        });
    }

    private void inicializarControles() {
        btn_registrar=findViewById(R.id.registrar);
        btn_modificar=findViewById(R.id.modificar);
    }
}
