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


            if(nombre.equals("")||usuarioStr.equals("")||psw.equals("")||pswR.equals("") ){
                alertDialog("Por favor llene todos los capos",usuarioStr);
            } else if (!checkTerminos.isChecked()) {
                alertDialog("Por favor acepte los terminos",usuarioStr);
            } else if (!psw.equals(pswR)) {
                alertDialog("Las contraseñas introducidas no coinciden",usuarioStr);
            } else{
                User usuario = new User(nombre,usuarioStr,psw);
                if (usuario.guardarUsuario(usuario,getFilesDir())){
                    alertDialog("El usuario "+ usuarioStr +"a sido creado con exito",usuarioStr);
                    usuarioCreado = true;
                }else {
                    alertDialog("El usuario ya existe",usuarioStr);
                }

            }

        }
    });

    }

    private void alertDialog (String alerta, String usuarioStr) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(alerta)
                .setCancelable(false)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Acción al presionar el botón Aceptar
                        if(usuarioCreado ){
                            startActivity(new Intent(CreateAccount.this, RegistroCompletado.class).putExtra("user",usuarioStr));
                            finish();
                        }
                        dialog.cancel();
                    }
                });
        builder.show();
    }
}