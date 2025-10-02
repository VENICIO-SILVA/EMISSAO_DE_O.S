package br.com.project.usuarios;

import br.com.project.conexao.Dao;

import javax.swing.*;

public class CadastrarCliente {
    public Clientes Cadastrar(JTextField nome, JTextField telefone, JTextField senha, JTextField endereco, JTextField gmail) {
        Dao conexao = new Dao();
        conexao.IniciarConexao();
        Clientes InserirCLiente = new Clientes();
        try {
            if (nome.getText().isEmpty() && telefone.getText().isEmpty() &&
                    endereco.getText().isEmpty() && gmail.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Preencha todos os campos");
                return InserirCLiente;//aqui eu retorno para nao precisar passar pelas verificações seguintes
            }
            boolean valido = true;
            //os "false" fazem a verificação continuar e caso encontrar "true" quer dizer q o campo esta preenchido e vai passar para a outra verificação
            if (nome.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "E obrigatorio fornecer um Nome de Usuário");
                valido = false;
            }

            if (telefone.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "E obrigatorio fornecer numero para contato");
                valido = false;
            }

            if (endereco.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha o campo Endereço");
                valido = false;
            }

            if (gmail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "E obrigatorio fornecer um E-mail");
                valido = false;
            }
            if (!valido) {
                return InserirCLiente;
            } else {

                InserirCLiente.setNome(nome.getText());
                InserirCLiente.setEndereco(endereco.getText());
                InserirCLiente.setSenha(senha.getText());
                InserirCLiente.setTelefone(telefone.getText());
                InserirCLiente.setGmail(gmail.getText());
                //A linha abaixo dara automaticamente a indentidade de cliente na coluna perfil do banco de dados
                InserirCLiente.setPerfil("Cliente");
                conexao.em.getTransaction().begin();
                conexao.em.persist(InserirCLiente);
                conexao.em.getTransaction().commit();
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            conexao.FecharConexao();
        }
        return InserirCLiente;
    }
}
