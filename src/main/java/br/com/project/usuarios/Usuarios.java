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
    @Column(unique = true, nullable = false)
    private String gmail_login;
    private String senha;
    private String Perfil;

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

    public String getGmail_login() {
        return gmail_login;
    }

    public void setGmail_login(String gmail_login) {
        this.gmail_login = gmail_login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return Perfil;
    }

    public void setPerfil(String perfil) {
        Perfil = perfil;
    }
}
