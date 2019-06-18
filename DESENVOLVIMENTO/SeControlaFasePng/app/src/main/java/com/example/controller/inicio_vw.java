package com.example.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.entity.GrupoFamiliar;
import com.example.entity.Usuario;

import java.io.Serializable;


public class inicio_vw extends AppCompatActivity {

    Usuario u;
    GrupoFamiliar g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle parametros = getIntent().getExtras();
        u = (Usuario) parametros.getSerializable("Usuario");
        g = (GrupoFamiliar) parametros.getSerializable("Grupo");
        System.out.println("TESTE: " + u.getNomeUs());
        System.out.println("TESTE: " + g.getCodGrupo());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_vw);
    }

    public void chamarTelaCategoriaGastos(View view){
        Bundle parametros = new Bundle();
        parametros.putSerializable("Usuario", u);
        parametros.putSerializable("Grupo", g);

        Intent intent = new Intent(this, escolherCatGastos_vw.class);
        intent.putExtras(parametros);
        startActivity(intent);

    }
    public void chamarTelaLogin(View v){
        startActivity(new Intent(getBaseContext(),login_vw.class));
    }

    public void chamarTelaManterLancamentos(View view){
        Bundle parametros = new Bundle();
        parametros.putSerializable("Usuario", u);
        parametros.putSerializable("Grupo", g);
        String tipo = "DESPESA";
        parametros.putString("tipoEscolhido",tipo);

        Intent intent = new Intent(this, manter_lancamentos_vw.class);
        intent.putExtras(parametros);
        startActivity(new Intent(intent));

    }

    public void chamarTelaCategoriaReceitas(View view){
        Bundle parametros = new Bundle();
        parametros.putSerializable("Usuario", u);
        parametros.putSerializable("Grupo", g);

        Intent intent = new Intent(this, escolherCatReceitas_vw.class);
        intent.putExtras(parametros);
        startActivity(intent);
    }

    public void chamarTelaManterPerfil(View view){
        Bundle parametros = new Bundle();
        parametros.putSerializable("Usuario", u);
        parametros.putSerializable("Grupo", g);

        Intent intent = new Intent(this, manterPerfil_vw.class);
        intent.putExtras(parametros);
        startActivity(new Intent(intent));

    }
    public void chamarTelaInicio(View view){
        Bundle parametros = new Bundle();
        parametros.putSerializable("Usuario", u);
        parametros.putSerializable("Grupo", g);

        Intent intent = new Intent(this, inicio_vw.class);
        intent.putExtras(parametros);
        startActivity(new Intent(intent));
    }




}
