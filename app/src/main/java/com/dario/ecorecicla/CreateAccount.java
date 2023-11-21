package com.dario.ecorecicla;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.dario.ecorecicla.modelos.User;

public class CreateAccount extends AppCompatActivity {

    private Button btnRegistrarse;
    private EditText editTextNombre;
    private EditText editTextUsuario;
    private EditText editTextPsw;
    private EditText editTextPswR;
    private CheckBox checkTerminos;
    private Boolean usuarioCreado = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

    btnRegistrarse = findViewById(R.id.btnCreateAccount);
    editTextNombre = findViewById(R.id.edit_text_nombre);
    editTextUsuario = findViewById(R.id.edit_text_usuario);
    editTextPsw = findViewById(R.id.edit_text_psw);
    editTextPswR = findViewById(R.id.edit_text_psw_repeat);
    checkTerminos = findViewById(R.id.checkTerminos);


        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String nombre = String.valueOf(editTextNombre.getText());
            String usuarioStr = String.valueOf(editTextUsuario.getText());
            String psw = String.valueOf(editTextPsw.getText());
            String pswR = String.valueOf(editTextPsw.getText());
            String usuarioData = nombre + ", "+ usuarioStr + ", "+ psw;

            if(nombre.equals("")||usuarioStr.equals("")||psw.equals("")||pswR.equals("") ){
                alertDialog("Por favor llene todos los capos");
            } else if (!checkTerminos.isChecked()) {
                alertDialog("Por favor acepte los terminos");
            } else if (psw!=pswR) {
                alertDialog("Las contraseñas introducidas no coinciden");
            } else{
                User usuario = new User(nombre,usuarioStr,psw);
                usuario.setUsuario(usuarioData);
                alertDialog("El usuario a sido creado con exito");
                usuarioCreado = true;

            }


        }
    });

    }

    private void alertDialog (String alerta) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(alerta)
                .setCancelable(false)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Acción al presionar el botón Aceptar
                        if(usuarioCreado ){
                            startActivity(new Intent(CreateAccount.this, RegistroCompletado.class));
                            finish();
                        }
                        dialog.cancel();
                    }
                });
        builder.show();
    }
}