package br.com.project.controller;


import br.com.project.dao.Dao;
import br.com.project.domain.OrdensDeServico;

import javax.swing.*;
import java.sql.Timestamp;

public class EditarOS {
    public OrdensDeServico Editar(String NOS, String data, String equipamento, String servico, String defeito, String tec, JRadioButton Tipo, String Status, String valor) {
        Dao conexao = new Dao();
        conexao.IniciarConexao();
        OrdensDeServico Update = new OrdensDeServico();
        try {
            Update.setData_os(new Timestamp(System.currentTimeMillis()));
            Update.setEquipamento(equipamento);
            Update.setDefeito(defeito);
            Update.setServico(servico);
            Update.setTecnico(tec);
            Update.setTipo(Tipo.getText());
            Update.setStatus(Status);
            Update.setValor(Double.parseDouble(valor));
            Update = conexao.em.find(OrdensDeServico.class, NOS);
            if (Update == null) {
                System.out.println("Nenhum ordem de serviço encontrada");
                return null;
            } else {

                conexao.em.getTransaction().begin();
                conexao.em.merge(Update);
                conexao.em.getTransaction().commit();
                System.out.println("Ordem atualizada com sucesso");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de conexao com banco de dados" + e.getLocalizedMessage());
        } finally {
            conexao.FecharConexao();
        }
        return Update;
    }
}
