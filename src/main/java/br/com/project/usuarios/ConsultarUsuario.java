package br.com.project.usuarios;

import br.com.project.conexao.Dao;
import jakarta.persistence.TypedQuery;

import java.util.List;

import javax.swing.*;

public class ConsultarUsuario {

    public Clientes Consulta(JTextField nomeCli) {
        Dao conexao = new Dao();//conexao com banco
        conexao.IniciarConexao();
        Clientes cliente = new Clientes();
        try {
            String jpql = "SELECT u FROM Clientes u WHERE u.nome = :nome";//select na coluna usuario/nome do admin
            TypedQuery<Clientes> query = conexao.em.createQuery(jpql, Clientes.class);
            query.setParameter("nome", nomeCli.getText());//faz a consulta apenas do nome do usuario
            List<Clientes> list = query.getResultList();
            cliente = list.get(0);
            if (cliente.getNome().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Cliente nao existe");
                return null;
            } else {
                return cliente;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

