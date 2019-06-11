package com.example.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.entity.GrupoFamiliar;
import com.example.entity.Usuario;


public class inicio_vw extends AppCompatActivity {

    Usuario u;
    GrupoFamiliar g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_vw);

        try {
            Bundle parametros = getIntent().getExtras();
            u = (Usuario) parametros.getSerializable("Usuario");
            g = (GrupoFamiliar) parametros.getSerializable("Grupo");
            System.out.println("TESTE: " + u.getNomeUs());
        }catch (Exception e){
            System.out.println("TESTE: " + e.getMessage());
        }
    }

    public void chamarTelaCategoriaGastos(View view){
        startActivity(new Intent(this, escolherCatGastos_vw.class));

    }
    public void chamarTelaLogin(View v){
        startActivity(new Intent(getBaseContext(),login_vw.class));
    }

    public void chamarTelaManterLancamentos(View view){
        startActivity(new Intent(this, manter_lancamentos_vw.class));

    }

    public void chamarTelaCategoriaReceitas(View view){
        startActivity(new Intent(this, escolherCatReceitas_vw.class));

    }

    public void chamarTelaManterPerfil(View view){

        startActivity(new Intent(getBaseContext(), manterPerfil_vw.class));

    }
    public void chamarTelaInicio(View view){
        startActivity(new Intent(this, inicio_vw.class));

    }




}
