package br.com.project.usuarios;

import br.com.project.conexao.Dao;
import jakarta.persistence.TypedQuery;

import javax.swing.*;
import java.util.List;

public class LoginAdmin {
    public Usuarios Login(JTextField login, JPasswordField senha) {
        Dao conexao = new Dao();
        conexao.IniciarConexao();
        Usuarios user = new Usuarios();
        try {
            boolean valido = true;
            if (login.getText().isEmpty() && senha.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "E obrigatório Informar os dados para login");
                valido = false;
                return null;
            }

            if (login.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha o Campo Usuário");
                return null;

            }

            if (senha.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha o Campo Senha");
                return null;
            } else {

                String jpql = " select u from Usuarios u where u.gmail_login = :login and u.senha = :senha";
                TypedQuery<Usuarios> query = conexao.em.createQuery(jpql, Usuarios.class);
                query.setParameter("login", login.getText());
                query.setParameter("senha", new String(senha.getPassword()));
                List<Usuarios> list = query.getResultList();
                user = query.getSingleResult();
                if (list.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Usuário não existe");
                    return null;
                }
                if ("admin".equals(user.getPerfil())){
                    JOptionPane.showMessageDialog(null,"Login realizado com sucesso!");
                    return user;
                }else{
                    JOptionPane.showMessageDialog(null,"Este Usuario nao é ADMIN");
                    return null;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Este Usuario  nao existe");
            return null;
        } finally {
            conexao.FecharConexao();
        }
    }
}


