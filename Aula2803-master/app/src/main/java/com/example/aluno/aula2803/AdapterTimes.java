package com.example.aluno.aula2803;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aluno on 28/03/18.
 */

public class AdapterTimes extends BaseAdapter{

    Context contexto;
    List<Pessoa> pessoas;

    public AdapterTimes(Context contexto, List<Pessoa> pessoas) {
        this.contexto = contexto;
        this.pessoas = pessoas;
    }

    @Override
    public int getCount() {
        return pessoas.size();
    }

    @Override
    public Object getItem(int position) {
        return pessoas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return pessoas.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewLinha = LayoutInflater.from(contexto).inflate(R.layout.linha_lista_times,parent,false);

        TextView nome = (TextView) viewLinha.findViewById(R.id.textViewNome);
        TextView apelido = (TextView) viewLinha.findViewById(R.id.textViewApelido);

        Pessoa pessoa = pessoas.get(position);
        nome.setText(pessoa.getNome());
        apelido.setText(pessoa.getApelido());

        return viewLinha;
    }
}
