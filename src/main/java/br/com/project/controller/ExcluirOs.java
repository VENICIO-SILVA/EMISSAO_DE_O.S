package br.com.project.controller;

import br.com.project.dao.Dao;
import br.com.project.domain.OrdensDeServico;

import javax.swing.*;

//todo Nao esta pronta vai ser usada depois
public class ExcluirOs {
    public OrdensDeServico ExcluirOs(JTextField Numero_Os){
        Dao conexao = new Dao();
        conexao.IniciarConexao();
        OrdensDeServico OS = new OrdensDeServico();
        try {
            int NOS = Integer.parseInt(Numero_Os.getText());
            conexao.em.getTransaction().begin();
            conexao.em.find(OrdensDeServico.class,OS.getOs());
            conexao.em.getTransaction().commit();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro de conexao com banco de dados" + e.getMessage());

        }finally {
            conexao.FecharConexao();
        }
        return OS;
    }
}
