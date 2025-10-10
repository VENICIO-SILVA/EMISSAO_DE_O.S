package br.com.project.usuarios;

import br.com.project.conexao.Dao;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class ConsultarUsuario {

    public List<Object> Consulta(JTextField nomeCli) {
        Dao conexao = new Dao();
        conexao.IniciarConexao();

        List<Object> resultados = new ArrayList<>();

        try {
            // Busca Clientes
            String jpql = "SELECT c FROM Clientes c WHERE c.nome = :nome";
            TypedQuery<Clientes> query = conexao.em.createQuery(jpql, Clientes.class);
            query.setParameter("nome", nomeCli.getText());
            resultados.addAll(query.getResultList());

            // Busca Usuários
            String jpql2 = "SELECT u FROM Usuarios u WHERE u.usuario = :usuario";
            TypedQuery<Usuarios> query2 = conexao.em.createQuery(jpql2, Usuarios.class);
            query2.setParameter("usuario", nomeCli.getText());
            resultados.addAll(query2.getResultList());

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
