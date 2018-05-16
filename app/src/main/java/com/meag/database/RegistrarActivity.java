package com.meag.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.meag.database.entidades.DBHelper;

public class RegistrarActivity extends AppCompatActivity {
    private EditText txtdui,txtnombre;
    private Button btn_registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        inicializarControles();
        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = DBHelper.myDB.add(new Persona(txtdui.getText().toString(),txtnombre.getText().toString()));

                if(flag){
                    Log.d("Edit",txtnombre.getText().toString());
                }
            }
        });
    }

    private void inicializarControles() {
        btn_registrar=findViewById(R.id.button_registrar);
        txtdui=findViewById(R.id.edit_text_dui);
        txtnombre=findViewById(R.id.edit_text_nombre);
    }
}
