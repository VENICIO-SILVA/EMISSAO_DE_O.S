package br.com.project.controller;

import br.com.project.dao.Dao;
import br.com.project.domain.Clientes;
import br.com.project.domain.OrdensDeServico;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;

public class CadastrarOS {
    public OrdensDeServico cadastrarOS(JRadioButton Orcamento, JComboBox<String> Status, JTextField DataOs, JTextField Equipamento, JTextField servico, JTextField defeito, JTextField tecnico, JTextField valor, JTextField ChaveEstrangeira) {
        Dao conexao = new Dao();
        conexao.IniciarConexao();
        OrdensDeServico InsertOs = new OrdensDeServico();
        try {

            InsertOs.setData_os(new Timestamp(System.currentTimeMillis()));

            InsertOs.setEquipamento(Equipamento.getText());

            InsertOs.setServico(servico.getText());

            InsertOs.setDefeito(defeito.getText());

            InsertOs.setTecnico(tecnico.getText());

            InsertOs.setValor(Double.parseDouble(valor.getText()));

            InsertOs.setTipo(Orcamento.getText());

            InsertOs.setStatus(Status.getSelectedItem().toString());

            int idCli = Integer.parseInt(ChaveEstrangeira.getText());

            Clientes cliente = conexao.em.find(Clientes.class, idCli);
            if (cliente == null) {
                JOptionPane.showMessageDialog(null, "cliente nao encontrado");
            } else {
                InsertOs.setCliente(cliente);
                conexao.em.getTransaction().begin();
                conexao.em.persist(InsertOs);
                conexao.em.getTransaction().commit();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de conexao" + e.getMessage());
        } finally {
            conexao.FecharConexao();
        }
        JOptionPane.showMessageDialog(null, "Ordem de Serviço Emitida Com Sucesso!");
        return InsertOs;
    }
}
