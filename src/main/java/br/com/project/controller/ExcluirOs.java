package br.com.project.controller;

import br.com.project.dao.Dao;
import br.com.project.domain.OrdensDeServico;

import javax.swing.*;

public class ExcluirOs {
    public OrdensDeServico ExcluirOs(JTextField Numero_Os) {
        Dao conexao = new Dao();
        conexao.IniciarConexao();
        OrdensDeServico OS = new OrdensDeServico();
        try {
            int NºOS = Integer.parseInt(Numero_Os.getText());
            OS = conexao.em.find(OrdensDeServico.class, NºOS);

            if (OS != null) {
                conexao.em.getTransaction().begin();
                conexao.em.remove(OS);
                conexao.em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "OS exlcuidad com sucesso");

            } else {
                JOptionPane.showMessageDialog(null, "OS nao encontrada");
                return null;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de conexao com banco de dados" + e.getMessage());

        } finally {
            conexao.FecharConexao();
        }
        return OS;
    }
}
