package com.example.aluno.aula2803;

import java.util.Date;

/**
 * Created by aluno on 16/04/18.
 */

public class Pessoa {
    private long id;
    private String nome;
    private String telefone;
    private String apelido;
    private String img_url;

    public Pessoa(){
    }

    public Pessoa(long id, String nome, String telefone, String apelido, String img_url) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.apelido = apelido;
        this.img_url = img_url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getImgUrl() {
        return img_url;
    }

    public void setImgUrl(String img_url) {
        this.img_url = img_url;
    }
}