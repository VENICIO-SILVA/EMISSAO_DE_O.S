package br.com.project.service;

import br.com.project.dao.Dao;
import br.com.project.domain.OrdensDeServico;
import jakarta.persistence.TypedQuery;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

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
            String jpql =
                    "SELECT o FROM OrdensDeServico o " +
                            "WHERE CAST(o.os AS string) LIKE :pesquisa " +                 // pesquisar por número da OS
                            "OR CAST(o.cliente.id AS string) LIKE :pesquisa " +           // pesquisar por ID do cliente
                            "OR LOWER(o.cliente.nome) LIKE :pesquisa";

            TypedQuery<OrdensDeServico> query = conexao.em.createQuery(jpql, OrdensDeServico.class);
            query.setParameter("pesquisa", texto.toLowerCase() + "%");

            resultados.addAll(query.getResultList());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão com banco de dados: " + e.getMessage());
        } finally {
            conexao.FecharConexao();
        }

        return resultados;
    }
}
