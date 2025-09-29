package br.com.project.usuarios;

import jakarta.persistence.*;

@Entity
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCli;

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

    public Clientes() {

    }

    public Clientes(String nome, String Endereco, String telefone, String gmail) {
        super();
        this.nome = nome;
        this.Endereco = Endereco;
        this.telefone = telefone;
        this.gmail = gmail;
    }

    public Long getIdCli() {
        return idCli;
    }

    public void setIdCli(Long idCli) {
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
}
