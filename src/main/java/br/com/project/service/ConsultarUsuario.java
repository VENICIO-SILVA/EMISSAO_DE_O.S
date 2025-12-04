package br.com.project.service;

import br.com.project.dao.Dao;
import br.com.project.domain.Clientes;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class ConsultarUsuario {

    public List<Clientes> Consulta(JTextField nomeCli) {
        Dao conexao = new Dao();
        conexao.IniciarConexao();

        List<Clientes> resultados = new ArrayList<>();

        try {
            String jpql = "SELECT c FROM Clientes c WHERE c.nome LIKE :nome";
            TypedQuery<Clientes> query = conexao.em.createQuery(jpql, Clientes.class);
            query.setParameter("nome", "%" + nomeCli.getText() + "%");
            resultados.addAll(query.getResultList());
            if (resultados.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Usuário não existe");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão com banco de dados: " + e.getMessage());
        } finally {
            conexao.FecharConexao();
        }

        return resultados;
    }
}
