package com.example.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.entity.GrupoFamiliar;
import com.example.entity.Usuario;

public class manterPerfil_vw extends AppCompatActivity {
    private Usuario u;
    private GrupoFamiliar g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle parametros = getIntent().getExtras();
        u = (Usuario) parametros.getSerializable("Usuario");
        g = (GrupoFamiliar) parametros.getSerializable("Grupo");
        System.out.println("TESTE: " + u.getNomeUs());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manter_perfil_vw);
    }

    /*
    public void chamarTelaManterPerfil(View view){
        Intent intent = new Intent(getBaseContext(), manterPerfil_vw.class);
        startActivity(intent);
    }
    */

    public void chamarTelaInicio(View view){
        Bundle parametros = new Bundle();
        parametros.putSerializable("Usuario", u);
        parametros.putSerializable("Grupo", g);

        Intent intent = new Intent(this, inicio_vw.class);
        intent.putExtras(parametros);
        startActivity(intent);
    }

    public void acessoCamera(View v){
        //implementar metodo de acesso a camera ou chamar model para o acesso

    }

    public void chamarTelaCadastro(View view){
        Bundle parametros = new Bundle();
        parametros.putSerializable("Usuario", u);
        parametros.putSerializable("Grupo", g);

        Intent intent = new Intent( this, cadastro_vw.class);
        intent.putExtras(parametros);
        startActivity(intent);

    }
}
