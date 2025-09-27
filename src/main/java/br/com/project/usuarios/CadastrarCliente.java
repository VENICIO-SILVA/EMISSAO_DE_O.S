package br.com.project.usuarios;

import br.com.project.conexao.Dao;

import javax.swing.*;

public class CadastrarCliente {
   public Clientes Cadastrar(JTextField nome,JTextField telefone, JTextField endereco, JTextField gmail){
        Dao conexao = new Dao();
        conexao.IniciarConexao();
        Clientes InserirCLiente = new Clientes();
        try {
            if(gmail.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Preencha o campo gmail");
            }//como o email é unico no banco de dados se ele vier vazio do campo de inserção ja faço uma verifação para
            //mostrar um erro com letras estranhas na tela ou erro durante a execução

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
