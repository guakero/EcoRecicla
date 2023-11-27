package com.dario.ecorecicla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.dario.ecorecicla.modelos.FileManager;
import com.dario.ecorecicla.modelos.Herramientas;

import java.io.File;
import java.io.InputStream;

public class Consejos extends AppCompatActivity implements View.OnClickListener{
    public ImageButton btnPapelConsejos;
    public ImageButton btnPlasticosConsejos;
    public ImageButton btnElectronicosConsejos;
    public ImageButton btnAceiteConsejos;
    public ImageButton btnVidrioConsejos;
    public ImageButton btnOrganicosConsejos;
    public ImageButton btnBateriasConsejos;
    public ImageButton btnTextilesConsejos;
    public TextView textViewConsejos;
    public TextView textViewTituloConsejos;
    public ImageView imageViewConsejos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consejos);

        btnPapelConsejos = findViewById(R.id.imButtonPapelConsejos);
        btnPapelConsejos.setOnClickListener(this);
        btnPlasticosConsejos = findViewById(R.id.imagButonPlasticosConsejos);
        btnPlasticosConsejos.setOnClickListener(this);
        btnElectronicosConsejos = findViewById(R.id.imagButonElectronicosConsejos);
        btnElectronicosConsejos.setOnClickListener(this);
        btnAceiteConsejos = findViewById(R.id.imagButonAceiteConsejos);
        btnAceiteConsejos.setOnClickListener(this);
        btnVidrioConsejos = findViewById(R.id.imagButonVidrioConsejos);
        btnVidrioConsejos.setOnClickListener(this);
        btnOrganicosConsejos = findViewById(R.id.imagButonOrganicosConsejos);
        btnOrganicosConsejos.setOnClickListener(this);
        btnBateriasConsejos = findViewById(R.id.imagButonBateriasConsejos);
        btnBateriasConsejos.setOnClickListener(this);
        btnTextilesConsejos = findViewById(R.id.imagButonTextilesConsejos);
        btnTextilesConsejos.setOnClickListener(this);

        textViewConsejos= findViewById(R.id.textViewConsejos);
        textViewTituloConsejos = findViewById(R.id.tituloConsejos);
        imageViewConsejos = findViewById(R.id.imgViewConsejos);


    }
    @Override
    public void onClick(View v){
        // no dejo hacer swicht por que el id de resource no es final
        if(v.getId()==R.id.imButtonPapelConsejos ){
            imprimirConsejo(R.raw.consejospapel, R.drawable.note_stack_fill0_wght400_grad0_opsz24,"Papel");
        }else if (v.getId()==R.id.imagButonPlasticosConsejos) {
            imprimirConsejo(R.raw.consejosplasticos, R.drawable.local_dining_fill0_wght400_grad0_opsz24,"Plasticos");
        }else if (v.getId()==R.id.imagButonElectronicosConsejos) {
            imprimirConsejo(R.raw.consejoselectronicos, R.drawable.devices_other_fill0_wght400_grad0_opsz24,"Electronicos");
        }else if (v.getId()==R.id.imagButonAceiteConsejos) {
            imprimirConsejo(R.raw.consejosaceite, R.drawable.format_color_fill_fill0_wght400_grad0_opsz24,"Aceite");
        }else if (v.getId()==R.id.imagButonVidrioConsejos) {
            imprimirConsejo(R.raw.consejosvidrio, R.drawable.liquor_fill0_wght400_grad0_opsz24,"Vidrio");
        }else if (v.getId()==R.id.imagButonOrganicosConsejos) {
            imprimirConsejo(R.raw.consejosorganicos, R.drawable.compost_fill0_wght400_grad0_opsz24,"Organicos");
        } else if (v.getId()==R.id.imagButonBateriasConsejos) {
            imprimirConsejo(R.raw.consejosbaterias, R.drawable.battery_full_fill0_wght400_grad0_opsz24,"Baterías");
        }else {
            imprimirConsejo(R.raw.consejostextiles, R.drawable.local_dining_fill0_wght400_grad0_opsz24,"Textiles");
        }

    }

    private void imprimirConsejo(int resourceId, int drawableId,String tituloConsejo) {
        textViewTituloConsejos.setText(tituloConsejo);
        imageViewConsejos.setImageResource(drawableId);
        Resources resources = getApplicationContext().getResources();
        InputStream inputStream = resources.openRawResource(resourceId);
        String textoConsejos = FileManager.LeerArchivo(inputStream);
        textViewConsejos.setText(textoConsejos);
    }

}

