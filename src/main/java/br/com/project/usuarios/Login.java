package br.com.project.usuarios;

import br.com.project.conexao.Dao;
import jakarta.persistence.TypedQuery;

import javax.swing.*;
import java.util.List;

public class Login {
    public Object Login(JTextField login, JPasswordField senha) {
        Dao conexao = new Dao();
        conexao.IniciarConexao();
        Usuarios user = new Usuarios();
        Clientes clientes = new Clientes();

        //todo  1 coisa  fazer revisar e entender melhore  aprender
        try {
            //os primeiros if verificam os campos
            if (login.getText().isEmpty() && senha.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "E obrigatório Informar os dados para login");

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
                List<Usuarios> listUsuarios = query.getResultList();

                if (!listUsuarios.isEmpty()) {
                    user = listUsuarios.get(0);


                    if ("admin".equalsIgnoreCase(user.getPerfil())) {
                        JOptionPane.showMessageDialog(null, "Login realizado com sucesso como ADMIN!");
                        return user;
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário encontrado mas não é ADMIN");
                        return null;
                    }
                }


                //segunda consulta do banco de dados
                String jpql2 = " select u from Clientes u where u.gmail = :login and u.senha = :senha";
                TypedQuery<Clientes> query2 = conexao.em.createQuery(jpql2, Clientes.class);
                query2.setParameter("login", login.getText());
                query2.setParameter("senha", new String(senha.getPassword()));
                List<Clientes> ListClientes = query2.getResultList();
                //
                if (!ListClientes.isEmpty()) {
                    clientes = ListClientes.get(0);


                    if ("Cliente".equals(clientes.getPerfil())) {
                        JOptionPane.showMessageDialog(null, "Login realizado com sucesso como Cliente!");
                        return clientes;
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário encontrado mas não é ADMIN");
                        return null;
                    }
                }

                JOptionPane.showMessageDialog(null, "Este Usuario nao é ADMIN");
                return null;
            }
        } catch (Exception e) {

        } finally {
            conexao.FecharConexao();
        }
        return null;
    }
}



