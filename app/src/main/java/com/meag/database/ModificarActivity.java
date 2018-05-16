package com.meag.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.meag.database.entidades.DBHelper;

public class ModificarActivity extends AppCompatActivity {
    private EditText dui,nombre;
    private Button btn_actualizar,btn_limpiar,btn_eliminar,btn_buscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);
        inicializarControles();
        btn_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Persona p= DBHelper.myDB.findUser(dui.getText().toString());
                if(p==null){
                    Toast.makeText(getApplicationContext(),"usuario no encontrado",Toast.LENGTH_SHORT);
                    limpiar();
                }else{
                    nombre.setText(p.getNombre());
                }
            }
        });
        btn_actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.myDB.editUser(new Persona(dui.getText().toString(),nombre.getText().toString()));
            }
        });
        btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.myDB.deleteUser(dui.getText().toString());
                limpiar();
            }
        });
        btn_limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }
        });
    }

    private void limpiar() {
    nombre.setText("");
    dui.setText("");
    }

    private void inicializarControles() {
    dui=findViewById(R.id.dui);
    nombre=findViewById(R.id.nombre);
    btn_buscar=findViewById(R.id.btnbuscar);
    btn_actualizar=findViewById(R.id.btnguardar);
    btn_limpiar=findViewById(R.id.btnlimpiar);
    btn_eliminar=findViewById(R.id.btneliminar);
    }
}
