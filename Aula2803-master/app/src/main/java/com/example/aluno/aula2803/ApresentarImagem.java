package com.example.aluno.aula2803;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ApresentarImagem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apresentar_imagem);

        Bundle bundle = getIntent().getExtras();
        Long id = bundle.getLong("id");

        DAOTimes dao = new DAOTimes(this);
        Pessoa pessoa =  dao.buscarId(id);

        BuscarImagem buscarImagem = new BuscarImagem(ApresentarImagem.this);
        buscarImagem.execute(pessoa.getImgUrl());
    }
}