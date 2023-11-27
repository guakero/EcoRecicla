package com.dario.ecorecicla;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dario.ecorecicla.modelos.FileManager;

public class Login extends AppCompatActivity {
    public Button iniciarSesionBtn;
    public boolean loginStatus;
    public EditText editTextNombreLogin;
    public EditText editTextPswLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // se genera el objeto preferencias de tipo shared preferences
        SharedPreferences preferencias= PreferenceManager.getDefaultSharedPreferences(this);
        loginStatus = preferencias.getBoolean("Log Out status",false);
        // se genera un objeto editor de shared preferences para editarlas en el boton de abajo
        SharedPreferences.Editor editor = preferencias.edit();

        iniciarSesionBtn = findViewById(R.id.btnIniciarSesion);
        editTextNombreLogin = findViewById(R.id.usuarioLogin);
        editTextPswLogin = findViewById(R.id.pswLogin);

        iniciarSesionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuarioInput = String.valueOf(editTextNombreLogin.getText());
                String pswLoginInput = String.valueOf(editTextPswLogin.getText());
                String nombreArchivo = "usuario: "+usuarioInput+".txt";
                // si existe el usuario
                if (FileManager.VerificarExistenciaArchivo(getFilesDir(),nombreArchivo)){
                    //validacion del psw
                    if (FileManager.ValidarExistenciadeDato(getFilesDir(),nombreArchivo,pswLoginInput)){
                        editor.putBoolean("Log Out status", true);
                        editor.apply();
                        startActivity(new Intent(Login.this, Home.class));
                        finish();
                    }else{
                        alertDialog("el pasword es incorrecto");
                    }

                }else {
                    alertDialog("El usuario no existe");
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

                        dialog.cancel();
                    }
                });
        builder.show();
    }
}