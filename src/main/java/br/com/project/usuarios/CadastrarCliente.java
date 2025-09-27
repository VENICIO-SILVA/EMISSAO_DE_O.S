package br.com.project.usuarios;

import br.com.project.conexao.Dao;

import javax.swing.*;

public class CadastrarCliente {
    public Clientes Cadastrar(JTextField nome, JTextField telefone, JTextField endereco, JTextField gmail) {
        Dao conexao = new Dao();
        conexao.IniciarConexao();
        Clientes InserirCLiente = new Clientes();
        try {
            //todo organizar quando cada Alerta deve aparecer porque quando os campos estao vazios esta rodando o do email tambem
            if (gmail.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Preencha o campo gmail");
                //como o email é unico no banco de dados se ele vier vazio do campo de inserção ja faço uma verifação para
                //mostrar um erro com letras estranhas na tela ou erro durante a execução
                if (nome.getText().isEmpty() && telefone.getText().isEmpty() && endereco.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha os campos");
                    return InserirCLiente;
                }
            } else {

                InserirCLiente.setNome(nome.getText());
                InserirCLiente.setEndereco(endereco.getText());
                InserirCLiente.setTelefone(telefone.getText());
                InserirCLiente.setGmail(gmail.getText());
                conexao.em.getTransaction().begin();
                conexao.em.persist(InserirCLiente);
                conexao.em.getTransaction().commit();
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seu Gmail nao pode ser igual ao de Alguem ja Cadastrado");
        } finally {
            conexao.FecharConexao();
        }
        return InserirCLiente;
    }
}
