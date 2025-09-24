package br.com.project.usuarios;

import jakarta.persistence.*;

//essa classe é usada para Obter dados da tabela clientes.
@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IdUser;

    private String usuario;
    private String telefone;
    private String gmail;
    private String senha;

    public long getIdUser() {
        return IdUser;
    }

    public void setIdUser(long idUser) {
        IdUser = idUser;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
