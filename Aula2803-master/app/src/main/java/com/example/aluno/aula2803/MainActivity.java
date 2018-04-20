package com.example.aluno.aula2803;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{

    private ListView listViewTimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewTimes = (ListView) findViewById(R.id.listTimes);

        listViewTimes.setOnItemClickListener(this);
        listViewTimes.setOnItemLongClickListener(this);
    }

    public void chamarTelaImagem(View view){
        Intent intent = new Intent(this, ApresentarImagem.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        preencherLista();
    }

    public void preencherLista(){
        List<Pessoa> listaTimes = new ArrayList<>();
        listaTimes  = new DAOTimes(this).buscarTodos();
        AdapterTimes adapter = new AdapterTimes(this, listaTimes);
        listViewTimes.setAdapter(adapter);
    }

    public void chamarFormulario(View view){
        Intent intent = new Intent(this,FormularioTimes.class);
        startActivity(intent);
    }

    public void chamarSegundaTela(View view){
        Intent intent = new
                Intent(this, SegundaTela.class);
        intent.putExtra("timeCampeao","Palmeiras");
        intent.putExtra("titulosBrasileiro",10);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("MainActivity", parent.getItemAtPosition(position).toString());

        Pessoa time = (Pessoa) parent.getItemAtPosition(position);
        Intent intent = new Intent(this, FormularioTimes.class);
        intent.putExtra("id",time.getId());
        startActivity(intent);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("MainActivity", parent.getItemAtPosition(position).toString());
        final Pessoa pessoa = (Pessoa) parent.getItemAtPosition(position);
        final DAOTimes dao = new DAOTimes(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Sim para excluir / Não para ver imagem")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dao.remover(pessoa);
                        preencherLista();
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(MainActivity.this, ApresentarImagem.class);
                        intent.putExtra("id",pessoa.getId());
                        startActivity(intent);
                    }
                });

        builder.show();
        return true;
    }
}
