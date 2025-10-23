package br.com.project.controller;

import br.com.project.dao.Dao;
import br.com.project.domain.OrdensDeServico;
import jakarta.persistence.TypedQuery;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class ConsultarOs {

    public List<OrdensDeServico> Consulta(JTextField idcli) {
        Dao conexao = new Dao();
        conexao.IniciarConexao();
        List<OrdensDeServico> resultados = new ArrayList<>();

        try {
            String texto = idcli.getText().trim(); // remove espaços no começo e no fim

            if (texto.isEmpty()) {
                return resultados; // ou apenas sai do método
            }
            //essa verificação serve para caso a seja digitado uma letra no campo de pesquisa nao caia no catch Exception
            if (texto.matches("[a-zA-Z]+")) {
                return resultados;
            }
            String jpql = "SELECT c FROM OrdensDeServico c WHERE c.cliente.id = :idcli";
            TypedQuery<OrdensDeServico> query = conexao.em.createQuery(jpql, OrdensDeServico.class);
            query.setParameter("idcli", Integer.parseInt(idcli.getText()));
            resultados.addAll(query.getResultList());
            if (resultados.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Este Cliente nao possui OS em aberto");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão com banco de dados: " + e.getMessage());
        } finally {
            conexao.FecharConexao();
        }

        return resultados;
    }
}
