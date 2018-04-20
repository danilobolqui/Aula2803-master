package com.example.aluno.aula2803;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class FormularioTimes extends AppCompatActivity {
    EditText editNome;
    EditText editApelido;
    EditText editTelefone;
    EditText editImgUrl;
    Pessoa pessoa = new Pessoa();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_times);
        editNome = (EditText) findViewById(R.id.editNome);
        editApelido = (EditText) findViewById(R.id.editApelido);
        editTelefone =(EditText)findViewById(R.id.editTelefone);
        editImgUrl =(EditText)findViewById(R.id.editImgUrl);
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null && bundle.containsKey("id")){
            pessoa = new
                    DAOTimes(this).buscarId(bundle.getLong("id"));
            editNome.setText(pessoa.getNome());
            editApelido.setText(pessoa.getApelido());
            editTelefone.setText(pessoa.getTelefone());
            editImgUrl.setText(pessoa.getImgUrl());
        }
    }

    public void salvar(View view){

        pessoa.setNome(editNome.getText().toString());
        pessoa.setApelido(editApelido.getText().toString());
        pessoa.setTelefone(editTelefone.getText().toString());
        pessoa.setImgUrl(editImgUrl.getText().toString());
        DAOTimes dao = new DAOTimes(this);
        if(pessoa.getId()==0){
            dao.inserir(pessoa);
        }else{
            dao.alterar(pessoa);
        }

        Log.i("Formulario","Qtd"+dao.buscarTodos().size());
        finish();

    }
}