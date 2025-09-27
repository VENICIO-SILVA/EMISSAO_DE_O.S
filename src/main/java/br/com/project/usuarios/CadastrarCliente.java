package br.com.project.usuarios;

import br.com.project.conexao.Dao;

import javax.swing.*;

public class CadastrarCliente {
   public Clientes Cadastrar(JTextField nome,JTextField telefone, JTextField endereco, JTextField gmail){
        Dao conexao = new Dao();
        conexao.IniciarConexao();
        Clientes InserirCLiente = new Clientes();
        try {

        InserirCLiente.setNome(nome.getText());
        InserirCLiente.setEndereco(endereco.getText());
        InserirCLiente.setTelefone(telefone.getText());
        InserirCLiente.setGmail(gmail.getText());
        conexao.em.getTransaction().begin();
        conexao.em.persist(InserirCLiente);
        conexao.em.getTransaction().commit();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro de Insert");
        }finally {
            conexao.FecharConexao();
        }
       return InserirCLiente;
   }
}
