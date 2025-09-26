package br.com.project.usuarios;

import br.com.project.conexao.Dao;
import jakarta.persistence.TypedQuery;

import javax.swing.*;
import java.util.List;

public class LoginUsuario {
    public Usuarios Login(JTextField login, JPasswordField senha) {
        Dao conexao = new Dao();
        conexao.IniciarConexao();

        try {
            String jpql = " select u from Usuarios u where u.usuario = :login and u.senha = :senha";
            TypedQuery<Usuarios> query = conexao.em.createQuery(jpql, Usuarios.class);
            query.setParameter("login", login.getText());
            query.setParameter("senha", senha.getPassword());
            List<Usuarios> list = query.getResultList();
            if (list.isEmpty()) {
                return null;
            } else {
                return query.getSingleResult();
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

        }
    }
}

