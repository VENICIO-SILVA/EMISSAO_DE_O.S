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
        //todo ja tem a correção no chatgpt estudar para entender a logica da consulta pela chave estrangeira
        List<OrdensDeServico> resultados = new ArrayList<>();

        try {
            String jpql = "SELECT c FROM OrdensDeServico c WHERE c.idcli LIKE :idcli";
            TypedQuery<OrdensDeServico> query = conexao.em.createQuery(jpql, OrdensDeServico.class);
            query.setParameter("idcli", "%" + idcli.getText() + "%");
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
