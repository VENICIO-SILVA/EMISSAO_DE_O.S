package br.com.project.controller;

import br.com.project.dao.Dao;
import br.com.project.domain.OrdensDeServico;

import javax.swing.*;
import java.sql.Timestamp;

public class CadastrarOS {
 public OrdensDeServico cadastrarOS(JTextField Numeros, JTextField DataOs, JTextField Equipamento, JTextField servico, JTextField defeito,JTextField tecnico, JTextField valor){
     Dao conexao = new Dao();
     conexao.IniciarConexao();
     OrdensDeServico InsertOs = new OrdensDeServico();
     try {
         InsertOs.setOs(Integer.parseInt(Numeros.getText()));

         InsertOs.setData_os(Timestamp.valueOf(DataOs.getText()));

         InsertOs.setEquipamento(Equipamento.getText());

         InsertOs.setServico(servico.getText());

         InsertOs.setDefeito(defeito.getText());

         InsertOs.setTecnico(tecnico.getText());

         conexao.em.getTransaction().begin();
         conexao.em.persist(InsertOs);
         conexao.em.getTransaction().commit();

     }catch (Exception e ){
         JOptionPane.showMessageDialog(null, "Erro de conexao" + e.getMessage());
     }finally {
         conexao.FecharConexao();
     }
     return InsertOs;
 }
}
