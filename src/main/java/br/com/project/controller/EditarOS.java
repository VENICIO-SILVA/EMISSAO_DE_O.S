package br.com.project.controller;

import br.com.project.dao.Dao;
import br.com.project.domain.OrdensDeServico;

import javax.swing.*;
import java.sql.Timestamp;

public class EditarOS {
    public OrdensDeServico Editar(JTextField NOS, JTextField data, JTextField equipamento, JTextField servico, JTextField defeito, JTextField tec, JTextField Tipo, JComboBox<String> Status, JTextField valor) {
        Dao conexao = new Dao();
        conexao.IniciarConexao();
        OrdensDeServico Update = new OrdensDeServico();
        try {
            //1 captura o numero da ordem de serviço
            int os = Integer.parseInt(NOS.getText());

            //2 consulta no banco de dados a ordem
            Update = conexao.em.find(OrdensDeServico.class, os);

            //3 verifica se a ordem existe no banco de dados
            if (Update == null) {
                System.out.println("Nenhum ordem de serviço encontrada");
                return null;
            } else {

                // 4 muda os dados
                Update.setData_os(new Timestamp(System.currentTimeMillis()));
                Update.setEquipamento(equipamento.getText());
                Update.setDefeito(defeito.getText());
                Update.setServico(servico.getText());
                Update.setTecnico(tec.getText());
                Update.setTipo(Tipo.getText());
                Update.setStatus(Status.getSelectedItem().toString());

                Update.setValor(Double.parseDouble(valor.getText()));

                //todo corrigir o radiobutton status
                //5- att no banco
                conexao.em.getTransaction().begin();
                conexao.em.merge(Update);
                conexao.em.getTransaction().commit();
                System.out.println("Ordem atualizada com sucesso");

            }
        } catch (Exception e) {
            System.out.println(e.getCause());
        } finally {
            conexao.FecharConexao();
        }
        return Update;
    }
}
