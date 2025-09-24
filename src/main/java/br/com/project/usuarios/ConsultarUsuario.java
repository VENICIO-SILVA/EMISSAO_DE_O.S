package br.com.project.usuarios;

import br.com.project.conexao.Dao;
import jakarta.persistence.TypedQuery;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultarUsuario {
    public Usuarios Login(JTextField login, JPasswordField senha){
        Dao  conexao = new Dao();
        conexao.IniciarConexao();
        try {

            String jpql = " select u from usuarios u where u.Usuarios = :login and u.Usuarios = :senha";
            TypedQuery<Usuarios> query = conexao.em.createQuery(jpql,Usuarios.class);
            query.setParameter("login",login.getText());
            query.setParameter("senha", senha.getPassword());
            List<Usuarios> lista = query.getResultList();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
