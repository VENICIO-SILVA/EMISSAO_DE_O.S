package br.com.project.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Clientes {

    @Id
    private int idCli;

    @Column(nullable = true)
    private String nome;

    @Column(nullable = true)
    private String Endereco;

    @Column(nullable = true)
    private String telefone;

    @Column(unique = true, nullable = true)
    private String gmail;
    @Column(nullable = false)
    private String perfil;
    private String senha;

    @Column
    private Date data_cadastro;

    public Clientes() {

    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public Clientes(String nome, String Endereco, String telefone, String gmail) {
        super();
        this.nome = nome;
        this.Endereco = Endereco;
        this.telefone = telefone;
        this.gmail = gmail;
    }

    public int getIdCli() {
        return idCli;
    }

    public void setIdCli(int idCli) {
        this.idCli = idCli;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
