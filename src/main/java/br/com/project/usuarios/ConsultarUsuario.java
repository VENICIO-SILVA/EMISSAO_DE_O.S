package br.com.project.usuarios;

import br.com.project.conexao.Dao;
import jakarta.persistence.TypedQuery;

import java.util.List;

import javax.swing.*;

public class ConsultarUsuario {

    public Object Consulta(JTextField nomeCli) {
        Dao conexao = new Dao();//conexao com banco
        conexao.IniciarConexao();
        Clientes cliente = new Clientes();
        Usuarios usuario = new Usuarios();
        try {
            String jpql = "SELECT u FROM Clientes u WHERE u.nome = :nome";//select na coluna Cliente/nome do admin
            TypedQuery<Clientes> query = conexao.em.createQuery(jpql, Clientes.class);
            query.setParameter("nome", nomeCli.getText());//faz a consulta apenas do nome do usuario
            List<Clientes> list = query.getResultList();
            if (!list.isEmpty()) {
                cliente = list.get(0);
                return cliente;
            } else {
                String jpql2 = "SELECT u FROM Usuarios u WHERE u.usuario = :usuario";
                TypedQuery<Usuarios> query2 = conexao.em.createQuery(jpql2, Usuarios.class);
                query2.setParameter("usuario", nomeCli.getText());//faz a consulta apenas do nome do usuario
                List<Usuarios> list2 = query2.getResultList();
                if (!list2.isEmpty()) {
                    usuario = list2.get(0);
                    return usuario;
                } else {
                    JOptionPane.showMessageDialog(null,"Usuario nao existe");
                    return null;
                }
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            conexao.FecharConexao();
        }
    }
}

